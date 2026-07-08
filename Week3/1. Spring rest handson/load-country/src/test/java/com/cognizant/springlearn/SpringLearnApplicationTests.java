package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringLearnApplicationTests {

    @Test
    void contextLoads() {
        // Verifies that the Spring application context starts up successfully
    }

    @Test
    void countryBeanIsLoadedFromXmlConfig() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);

        assertEquals("IN", country.getCode());
        assertEquals("India", country.getName());
    }

}
