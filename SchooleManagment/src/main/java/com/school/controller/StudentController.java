package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Student;
import com.school.services.StudentServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServices services;
	
	@PostMapping("/student/register")
	public ResponseEntity<Student> RegisterHandler(@RequestBody Student student){
		 Student data= services.Register(student);
		 return new ResponseEntity<Student>(data, HttpStatus.CREATED);
	}

}
