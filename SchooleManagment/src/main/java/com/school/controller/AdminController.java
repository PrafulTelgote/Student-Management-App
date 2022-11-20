package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.Admin;
import com.school.model.Course;
import com.school.model.Login;
import com.school.services.AdminServices;
import com.school.services.CourseServices;
import com.school.services.LoginServices;

@RestController
public class AdminController {
	
	@Autowired
	private CourseServices courseservices;
	
	@Autowired
	private AdminServices adminservices;
	
	@Autowired
	private LoginServices loginservices;
	
	
	
	@PostMapping("/admin/register")
	public ResponseEntity<Admin> registerHandler(Admin admin) {
		
		Admin data=adminservices.Register(admin);
		return new ResponseEntity<Admin>(data, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> AdminLoginHandler(Login login) {
		
		String data=loginservices.AdminLogin(login);
		return new ResponseEntity<String>(data, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/admin/logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam String uuid){
		String data= loginservices.LogOut(uuid);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/addcorse")
	public ResponseEntity<Course> AddCourse(Course course){
		Course data= courseservices.addCourse(course);
		return new ResponseEntity<Course>(data, HttpStatus.ACCEPTED);
	}
	

}
