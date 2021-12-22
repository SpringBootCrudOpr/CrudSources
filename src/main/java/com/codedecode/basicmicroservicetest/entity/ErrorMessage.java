package com.codedecode.basicmicroservicetest.entity;

import javax.persistence.Entity;

import org.springframework.http.HttpStatus;


public class ErrorMessage {
	

	private HttpStatus status;
	private String message;
	
	public ErrorMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", message=" + message + ", getStatus()=" + getStatus()
				+ ", getMessage()=" + getMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
