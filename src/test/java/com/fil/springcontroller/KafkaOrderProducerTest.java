package com.fil.springcontroller;

import com.fil.springcontroller.config.KafkaConfig;
import com.fil.springcontroller.entity.OrderCreatedEvent;
import com.fil.springcontroller.producer.KafkOrderProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {KafkOrderProducer.class, KafkaConfig.class})
@Testcontainers
@EnableKafka
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class})

public class KafkaOrderProducerTest {
    static KafkaContainer kafka = new KafkaContainer("apache/kafka");

    @DynamicPropertySource
    static void setKafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Autowired
    private KafkOrderProducer kafkaOrderProducer;

//    @Test
//    public void publishOrderEvent(){
//        kafkaOrderProducer.publish("order123", 250.75);
//    }

    @Test
    void testSendUserEvent() {
        var consumerProps = KafkaTestUtils.consumerProps( kafka.getBootstrapServers(),"testGroup", "true");
        var consumerFactory = new org.springframework.kafka.core.DefaultKafkaConsumerFactory<>(
                consumerProps, new StringDeserializer(), new JsonDeserializer(OrderCreatedEvent.class));

        var consumer = consumerFactory.createConsumer();
        kafka.start();
        consumer.subscribe(java.util.List.of("order-created-events"));
        OrderCreatedEvent event = new OrderCreatedEvent("123", 500);
        kafkaOrderProducer.publish("123", 500);//sendUserCreatedEvent("Alice");

        ConsumerRecord<String, OrderCreatedEvent> record = KafkaTestUtils.getSingleRecord(consumer, "order-created-events");
        assertThat(record.value().getAmount()).isEqualTo(500);
    }

}
