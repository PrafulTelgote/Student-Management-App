package com.school.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Admin;
import com.school.model.CurrentSession;
import com.school.model.Login;
import com.school.model.Student;
import com.school.repo.AdminDao;
import com.school.repo.CurrentSessionDao;
import com.school.repo.StudentDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServicesImpl implements LoginServices {
	
	@Autowired
	private CurrentSessionDao CurrentDao;
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private AdminDao admindao;
	

	@Override
	public String UserLogin(Login login) {
		// TODO Auto-generated method stub
		
		Optional<Student> student= studentdao.findById(login.getUserId());
		
		Optional<CurrentSession> data= CurrentDao.findById(login.getUserId());
		
		if(data.isPresent()) {
			return "ALready login";
		}else if(student.get().getPassword().equals(login.getPassword())) {
			
			String key=RandomString.make(6);
			CurrentSession current = new CurrentSession(login.getUserId(), key, LocalDateTime.now());
			CurrentDao.save(current);
			return "ok "+key;
		}else {
			return "enter valid details";
		}
	}


	@Override
	public String AdminLogin(Login login) {
		// TODO Auto-generated method stub
		Optional<Admin> admindata=admindao.findById(login.getUserId());
		Optional<CurrentSession> data= CurrentDao.findById(login.getUserId());
		if(data.isPresent()) {
			return "already login";
		}else if(admindata.get().getPassword().equals(login.getPassword())) {
			String key=RandomString.make(6);
			CurrentSession current = new CurrentSession(login.getUserId(), key, LocalDateTime.now());
			CurrentDao.save(current);
			return "ok "+key;
		}else {
			return "Enter valid detalis";
		}
//		return null;
	}


	@Override
	public String LogOut(String uuid) {
		
		Optional<CurrentSession> currentdata= CurrentDao.findByuuid(uuid);
		if(currentdata.isPresent()) {
			CurrentDao.delete(currentdata.get());
			return "Logout Done";
		}else {
		 return "Login First..!!1";
		}
	}
	
	

	
	
	 
	
	

}
