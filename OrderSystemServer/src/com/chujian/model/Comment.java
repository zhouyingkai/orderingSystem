package com.chujian.model;
/**
 * 菜品评论实体
 * @author cc
 *
 */
public class Comment {
	private int commentId;
	private String commentTime;
	private String commentContent;
	private int commentStar;
	private int foodId;
	private int userId;
	private String orderId;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int commentId, String commentTime, String commentContent,
			int commentStar, int foodId, int userId, String orderId) {
		super();
		this.commentId = commentId;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
		this.commentStar = commentStar;
		this.foodId = foodId;
		this.userId = userId;
		this.orderId = orderId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentStar() {
		return commentStar;
	}
	public void setCommentStar(int commentStar) {
		this.commentStar = commentStar;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
