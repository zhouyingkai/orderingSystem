package com.chujian.dao;

import java.util.List;

import com.chujian.model.Order;

/**
 * 
 * @author 周映凯
 * 订单接口
 *
 */
public interface OrderDao {
	public boolean addOrder(Order order);
	public boolean deleteOrder(String orderId);
	public boolean updateOrder(Order order);
	public List<Order> qeuryAll();
	public List<Order> qeuryByOrderId(String orderId);
	public List<Order> qeuryByTableId(int tableId);
	public List<Order> qeuryByUserId(int userId);
	
}
