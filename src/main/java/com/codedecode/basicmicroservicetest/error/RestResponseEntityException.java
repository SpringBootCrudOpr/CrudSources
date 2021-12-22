package com.codedecode.basicmicroservicetest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codedecode.basicmicroservicetest.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> depertamentNotFoundException(DepartmentNotFoundException exception,WebRequest request) {
		
		ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		
	}

}
