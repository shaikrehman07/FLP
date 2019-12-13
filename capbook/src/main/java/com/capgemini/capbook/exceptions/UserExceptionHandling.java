package com.capgemini.capbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandling {
	   @ExceptionHandler(UserException.class)
	   public ResponseEntity <String> handleException(Exception ex){
			return new ResponseEntity <String> ("data not found", HttpStatus.NOT_FOUND);
			
		}
}