package com.admiral.employee.onboarding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptinalHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException exp){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Null pointer exception is been caught at: "+ exp.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException exp){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource Not Found : "+ exp.getMessage());
	}
	
	@ExceptionHandler(InvalidInputDataException.class)
	public ResponseEntity<String> invalidInputDataException(InvalidInputDataException exp){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input provided : "+ exp.getMessage());
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exp){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: "+ exp.getMessage());
	}
}
