package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cts.exception.CountryNotFoundException;
import com.cts.model.Country;
import com.cts.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CountryController {

	@Autowired
	CountryService service;

	//@RequestMapping(value="countries",method=RequestMethod.GET,produces= "{MediaType.APPLICATION_JSON}")
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		log.info("start");
		List<Country> countries=service.getCountries();
		log.debug("Countries are:{}",countries);
		log.info("end");
		return countries;
		}
	
	
	@GetMapping("/countries/{code}")
	public Country getCountryByCode(@PathVariable("code") String code) throws CountryNotFoundException{
		log.info("start");
		Country country=service.getCountryByCode(code);
		log.debug("Country is:{}",country);
		log.info("end");
		return country;
		}
	@GetMapping("/country")
	public Country getCountryIndia() {
		log.info("start");
		Country country=service.getCountryByIndia();
		log.debug("Country is:{}",country);
		log.info("end");
		return country;
		}
	
	
}
