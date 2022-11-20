package com.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.repo.CourseDao;
import com.school.repo.StudentDao;

@Service
public class CourseServiceImpl implements CourseServices {

	@Autowired
	private CourseDao coursedao;
	
	@Autowired
	private StudentDao studentdao;

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		Course data= coursedao.save(course);
		return data;
	}
	
	
	
	
}
