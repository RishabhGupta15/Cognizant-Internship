package com.cognizant.truyum.adminservice.exception;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.adminservice.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(MenuItemNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundMenuItemErrors(MenuItemNotFoundException ex) {
		LOGGER.info("Start");
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid MenuItem Id Provided");
		LOGGER.info("End");
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MenuItemAlreadyExistException.class)
	public ResponseEntity<CustomErrorResponse> handleConfilctError(MenuItemAlreadyExistException ex) {
		LOGGER.info("Start");
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("Invalid MenuItem Id Provided");
		LOGGER.info("End");
		return new ResponseEntity<CustomErrorResponse>(response,HttpStatus.CONFLICT);
	}
}
