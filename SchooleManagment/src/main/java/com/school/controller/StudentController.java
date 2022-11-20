package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Course;
import com.school.model.Login;
import com.school.model.Student;
import com.school.services.LoginServices;
import com.school.services.StudentServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServices services;
	
	@Autowired
	private LoginServices loginservices;
	
	@PostMapping("/student/register")
	public ResponseEntity<Student> RegisterHandler(@RequestBody Student student){
		 Student data= services.Register(student);
		 return new ResponseEntity<Student>(data, HttpStatus.CREATED);
	}
	
	@PostMapping("/student/login")
	public ResponseEntity<String> LoginHandler(@RequestBody Login login){
		
		String data= loginservices.UserLogin(login);
		return new ResponseEntity<String>(data, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/Student/getCourse")
	public ResponseEntity<List<Course>> GetCoursesHandler(@RequestParam String uuid){
		List<Course> coures=services.getAllTheCourse(uuid);
		return new ResponseEntity<List<Course>>(coures, HttpStatus.OK);
	}
	
	
	@PatchMapping("/student/update")
	public ResponseEntity<Student> UpdateStudentHandler(@RequestParam String uuid,@RequestBody Student student){
		Student studentdata=services.Update(uuid, student);
		return new ResponseEntity<Student>(studentdata, HttpStatus.OK);
	}
	
	@PutMapping("/student/addcourse")
	public ResponseEntity<String> addCourseHandler(@RequestParam String uuid,@RequestParam Integer courseId){
		String data= services.AddCourse(uuid, courseId);
		return new ResponseEntity<String>(data, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	@DeleteMapping("/student/logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam String uuid){
		String data= loginservices.LogOut(uuid);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}

}
