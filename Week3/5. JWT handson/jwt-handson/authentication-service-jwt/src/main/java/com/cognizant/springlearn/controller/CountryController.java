package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Pre-existing service from the earlier "Securing RESTful Web Services with
 * Spring Security" hands-on. Used here to verify the security / JWT config,
 * exactly as the doc's curl examples do (GET /countries).
 */
@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return Arrays.asList(
                new Country("US", "United States"),
                new Country("DE", "Germany"),
                new Country("IN", "India"),
                new Country("JP", "Japan")
        );
    }
}
