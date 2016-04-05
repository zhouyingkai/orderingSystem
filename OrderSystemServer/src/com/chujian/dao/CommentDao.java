package com.chujian.dao;

import java.util.List;

import com.chujian.model.Comment;

/**
 * 
 * @author ��ӳ��
 * ��Ʒ���۵Ľӿ�
 *
 */
public interface CommentDao {
	public boolean addComment(Comment comment);
	public boolean deleteComment(int commentId);
	public List<Comment> qeuryByFoodId(int foodId);
	public List<Comment> qeuryByUserId(int userId);
	public List<Comment> qeuryByOrderID(String orderId);
	public List<Comment> qeuryAll();
}
