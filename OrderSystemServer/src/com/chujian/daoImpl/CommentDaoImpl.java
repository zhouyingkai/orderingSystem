package com.chujian.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chujian.DBUtil.DBUtil;
import com.chujian.dao.CommentDao;
import com.chujian.model.Comment;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CommentDaoImpl implements CommentDao{

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql=" insert into comment(comment_time,comment_content,comment_start,food_id,user_id,order_id)values(?,?,?,?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, comment.getCommentTime());
			ptmt.setString(2, comment.getCommentContent());
			ptmt.setInt(3, comment.getCommentStar());
			ptmt.setInt(4, comment.getFoodId());
			ptmt.setInt(5, comment.getUserId());
			ptmt.setString(6, comment.getOrderId());
			
			
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
	public boolean deleteComment(int commentId) {
		// TODO Auto-generated method stub
		String sql=" delete form comment where comment_id=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, commentId);
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
	public List<Comment> qeuryByFoodId(int foodId) {
		String sql=" select * froom common where food_id=? ";
		Connection conn=DBUtil.getConnection();
		List<Comment> list=new ArrayList<Comment>();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, foodId);
			ResultSet rs=ptmt.executeQuery();
			
			if(rs.next()){
				int commonId=rs.getInt("comment_id");
				String commentTime=rs.getString("comment_time");
				String commentContent=rs.getString("comment_content");
				int commentStar=rs.getInt("comment_star");
//				int foodId=rs.getInt("food_id");
				int userId=rs.getInt("user_id");
				String orderId=rs.getString("order_id");
				
				Comment comment=new Comment(commonId, commentTime, commentContent, commentStar, foodId, userId, orderId);
			
				list.add(comment);
				
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
	public List<Comment> qeuryByUserId(int userId) {
		String sql=" select * froom common where user_id=? ";
		Connection conn=DBUtil.getConnection();
		List<Comment> list=new ArrayList<Comment>();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, userId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int commonId=rs.getInt("comment_id");
				String commentTime=rs.getString("comment_time");
				String commentContent=rs.getString("comment_content");
				int commentStar=rs.getInt("comment_star");
				int foodId=rs.getInt("food_id");
//				int userId=rs.getInt("user_id");
				String orderId=rs.getString("order_id");
				
				Comment comment=new Comment(commonId, commentTime, commentContent, commentStar, foodId, userId, orderId);
			
				list.add(comment);
				
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
	public List<Comment> qeuryByOrderID(String orderId) {
		// TODO Auto-generated method stub
		String sql=" select * froom common where order_id=? ";
		Connection conn=DBUtil.getConnection();
		List<Comment> list=new ArrayList<Comment>();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, orderId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int commonId=rs.getInt("comment_id");
				String commentTime=rs.getString("comment_time");
				String commentContent=rs.getString("comment_content");
				int commentStar=rs.getInt("comment_star");
				int foodId=rs.getInt("food_id");
				int userId=rs.getInt("user_id");
//				String orderId=rs.getString("order_id");
				
				Comment comment=new Comment(commonId, commentTime, commentContent, commentStar, foodId, userId, orderId);
			
				list.add(comment);
				
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
	public List<Comment> qeuryAll() {
		// TODO Auto-generated method stub
		String sql=" select * froom common ";
		Connection conn=DBUtil.getConnection();
		List<Comment> list=new ArrayList<Comment>();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int commonId=rs.getInt("comment_id");
				String commentTime=rs.getString("comment_time");
				String commentContent=rs.getString("comment_content");
				int commentStar=rs.getInt("comment_star");
				int foodId=rs.getInt("food_id");
				int userId=rs.getInt("user_id");
				String orderId=rs.getString("order_id");
				
				Comment comment=new Comment(commonId, commentTime, commentContent, commentStar, foodId, userId, orderId);
			
				list.add(comment);
				
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
