package com.adamwandoch.indeedbot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class IndeedBotApplicationTests {

    @Test
    @DisplayName("CONTEXT LOADS")
    void contextLoads() {

    }
}
