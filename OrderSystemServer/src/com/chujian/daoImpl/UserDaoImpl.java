package com.chujian.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chujian.DBUtil.DBUtil;
import com.chujian.dao.UserDao;
import com.chujian.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao {

	@Override
	public User userLogin(String account, String password) {
		// TODO Auto-generated method stub
		String sql=" select * from user where user_phone=? and user_password=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, account);
			ptmt.setString(2, password);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int user_id=rs.getInt(1);
				String user_name=rs.getString(2);
				String user_phone=rs.getString(3);
				String user_password=rs.getString(4);
				
				User user=new User(user_id, user_name, user_phone, user_password);
				return user;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean userRegister(String phone, String password) {
		String sql="insert into user(user_phone,user_password)values(?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, phone);
			ptmt.setString(2, password);
			int count=ptmt.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean userCheck(String account) {
		// TODO Auto-generated method stub
		String sql=" select * from user where user_phone=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, account);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean changePassword(String account, String password) {
		// TODO Auto-generated method stub
//		String sql=" update user set user_password= '"+"?"+"'where user_phone='"+"?"+"' ";
		String sql=" update user set user_password=? where user_phone= ? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, password);
			ptmt.setString(2, account);
			
			int count =ptmt.executeUpdate();
			if(count>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}



}
