package com.chujian.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chujian.DBUtil.DBUtil;
import com.chujian.dao.FoodDao;
import com.chujian.model.Food;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FoodDaoImpl implements FoodDao {

	@Override
	public boolean addNewFood(Food newFood) {
		// TODO Auto-generated method stub
		String sql=" insert into food(food_categary,food_price,food_url,food_unit,food_status)values(?,?,?,?) ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, newFood.getFoodKind());
			ptmt.setFloat(2, newFood.getFoodPrice());
			ptmt.setString(3, newFood.getFoodUrl());
			ptmt.setString(4, newFood.getFoodStatus());
			
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
	public boolean updateFood(int foodId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		
		String sql=" delete form food where food_id=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, foodId);
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
	public List<Food> qeuryFoodList(String categary) {
		// TODO Auto-generated method stub
		
		String sql=" select * froom food where food_categary=? ";
		Connection conn=DBUtil.getConnection();
		List<Food> list=new ArrayList<Food>();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setString(1, categary);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				int foodId=rs.getInt("food_id");
				String foodCategary=rs.getString("food_categary");
				float foodPrice=rs.getFloat("food_price");
				String foodUrl=rs.getString("food_rul");
				String foodUnit=rs.getString("food_unit");
				String foodStatus=rs.getString("food_status");
				
				Food food=new Food();
				food.setFoodId(foodId);
				food.setFoodKind(foodCategary);
				food.setFoodPrice(foodPrice);
				food.setFoodStatus(foodStatus);
				food.setFoodUnit(foodUnit);
				food.setFoodUrl(foodUrl);
				
				list.add(food);
				
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
	public Food qeuryFood(int foodId) {
		String sql=" select * froom food where food_id=? ";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
			ptmt.setInt(1, foodId);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				String foodCategary=rs.getString("food_categary");
				float foodPrice=rs.getFloat("food_price");
				String foodUrl=rs.getString("food_rul");
				String foodUnit=rs.getString("food_unit");
				String foodStatus=rs.getString("food_status");
				
				Food food=new Food();
				food.setFoodId(foodId);
				food.setFoodKind(foodCategary);
				food.setFoodPrice(foodPrice);
				food.setFoodStatus(foodStatus);
				food.setFoodUnit(foodUnit);
				food.setFoodUrl(foodUrl);
				
				return food;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
		
		
		return null;
	}
}


