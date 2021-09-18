package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Country Not Found")
public class CountryNotFoundException extends Exception {

	public CountryNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
