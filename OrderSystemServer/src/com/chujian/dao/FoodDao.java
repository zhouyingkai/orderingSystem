package com.chujian.dao;

import java.util.List;

import com.chujian.model.Food;

/**
 * 
 * @author 周映凯	
 * 菜品接口
 *
 */
public interface FoodDao {
	public boolean addNewFood(Food newFood);
	public boolean updateFood(int foodId);
	public boolean deleteFood(int foodId);
	public List<Food> qeuryFoodList(String categary);
	public Food qeuryFood(int foodId);
	
}
