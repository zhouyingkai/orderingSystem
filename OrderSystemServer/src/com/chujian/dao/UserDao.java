package com.chujian.dao;

import com.chujian.model.User;

public interface UserDao {
	public User userLogin(String account,String password);
	public boolean userRegister(String  phone,String password);
	public boolean userCheck(String account);
	public boolean changePassword(String account,String password);
	
}
