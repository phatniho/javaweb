package com.tedu.service;

import com.tedu.pojo.Door;

import java.util.List;

// Service接口
public interface DoorService {

	// 1.查询所有门店信息
	public List<Door> findAll();

	// 2.根据id删除门店
	public void deleteById(Integer id);

	// 3.新增门店信息
	public void addDoor(Door door);

	// 4.根据id查询门店信息
	public Door findById(Integer id);

	// 5.根据id修改门店信息
	public void updateById(Door door);
}
