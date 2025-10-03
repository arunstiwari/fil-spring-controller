package com.fil.springcontroller;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class PostgresContainer {
    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    static {
        postgreSQLContainer.start();
    }

    public static PostgreSQLContainer<?> getInstance() {
        return postgreSQLContainer;
    }

}
