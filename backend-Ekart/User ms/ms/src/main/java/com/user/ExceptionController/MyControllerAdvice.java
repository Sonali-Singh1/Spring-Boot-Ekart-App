package com.user.ExceptionController;

import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundExcep(EntityNotFoundException s){
		return new ResponseEntity<String>("No customer found for the provided details",HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExcep(MethodArgumentNotValidException ex){
		String msg=ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException ex) 
	{
		String msg=ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
			        		                          .collect(Collectors.joining(", "));
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberExcep(NumberFormatException e){
		return new ResponseEntity<String>("Please provide required details",HttpStatus.BAD_REQUEST);	
	}
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleExcep(Exception e){
//		return new ResponseEntity<String>("Please provide correct details",HttpStatus.OK);	
//	}

}
