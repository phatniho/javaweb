package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

// 测试SSM的开发环境
@Controller
public class TestSSM {
	@Autowired // 自动装配:将由Spring容器负责创建该对象,并赋值给该变量
	DoorMapper doorMapper;

	@RequestMapping("/testssm")
	public String testssm() {
		// 查询所有门店信息
		List<Door> list = doorMapper.findAll();
		for (Door door : list) {
			System.out.println(door);
		}
		return "testssm";
	}
}
