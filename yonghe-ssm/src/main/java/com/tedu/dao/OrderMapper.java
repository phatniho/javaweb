package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;

public interface OrderMapper {

	// 查询所有订单集合
	public List<Order> findAll();

	public void deleteById(Integer id);

	public Order findById(Integer id);

	public void addOrder(Order order);

	public void updateById(Order order);

}
