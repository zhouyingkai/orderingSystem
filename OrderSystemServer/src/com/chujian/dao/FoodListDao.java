package com.chujian.dao;

import java.util.List;

import com.chujian.model.FoodList;

/**
 * 
 * @author ��ӳ��
 * �û���ѡ��Ʒ�嵥
 *
 */
public interface FoodListDao {
	public boolean addFoodList(FoodList foodList);
	public boolean deleteFoodList(int foodListId);
	public List<FoodList> qeuryByOrderId(String orderId);
	public boolean updateFoodList(FoodList foodList);
}
