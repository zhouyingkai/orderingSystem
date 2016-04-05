package com.chujian.model;
/**
 * 已选菜品清单实体
 * @author 周映凯
 *
 */

public class FoodList {
	private int foodListId;
	private int foodId;
	private int foodAmount;
	private int foodStatus;
	private String orderId;
	public FoodList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodList(int foodListId, int foodId, int foodAmount, int foodStatus,
			String orderId) {
		super();
		this.foodListId = foodListId;
		this.foodId = foodId;
		this.foodAmount = foodAmount;
		this.foodStatus = foodStatus;
		this.orderId = orderId;
	}
	public int getFoodListId() {
		return foodListId;
	}
	public void setFoodListId(int foodListId) {
		this.foodListId = foodListId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getFoodAmount() {
		return foodAmount;
	}
	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}
	public int getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(int foodStatus) {
		this.foodStatus = foodStatus;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
