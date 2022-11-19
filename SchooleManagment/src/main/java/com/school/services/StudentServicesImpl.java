package com.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.model.Student;
import com.school.repo.CourseDao;
import com.school.repo.StudentDao;

@Service
public class StudentServicesImpl implements StudentServices {

	
	@Autowired
	private StudentDao sdao;
	
	@Autowired
	private CourseDao cdao;
	
	
	@Override
	public Student Register(Student student) {
		// TODO Auto-generated method stub
//		Optional<Student> data= sdao.findByEmail(student.getEmail());
//		if(data.isEmpty()) {
			Course course=new Course();
			course.getStudent().add(student);
			sdao.save(student);
			return student;
			
//		}
		
		
//		return null;
	}
	
	

}
