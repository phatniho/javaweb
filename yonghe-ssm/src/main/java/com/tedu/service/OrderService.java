package com.tedu.service;

import com.tedu.pojo.Order;

import java.util.List;

public interface OrderService {

	// 查询所有订单集合
	public List<Order> findAll();

	public void deleteById(Integer id);

	public Order findById(Integer id);

	public void addOrder(Order order);

	public void updateById(Order order);

}
