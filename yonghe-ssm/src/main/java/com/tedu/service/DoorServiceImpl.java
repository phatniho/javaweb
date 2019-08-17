package com.tedu.service;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Service注解的作用:
 * (1)标识当前类属于Service层
 * (2)将当前类的对象的创建交给Spring容器
 * 最后该对象会赋值给同类型的且带有 @Autowired 注解的变量
 */
@Service
public class DoorServiceImpl implements DoorService {
	@Autowired
	DoorMapper dao;

	@Override
	public List<Door> findAll() {// 查询所有门店信息
		// 调用dao层的方法,查询所有门店
		List<Door> list = dao.findAll();
		return list;
	}

	@Override
	public void deleteById(Integer id) {// 根据id删除门店信息
		dao.deleteById(id);
	}

	@Override
	public void addDoor(Door door) {// 新增门店信息
		dao.addDoor(door);
	}

	@Override
	public Door findById(Integer id) {// 根据id查询门店信息
		Door door = dao.findById(id);
		return door;
	}

	@Override
	public void updateById(Door door) {// 根据id修改门店信息
		dao.updateById(door);
	}

}
