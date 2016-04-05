package com.chujian.model;
/**
 * 菜品实体
 * @author 周映凯
 *
 */
public class Food {
	private int foodId;
	private String foodKind;
	private float foodPrice;
	private String foodUrl;
	private String foodUnit;
	private String foodStatus;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(int foodId, String foodKind, float foodPrice, String foodUrl,
			String foodUnit, String foodStatus) {
		super();
		this.foodId = foodId;
		this.foodKind = foodKind;
		this.foodPrice = foodPrice;
		this.foodUrl = foodUrl;
		this.foodUnit = foodUnit;
		this.foodStatus = foodStatus;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(String foodKind) {
		this.foodKind = foodKind;
	}
	public float getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodUrl() {
		return foodUrl;
	}
	public void setFoodUrl(String foodUrl) {
		this.foodUrl = foodUrl;
	}
	public String getFoodUnit() {
		return foodUnit;
	}
	public void setFoodUnit(String foodUnit) {
		this.foodUnit = foodUnit;
	}
	public String getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}
	
}
