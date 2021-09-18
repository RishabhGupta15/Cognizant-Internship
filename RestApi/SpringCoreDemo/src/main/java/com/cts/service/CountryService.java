package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cts.exception.CountryNotFoundException;
import com.cts.model.Country;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryService {

	
	
	public List<Country> getCountries(){
		log.info("start");
		
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=context.getBean("countryList",ArrayList.class);
	
		log.debug("Countries :{}",countries.toString());
		log.info("End");
		return countries;
	}
	
	public Country getCountryByIndia(){
	log.info("start");
	
	 ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
	Country country=context.getBean("in",Country.class);
	log.debug("Country is :{}",country.toString());
	
	log.info("End");
	return country;
	}
	
	
	public Country getCountryByCode(String code) throws CountryNotFoundException{
		log.info("start");
		

		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=context.getBean("countryList",ArrayList.class);
		
		for (Country c : countries) {
			
			if(c.getCode().equalsIgnoreCase(code)) {
			log.debug("Country is :{}",c.toString());
			return c;	
			}
		}
		throw new CountryNotFoundException("Country not found");
		
		}
}
