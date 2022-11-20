package com.school.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.model.CurrentSession;
import com.school.model.Student;
import com.school.repo.CourseDao;
import com.school.repo.CurrentSessionDao;
import com.school.repo.StudentDao;

@Service
public class StudentServicesImpl implements StudentServices {

	
	@Autowired
	private StudentDao sdao;
	
	@Autowired
	private CourseDao cdao;
	
	@Autowired
	private CurrentSessionDao currentdao;
	
	
	@Override
	public Student Register(Student student) {
		
		sdao.save(student);
	
		
		return null;
	}


	@Override
	public List<Course> getAllTheCourse(String uuid) {
		// TODO Auto-generated method stub
		Optional<CurrentSession> current= currentdao.findByuuid(uuid);
		if(current.isPresent()) {
			List<Course> coures= cdao.findAll();
			return coures;
		}else {
			System.out.println("Login First");
			return null;
		}
	}


	@Override
	public Student Update(String uuid, Student student) {
		// TODO Auto-generated method stub
		Optional<CurrentSession> current= currentdao.findByuuid(uuid);
		if(current.isPresent()) {
//			Optional<Student> studentdata= sdao.findById(current.get().getUserId());
			Student data= sdao.save(student);
			return data;
			
		}else {
			System.out.println("Login First");
			return null;
		}
	}


	@Override
	public String AddCourse(String uuid, Integer courseId) {
		// TODO Auto-generated method stub
		Optional<CurrentSession> current= currentdao.findByuuid(uuid);
		if(current.isPresent()) {
             Optional<Course> course=cdao.findById(courseId);
             if(course.isPresent()) {
            	 Optional<Student> student=sdao.findById(current.get().getUserId());
            	 student.get().getCourse().add(course.get());
            	 sdao.save(student.get());
            	 return "Added"; 
             }
			
		}else {
			return "Login First";
		}
		
		return null;
	}
	
	
	
	
	

}
