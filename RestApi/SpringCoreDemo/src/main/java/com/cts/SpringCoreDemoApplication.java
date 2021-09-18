package com.cts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.model.Country;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringCoreDemoApplication  {
	//private static final Logger LOGGER = LoggerFactory.getLogger(SpringCoreDemoApplication.class);
	
	static ApplicationContext context;
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}
	
	
	static void  displayDate() throws ParseException {
		log.info("start");
		
		context=new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format=context.getBean("dateFormat",SimpleDateFormat.class);
		Date date=format.parse("15/09/2021");
		System.out.println("Date is:"+date);
		log.info("End");
	
	}
	
	static void  displayCountry()  {
		log.info("start");
		
		 context=new ClassPathXmlApplicationContext("country.xml");
		Country country=context.getBean("country",Country.class);
		log.debug("Country :{}",country.toString());
		log.info("End");
	
	}

	
	static void  displayCountries()  {
		log.info("start");
		
		context=new ClassPathXmlApplicationContext("country.xml");
	Object obj=context.getBean("countryList");
		log.debug("Countries :{}",obj.toString());
		log.info("End");
	
	}

}
