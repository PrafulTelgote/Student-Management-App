package com.school2.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school2.model.Course;
import com.school2.model.Student;
import com.school2.repo.CourseDao;
import com.school2.repo.StudentDao;

@Service
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private CourseDao coursedao;

	@Override
	public String AddStudent(Student student,Integer id) {
		// TODO Auto-generated method stub
		Course course=coursedao.findById(id).get();
		Set<Course> setcourse= student.getCourse();
		setcourse.add(course);
		student.setCourse(setcourse);
		Set<Student> setstudent= course.getStudent();
		setstudent.add(student);
		course.setStudent(setstudent);	
		 studentdao.save(student);
		return "done";
	}
	
	

}
