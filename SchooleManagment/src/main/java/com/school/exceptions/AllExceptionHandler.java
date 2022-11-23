package com.school.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AllExceptionHandler {
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyException> loginExceptionHandler(LoginException le,WebRequest req){
		
		
		MyException my=new MyException();
		my.setDateTime(LocalDateTime.now());
		my.setMessage(le.getMessage());
		my.setMessage(req.getDescription(false));
		return new ResponseEntity<MyException>(my, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(StudenExpection.class)
	public ResponseEntity<MyException> StudentExceptionHandler(StudenExpection se,WebRequest req){
		MyException my=new MyException();
		my.setDateTime(LocalDateTime.now());
		my.setMessage(se.getMessage());
		my.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyException>(my, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyException> CourseExceptionHandler(CourseException ce,WebRequest req){
		
		MyException my=new MyException();
		my.setDateTime(LocalDateTime.now());
		my.setMessage(ce.getMessage());
		my.setDetails(req.getDescription(false));
		return new ResponseEntity<MyException>(my, HttpStatus.NOT_FOUND);
	}
}
