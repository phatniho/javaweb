package com.tedu.mybatis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.EmpMapper;
import com.tedu.pojo.Emp;

/*
 * mybatis的Mapper接口开发
 * (1)创建一个接口,接口的全路径名和mapper文件的namespace值要相同
 * (2)SQL标签的ID值也要和接口中的方法名保持一致
 * (3)SQL语句的参数类型和接口中方法的参数类型要保持一致
 * (4)SQL标签上的resultType即返回值类型和接口中方法的返回值类型相同(如果返回值是集合,resultType只需要制定集合中的泛型)
 */
public class TestMyBatis4 {
	private static SqlSessionFactory factory;// 新建对象工厂
	private static SqlSession session;// 新建处理对象
	private static EmpMapper mapper;// 新建mapper接口对象

	static {// 在类加载时执行
		try {
			// 1.读取mybatis的核心配置文件(sqlMapConfig.xml)
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			// 2.通过配置信息创建sqlSession工厂对象
			factory = new SqlSessionFactoryBuilder().build(in);
			// 3.通过工厂获取SQLSession对象
			session = factory.openSession();
			// 4.获取mapper对象
			mapper = session.getMapper(EmpMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 15.修改员工信息:修改id为1的员工的信息,将name改为马云,job改为程序员鼓励师,salary=35000
	@Test
	public void testUpdateBy() {
		Emp emp = new Emp(1, "马云云", "程序员鼓励师", 35000d);
		int i = mapper.update(emp);
		session.commit();
		System.out.println("成功修改了" + i + "名员工信息");
	}

	// 16.根据id删除员工
	@Test
	public void testDeleteBy() {
		int i = mapper.deleteById(13);
		session.commit();
		System.out.println("成功删除了" + i + "名员工");
	}

	// 14.添加员工:name=阿帕奇,job=组织,salary=25000
	@Test
	public void testAddEmp() {
		// 0.将sql参数封装到emp对象中
		Emp emp = new Emp(null, "大象", "老板", 8888d);
		// 1.调用方法执行对应sql语句,获取执行结果
		int i = mapper.addEmp(emp);
		// 2.提交
		session.commit();
		// 3.处理结果
		System.out.println("成功添加了" + i + "名员工");
	}

	// 13.查询所有员工信息
	@Test
	public void testFindAll() {
		// 1.调用方法执行执行对应sql语句,获取结果
		List<Emp> list = mapper.findAll();
		// 2.处理结果,遍历集合
		Iterator<Emp> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
