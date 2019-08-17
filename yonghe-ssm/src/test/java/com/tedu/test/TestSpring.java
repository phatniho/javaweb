package com.tedu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.Door;

public class TestSpring {
	@Test
	public void testSpring() {
		// 加载Spring核心配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		// 通过Spring获取Door类的对象
		Door door = (Door) ac.getBean("door");
		// 输出查看是否获取成功
		System.out.println(door);
	}
}
