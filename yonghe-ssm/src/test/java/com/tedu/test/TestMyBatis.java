package com.tedu.test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

public class TestMyBatis {
	// 测试mybatis的开发环境
	// 查询tb_door表中的所有门店信息
	public static void main(String[] args) throws Exception {
		// 1.读取mybatis的配置信息
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		// 2.获取SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 3.通过工厂获取SQLSession对象
		SqlSession session = factory.openSession();
		// 4.执行sql,查询所有门店
		DoorMapper mapper = session.getMapper(DoorMapper.class);
		List<Door> list = mapper.findAll();
		// 5.打印所有门店信息
		Iterator<Door> it = list.iterator();
		while (it.hasNext()) {
			Door door = it.next();
			System.out.println(door);
		}
	}
}
