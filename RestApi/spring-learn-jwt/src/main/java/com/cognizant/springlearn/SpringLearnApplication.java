package com.cognizant.springlearn;

import com.cognizant.springlearn.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class SpringLearnApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	static ApplicationContext applicationContext;
	public static void main(String[] args) throws ParseException {

		SpringApplication.run(SpringLearnApplication.class);

		displayDate();
		displayCountry();
		displayCountries();
	}

	public static void displayDate() throws ParseException {
		LOGGER.info("staring displayDate method");
		applicationContext = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat = applicationContext.getBean("dateFormat", SimpleDateFormat.class);
		Date date = dateFormat.parse("12/12/2021");
		LOGGER.info(date.toString());
		LOGGER.info("ending displayDate method");

	}

	public static void displayCountry(){
		LOGGER.info("starting displayCountry method");
		applicationContext = new ClassPathXmlApplicationContext("country.xml");
		Country country = applicationContext.getBean("country", Country.class);
		LOGGER.info(country.toString());
		LOGGER.info("ending display country method");
	}

	public static void displayCountries(){
		LOGGER.info("staring displayCountries method");
		applicationContext = new ClassPathXmlApplicationContext("country.xml");
		List countryList = (ArrayList) applicationContext.getBean("countryList", ArrayList.class);
		LOGGER.info(countryList.toString());
		LOGGER.info("ending display countries method");
	}

}
