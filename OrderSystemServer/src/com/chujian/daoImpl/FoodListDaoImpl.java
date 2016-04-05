package com.chujian.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chujian.DBUtil.DBUtil;
import com.chujian.dao.FoodListDao;
import com.chujian.model.FoodList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FoodListDaoImpl implements FoodListDao{

	@Override
	public boolean addFoodList(FoodList foodList) {
		// TODO Auto-generated method stub
		String sql="insert into food_list(food_id,food_amount,food_status,order_id)values(?,?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, foodList.getFoodId());
			ptmt.setInt(2, foodList.getFoodAmount());
			ptmt.setInt(3, foodList.getFoodStatus());
			ptmt.setString(4, foodList.getOrderId());
			
			int count =ptmt.executeUpdate();
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
	public boolean deleteFoodList(int foodListId) {
		String sql=" delete from food_list where food_list_id=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, foodListId);
			int count=ptmt.executeUpdate();
			if(count==1){
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
	public List<FoodList> qeuryByOrderId(String orderId) {
		// TODO Auto-generated method stub
		List<FoodList> list=new ArrayList<FoodList>();
		String sql="¡¡select * from food_list where order_id=?¡¡";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, orderId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int foodListId=rs.getInt("food_list_id");
				int foodId=rs.getInt("food_id");
				int foodAmount=rs.getInt("food_amount");
				int foodStatus=rs.getInt("food_status");
//				String orderId=rs.getString("order_id");
				
				FoodList foodList=new FoodList(foodListId, foodId, foodAmount, foodStatus, orderId);
				list.add(foodList);
				
				
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
	public boolean updateFoodList(FoodList foodList) {
		// TODO Auto-generated method stub
		return false;
	}

}
