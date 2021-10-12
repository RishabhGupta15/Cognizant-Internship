package com.cognizant.truyum.adminservice.model;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CustomErrorResponse {

	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomErrorResponse(LocalDateTime timestamp, HttpStatus status, String reason, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.reason = reason;
		this.message = message;
	}
	public CustomErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomErrorResponse [timestamp=" + timestamp + ", status=" + status + ", reason=" + reason
				+ ", message=" + message + "]";
	}
	
	
}
