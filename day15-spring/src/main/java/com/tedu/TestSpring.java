package com.tedu;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.dao.Dao;
import com.tedu.pojo.User;

public class TestSpring {
	// 1.加载applicationContext.xml配置文件
	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testDI() {
		// 获取User类的实例
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}

	@Test
	public void testIOC2() {
		// 2.获取User对象
		User user1 = (User) ac.getBean("user");
		User user2 = (User) ac.getBean("user");
		System.out.println(user1);
		System.out.println(user2);
	}

	@Test
	public void testIOC1() {
		// 2.获取User对象
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}

	@Test
	public void testDao() {
		Dao dao = (Dao) ac.getBean("dao");
		dao.findAll();
	}

	@Test
	public void testFanshe() throws Exception {
		Class<?> clazz = Class.forName("com.tedu.pojo.User");// 读取类,创建类对象
		User user = (User) clazz.newInstance();// 反射创建该类对象
		System.out.println(user);
	}
}
