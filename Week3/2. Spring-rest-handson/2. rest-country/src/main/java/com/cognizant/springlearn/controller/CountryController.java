package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;

/**
 * REST - Country Web Service
 *
 * GET /country -> India country details (loaded from country.xml), returned as JSON.
 * Spring's Jackson message converter (on the classpath via spring-boot-starter-web)
 * automatically serializes the returned Country object to JSON because the class
 * is annotated with @RestController (@Controller + @ResponseBody).
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    public CountryController() {
        LOGGER.debug("Inside CountryController Constructor.");
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);

        LOGGER.debug("Country : {}", country.toString());

        LOGGER.info("END");
        return country;
    }

}
