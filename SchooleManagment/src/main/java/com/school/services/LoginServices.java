package com.school.services;

import com.school.model.Login;

public interface LoginServices {
	
	public String UserLogin(Login login);
	
	public String AdminLogin(Login login);
	
	public String LogOut(String uuid);
	
	

}
