package com.cognizant.springlearn.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "country not in list")
public class CountryNotFound extends Exception{
}
