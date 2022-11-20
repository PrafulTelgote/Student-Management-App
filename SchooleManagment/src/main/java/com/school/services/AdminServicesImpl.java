package com.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Admin;
import com.school.repo.AdminDao;

@Service
public class AdminServicesImpl implements AdminServices {
	
	@Autowired
	private AdminDao admindao;

	@Override
	public Admin Register(Admin admin) {
		
		Admin data=admindao.save(admin);
		// TODO Auto-generated method stub
		return data;
	}
	
	

}
