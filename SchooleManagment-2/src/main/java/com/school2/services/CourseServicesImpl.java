package com.school2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school2.model.Course;
import com.school2.repo.CourseDao;

@Service
public class CourseServicesImpl implements CourseServices {

	
	@Autowired
	private CourseDao courseDao;

	@Override
	public String Savecourse(Course course) {
		courseDao.save(course);
		
		return "Done";
	}

	@Override
	public List<Course> course() {
		List<Course> course= courseDao.findAll();
		
		return course;
	}
}
