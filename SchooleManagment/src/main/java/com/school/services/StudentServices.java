package com.school.services;

import java.util.List;

import com.school.model.Course;
import com.school.model.Student;

public interface StudentServices {
	
	public Student Register(Student student);
	public Student Update(String uuid, Student student);
	public List<Course> getAllTheCourse(String uuid);
	public String AddCourse(String uuid,Integer courseId);

}
