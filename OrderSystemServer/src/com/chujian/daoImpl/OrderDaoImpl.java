package com.chujian.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chujian.DBUtil.DBUtil;
import com.chujian.dao.OrderDao;
import com.chujian.model.Comment;
import com.chujian.model.Order;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class OrderDaoImpl implements OrderDao{

	@Override
	public boolean addOrder(Order order) {
		String sql="insert into order(order_time,"+
	"order_status,table_id,user_id,food_list_id,comment_flag,toatl_price)values(?,?,?,?,?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, order.getOrderTime());
			ptmt.setInt(2, order.getOrderStatus());
			ptmt.setInt(3, order.getTableId());
			ptmt.setInt(4, order.getTableId());
			ptmt.setInt(5, order.getFoodListId());
			ptmt.setInt(6, order.getCommentFlag());
			ptmt.setFloat(7, order.getTotalPrice());
			
			int count=ptmt.executeUpdate();
			if(count>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		
		return false;
	}

	@Override
	public boolean deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		String sql=" delete form order where order_id=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, orderId);
			int count=ptmt.executeUpdate();
			if(1==count){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		return false;
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public List<Order> qeuryAll() {
		// TODO Auto-generated method stub
		String sql=" select * froom order ";
		Connection conn=DBUtil.getConnection();
		
		List<Order> list=new ArrayList<Order>();
		
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				String orderId=rs.getString("order_id");
				String orderTime=rs.getString("order_time");
				int orderStatus=rs.getInt("order_status");
				int tableId=rs.getInt("table_id");
				int userId=rs.getInt("user_id");
				int foodListId=rs.getInt("food_list_id");
				int commentFlag=rs.getInt("comment_flag");
				float totalPrice=rs.getFloat("total_price");
				
				Order order=new Order(orderId, orderTime, orderStatus, tableId, userId, foodListId, commentFlag, totalPrice);
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		
		
		return list;
	}

	@Override
	public List<Order> qeuryByOrderId(String orderId) {
		// TODO Auto-generated method stub
		String sql=" select * froom order where order_id=? ";
		Connection conn=DBUtil.getConnection();
		
		List<Order> list=new ArrayList<Order>();
		
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, orderId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
//				String orderId=rs.getString("order_id");
				String orderTime=rs.getString("order_time");
				int orderStatus=rs.getInt("order_status");
				int tableId=rs.getInt("table_id");
				int userId=rs.getInt("user_id");
				int foodListId=rs.getInt("food_list_id");
				int commentFlag=rs.getInt("comment_flag");
				float totalPrice=rs.getFloat("total_price");
				
				Order order=new Order(orderId, orderTime, orderStatus, tableId, userId, foodListId, commentFlag, totalPrice);
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		
		
		return list;
	}

	@Override
	public List<Order> qeuryByTableId(int tableId) {
		// TODO Auto-generated method stub
		String sql=" select * froom order where table_id=? ";
		Connection conn=DBUtil.getConnection();
		
		List<Order> list=new ArrayList<Order>();
		
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, tableId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				String orderId=rs.getString("order_id");
				String orderTime=rs.getString("order_time");
				int orderStatus=rs.getInt("order_status");
//				int tableId=rs.getInt("table_id");
				int userId=rs.getInt("user_id");
				int foodListId=rs.getInt("food_list_id");
				int commentFlag=rs.getInt("comment_flag");
				float totalPrice=rs.getFloat("total_price");
				
				Order order=new Order(orderId, orderTime, orderStatus, tableId, userId, foodListId, commentFlag, totalPrice);
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		
		
		return list;
	}

	@Override
	public List<Order> qeuryByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql=" select * froom order where user_id=? ";
		Connection conn=DBUtil.getConnection();
		
		List<Order> list=new ArrayList<Order>();
		
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, userId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				String orderId=rs.getString("order_id");
				String orderTime=rs.getString("order_time");
				int orderStatus=rs.getInt("order_status");
				int tableId=rs.getInt("table_id");
//				int userId=rs.getInt("user_id");
				int foodListId=rs.getInt("food_list_id");
				int commentFlag=rs.getInt("comment_flag");
				float totalPrice=rs.getFloat("total_price");
				
				Order order=new Order(orderId, orderTime, orderStatus, tableId, userId, foodListId, commentFlag, totalPrice);
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		
		
		return list;
	}

}



