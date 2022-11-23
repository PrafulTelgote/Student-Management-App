package com.school.services;

import com.school.exceptions.CourseException;
import com.school.exceptions.LoginException;
import com.school.exceptions.StudenExpection;
import com.school.model.Course;

public interface CourseServices {
	
	public Course addCourse(String uuid,  Course course) throws LoginException, CourseException;
	public Course UpdateCourse(String uuid, Course course)  throws LoginException, CourseException;
	public String AddStudentToCourse(String uuid,Integer courseId,Integer StudentID) throws LoginException,CourseException,StudenExpection;
	public String RemoveStudentFromCourse(String uuid,Integer courseId,Integer StudentID) throws LoginException,CourseException,StudenExpection;
	
	

}
