package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.exceptions.CountryNotFound;
import com.cognizant.springlearn.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia(){
        LOGGER.debug("starting getCountryIndia method");
        return countryService.getCountry();
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        LOGGER.debug("starting getAllCountries method");
        List<Country> countries = countryService.getCountries();
        return countries;
    }

    @GetMapping("/country/{code}")
    public Country getCountyByCode(@PathVariable("code") String countryCode) throws CountryNotFound {
        LOGGER.debug("starting getCountryByCode method");
        return countryService.getCountryByCode(countryCode);
    }
}
