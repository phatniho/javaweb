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

import com.tedu.pojo.Emp;

/*
 * mybatis的动态sql
 */
public class TestMyBatis3 {
	private static SqlSessionFactory factory;
	private static SqlSession session;

	static {// 在类加载时执行
		try {
			// 1.读取mybatis的核心配置文件(sqlMapConfig.xml)
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			// 2.通过配置信息创建sqlSession工厂对象
			factory = new SqlSessionFactoryBuilder().build(in);
			// 3.通过工厂获取SQLSession对象
			session = factory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 12.批量删除操作
	@Test
	public void testDelete() {
		Integer[] ids = { 2, 4, 6, 8 };
		int i = session.update("com.tedu.pojo.EmpMapper.deleteAll", ids);
		session.commit();
		System.out.println("影响的行数:" + i);
	}

	// 11.修改指定id的信息,传入了的修改,没有传入的不修改
	@Test
	public void testUpdateById() {
		System.out.println("输入需要修改的员工id");
		Integer id = new Scanner(System.in).nextInt();
		System.out.println("姓名:");
		String name = new Scanner(System.in).nextLine();
		System.out.println("职位:");
		String job = new Scanner(System.in).nextLine();
		System.out.println("薪资:");
		double salary = new Scanner(System.in).nextDouble();
		Emp emp = new Emp(id, name, job, salary);
		int i = session.update("com.tedu.pojo.EmpMapper.updateById3", emp);
		session.commit();
		System.out.println("影响的行数:" + i);
	}

	// 10.查询表中所有员工信息,如果传递了minSal和maxSal,则查询薪资在两者之间的所有员工信息
	// 如果只传递了minSal,则查询薪资大于minSal的所有员工信息
	// 如果只传递了maxSal,则查询薪资小于maxSal的所有员工信息
	// 如果两个都不传,则查询所有员工信息
	@Test
	public void testFindAll5() {
		System.out.println("输入minSal:");
		double minSal = new Scanner(System.in).nextDouble();
		System.out.println("输入maxSal:");
		double maxSal = new Scanner(System.in).nextDouble();
		Map<String, Double> map = new HashMap<>();
		map.put("minSal", minSal);
		map.put("maxSal", maxSal);
		map.put("minSal", null);
		map.put("maxSal", null);
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findAll5", map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

	// 9.查询员工信息,如果name不为null,则根据name模糊查询,如果name为null,则查询全部员工
	@Test
	public void testFindAll4() {
		System.out.print("输入要查询的员工姓名:");
		String name = new Scanner(System.in).nextLine();
		if (name.length() == 0) {
			name = null;
		}
		Map map = new HashMap();
		map.put("name", name);
		// 1.执行sql语句
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findAll4", map);
		Iterator<Emp> it = list.iterator();
		while (it.hasNext()) {
			Emp emp = it.next();
			System.out.println(emp);
		}
	}
}
