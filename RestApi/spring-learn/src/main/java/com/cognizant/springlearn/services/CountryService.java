package com.cognizant.springlearn.services;

import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.exceptions.CountryNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    ApplicationContext applicationContext;

    public List<Country> getCountries(){
        applicationContext = new ClassPathXmlApplicationContext("country.xml");
        List<Country> listOfCountries = (ArrayList) applicationContext.getBean("countryList", ArrayList.class);
        return listOfCountries;
    }

    public Country getCountry(){
        applicationContext = new ClassPathXmlApplicationContext("country.xml");
        Country country = applicationContext.getBean("country", Country.class);
        return country;
    }

    public Country getCountryByCode(String code) throws CountryNotFound {
        LOGGER.debug("starting getCountryByCode method");
        applicationContext = new ClassPathXmlApplicationContext("country.xml");
        List<Country> listOfCountries = applicationContext.getBean("countryList", ArrayList.class);
        Country countryFound = null;
        for (Country c : listOfCountries) {

            if(c.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug("Country is :{}",c.toString());
                return c;
            }
        }
        throw new CountryNotFound();

    }
}

