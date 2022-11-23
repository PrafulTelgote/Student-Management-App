package com.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.exceptions.CourseException;
import com.school.exceptions.LoginException;
import com.school.exceptions.StudenExpection;
import com.school.model.Admin;
import com.school.model.Course;
import com.school.model.CurrentSession;
import com.school.model.Student;
import com.school.repo.AdminDao;
import com.school.repo.CourseDao;
import com.school.repo.CurrentSessionDao;
import com.school.repo.StudentDao;

@Service
public class AdminServicesImpl implements AdminServices {
	
	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private CurrentSessionDao currentDao;
	
	@Autowired
	private CourseDao coursedao;
	
	@Autowired
	private StudentDao studentdao;

	@Override
	public Admin Register(Admin admin) {
		
		Admin data=admindao.save(admin);
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public Admin Update(String uuid, Admin admin) throws LoginException {
		// TODO Auto-generated method stub
		Optional<CurrentSession> data= currentDao.findByuuid(uuid);
		if(data.isEmpty()) {
			throw new LoginException("Login First...!!");
		}
		
		if(data.get().getUserId()==admin.getUserid()) {
			Admin savedata= admindao.save(admin);
			return savedata;
		}else {
			throw new LoginException("Enter the valid uuid of user");
		}
	}

	@Override
	public List<Course> GetCources(String uuid) throws LoginException,CourseException {
		// TODO Auto-generated method stub
		Optional<CurrentSession> data= currentDao.findByuuid(uuid);
		if(data.isEmpty()) {
			throw new LoginException("Please Login First..!!");
		}
		
		List<Course> course = coursedao.findAll();
		if(course.size()>0) {
			return course;
		}else {
			throw new CourseException("Course Not Found...!!!");
		}
	}

	@Override
	public List<Student> GetStudent(String uuid) throws LoginException, StudenExpection {
		// TODO Auto-generated method stub
		Optional<CurrentSession> data= currentDao.findByuuid(uuid);
		if(data.isEmpty()) {
			throw new LoginException("Please Login First..!!");
		}
		
		List<Student> student= studentdao.findAll();
		if(student.size()>0) {
			return student;
		}else {
			throw new StudenExpection("Student Not Added ...!!!");
		}
	}

	
	
	

}
