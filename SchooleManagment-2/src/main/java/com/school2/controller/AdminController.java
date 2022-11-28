package com.school2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.school2.model.Course;
import com.school2.model.Student;
import com.school2.services.CourseServices;
import com.school2.services.StudentServices;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {
	
	@Autowired
	private CourseServices courseService;
	
	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("/admin/course")
	public String Course1() {
		return "Course";
	}
	
	@PostMapping("/admin/course/save")
	public String SaveCourseHandler(@ModelAttribute  Course course) {
		System.out.println(course);
		String data= courseService.Savecourse(course);
		
		return "Course";
	}
	
	@GetMapping("/getcourse")
	public String GetCourse( Model m) {
	 List<Course> course= courseService.course();
		m.addAttribute("course",course);
		return "GetCourse";
	}
	
	@PostMapping("/admin/course/addstudent")
	public String AddStudentHandler(@ModelAttribute Student student,Integer id) {
		studentServices.AddStudent(student, id);
		return"GetCourse";
		
	}

}
