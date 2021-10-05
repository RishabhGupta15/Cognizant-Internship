package com.cognizant.truyum.customerservice.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.customerservice.model.CustomErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(MenuItemNotAvailableException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundMenuItemErrors(MenuItemNotAvailableException ex) {
		LOGGER.info("Start");
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.CONFLICT);
		response.setReason("MenuItem is not available");
		LOGGER.info("End");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundUserError(UserNotFoundException ex) {
		LOGGER.info("Start");
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Invalid User Id Provided");
		LOGGER.info("End");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CartEmptyException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundUserError(CartEmptyException ex) {
		LOGGER.info("Start");
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("Cart is empty");
		LOGGER.info("End");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
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

}
