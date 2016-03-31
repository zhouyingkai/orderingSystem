package com.chujian.dao;

import com.chujian.model.User;

public interface UserDao {
	public User userLogin(String account,String password);
	public User userRegister(User user);

}
