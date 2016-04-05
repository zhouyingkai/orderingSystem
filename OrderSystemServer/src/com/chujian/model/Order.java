package com.chujian.model;
/**
 * 订单实体类
 * @author 周映凯
 *
 */
public class Order {
	private String orderId;
	private String orderTime;
	private int orderStatus;
	private int tableId;
	private int userId;
	private int foodListId;
	private int commentFlag;
	private float totalPrice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, String orderTime, int orderStatus,
			int tableId, int userId, int foodListId, int commentFlag,
			float totalPrice) {
		super();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.tableId = tableId;
		this.userId = userId;
		this.foodListId = foodListId;
		this.commentFlag = commentFlag;
		this.totalPrice = totalPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFoodListId() {
		return foodListId;
	}
	public void setFoodListId(int foodListId) {
		this.foodListId = foodListId;
	}
	public int getCommentFlag() {
		return commentFlag;
	}
	public void setCommentFlag(int commentFlag) {
		this.commentFlag = commentFlag;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
