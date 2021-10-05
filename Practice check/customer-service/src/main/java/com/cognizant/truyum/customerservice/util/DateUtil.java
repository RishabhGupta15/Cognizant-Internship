package com.cognizant.truyum.customerservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date dateFormatter = null;
		try {
			dateFormatter = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormatter;
	}
	
	public static String convertToStringDate(Date date) {
		String dateFormatter = null;
		
			dateFormatter = new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		return dateFormatter;
	}
}
