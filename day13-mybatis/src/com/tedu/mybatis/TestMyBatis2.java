package com.tedu.mybatis;

import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 使用#{}占位符对数据进行增删改查操作
 * 使用${}占位符:通常对没有引号的字符串进行占位
 */
public class TestMyBatis2 {
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

	// 3.添加员工:name=阿帕奇,job=组织,salary=25000
	@Test
	public void testAddEmp() {
		// 0.将sql参数封装到emp对象中
		Emp emp = new Emp(null, "阿帕奇", "组织", 25000.0);
		// 1.执行sql语句
		int i = session.update("com.tedu.pojo.EmpMapper.addEmp", emp);
		// 2.提交
		session.commit();
		// 3.处理结果
		System.out.println("成功添加了" + i + "名员工");
	}

	// 4.修改员工信息:修改id为8的员工的信息,将name改为马云,job改为阿里ceo,salary=35000
	@Test
	public void testUpdateById() {
		// 0.将sql参数封装到emp对象中
		Emp emp = new Emp(8, "马云", "阿里ceo", 35000.0);
		// 1.执行sql语句
		int i = session.update("com.tedu.pojo.EmpMapper.update", emp);
		// 2.提交
		session.commit();
		// 3.处理结果
		System.out.println("成功修改了" + i + "名员工");
	}

	// 5.根据name查询员工信息
	@Test
	public void testFindByName() {
		// 0.将sql参数封装到emp对象中
		String name = "齐雷";
		// 1.执行sql语句
		Emp emp = session.selectOne("com.tedu.pojo.EmpMapper.findByName", name);
		// 3.处理结果
		System.out.println(emp);
	}

	// 5.根据job查询员工信息
	@Test
	public void testFindByJob() {
		// 0.将sql参数封装到emp对象中
		String job = "程序员";
		// 1.执行sql语句
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findByJob", job);
		// 3.处理结果
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

	// 6.根据id删除员工
	@Test
	public void testDeleteById() {
		// 0.将sql参数封装到emp对象中
		Integer id = 8;
		// 1.执行sql语句
		int i = session.update("com.tedu.pojo.EmpMapper.deleteById", id);
		// 2.提交
		session.commit();
		// 3.处理结果
		System.out.println("成功删除了" + i + "名员工");
	}

	// 7.查询所有员工信息,显示的列通过参数传递过去
	@Test
	public void testFindAny() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("cols", "id,name,job");
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findAny", map);
		for (Emp emp : list) {
			System.out.println("[id=" + emp.getId() + ",name=" + emp.getName() + ",job=" + emp.getJob() + "]");
		}
	}

	// 8.通过name模糊查询员工信息
	@Test
	public void testFindAny2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "刘");
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findAny2", map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}
