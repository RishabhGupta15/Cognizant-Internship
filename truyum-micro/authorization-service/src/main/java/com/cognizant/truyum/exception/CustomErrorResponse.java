package com.cognizant.truyum.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is for customizing the exception handler
 */
@Setter
@Getter
@ToString

public class CustomErrorResponse {

	private String message;
	private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "CustomErrorResponse [message=" + message + ", dateTime=" + dateTime + "]";
	}
	public CustomErrorResponse(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}
	public CustomErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
