package com.fil.springcontroller;

import com.fil.springcontroller.entity.AppUser;
import com.fil.springcontroller.repository.UserRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@DataJpaTest
@Testcontainers
public class UserRepositoryTest {

    //Two static
    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");


    @DynamicPropertySource
    static void setDatasourceProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    @Autowired
    private UserRepository userRepository;

    //define unit tests

    @Test
    public void fetchAdllUsers() throws InterruptedException {
        // write test to fetch all users
        AppUser user1 = userRepository.save(new AppUser(null, "user1"));
        List<AppUser> all = userRepository.findAll();
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals("user1", all.get(0).getUsername());
        Thread.sleep(20000);
    }
}
