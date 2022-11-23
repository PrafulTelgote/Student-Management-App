package com.school.services;

import java.util.List;

import com.school.exceptions.CourseException;
import com.school.exceptions.LoginException;
import com.school.exceptions.StudenExpection;
import com.school.model.Admin;
import com.school.model.Course;
import com.school.model.Student;

public interface AdminServices {
	
	public Admin Register(Admin admin);
	public Admin Update(String uuid,Admin admin) throws LoginException;
	public List<Course> GetCources(String uuid) throws LoginException,CourseException;
	public List<Student> GetStudent(String uuid)throws LoginException,StudenExpection;

}
