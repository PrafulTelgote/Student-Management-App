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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.exceptions.CourseException;
import com.school.exceptions.LoginException;
import com.school.exceptions.StudenExpection;
import com.school.model.Admin;
import com.school.model.Course;
import com.school.model.Login;
import com.school.model.Student;
import com.school.services.AdminServices;
import com.school.services.CourseServices;
import com.school.services.LoginServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {
	
	@Autowired
	private CourseServices courseservices;
	
	@Autowired
	private AdminServices adminservices;
	
	@Autowired
	private LoginServices loginservices;
	
	@RequestMapping("/index")
    public String home(){
        return "index";
    }
	
	
	
	@PostMapping("/admin/register")
	public ResponseEntity<Admin> registerHandler(Admin admin) {
		
		Admin data=adminservices.Register(admin);
		return new ResponseEntity<Admin>(data, HttpStatus.CREATED);
		
	}
	
	
	@PatchMapping("/admin/update")
	public ResponseEntity<Admin> updateHandler(@RequestParam String  uuid,@RequestBody Admin admin)throws LoginException{
		
		Admin data=adminservices.Update(uuid, admin);
		return new ResponseEntity<Admin>(data, HttpStatus.OK);
		
	}
	
	@GetMapping("/admin/getcourse")
	public ResponseEntity<List<Course>> getCourseHandler(@RequestParam String uuid)throws LoginException,CourseException{
		
		
		List<Course> courses=adminservices.GetCources(uuid);
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> AdminLoginHandler(Login login) {
		
		String data=loginservices.AdminLogin(login);
		return new ResponseEntity<String>(data, HttpStatus.OK);
		
	}
	
	@GetMapping("/admin/getstudent")
	public ResponseEntity<List<Student>> GetStudentHandler(@RequestParam String uuid) throws LoginException,StudenExpection{
		
		List<Student> students=adminservices.GetStudent(uuid);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/admin/logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam String uuid){
		String data= loginservices.LogOut(uuid);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	
	
	@PostMapping("admin/course/addcourse")
	public ResponseEntity<Course> addCourseHandler(String uuid,Course course) throws LoginException, CourseException{
		Course data= courseservices.addCourse(uuid, course);
		return new ResponseEntity<Course>(data, HttpStatus.ACCEPTED);
	}
	
	
	@PatchMapping("admin/course/updatecourse")
	public ResponseEntity<Course> UpdateCorseHandler(String uuid ,Course course) throws CourseException, LoginException{
		Course data= courseservices.addCourse(uuid, course);
		return new ResponseEntity<Course>(data, HttpStatus.ACCEPTED);
		}
	
	@PutMapping("admin/course/addstudent")
	public ResponseEntity<String> AddStudentToCourse(String uuid,Integer studentid,Integer courseid) throws LoginException, CourseException, StudenExpection{
		String data= courseservices.AddStudentToCourse(uuid, courseid, studentid);
		return new ResponseEntity<String>(data, HttpStatus.OK);	
		
	}
	
	
	@PutMapping("/admin/course/remouve")
	public ResponseEntity<String> RemoveStrudentFromCourse(String uuid,Integer studentid,Integer courseid) throws LoginException, CourseException, StudenExpection{
		String data= courseservices.RemoveStudentFromCourse(uuid, courseid, studentid);
		return new ResponseEntity<String>(data, HttpStatus.OK);	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
