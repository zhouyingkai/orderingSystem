package com.chujian.DBUtil;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/ordering?useUnicode=true&characterEncoding=utf-8";
	public static final String USERNAME="root";
	public static final String PASSWORD="root";
	
	public static Connection getConnection(){
			try {
				Class.forName(DRIVER);
				return (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
	}
	public static void closeConn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
