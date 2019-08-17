package com.tedu.mybatis;

import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/*
 * mybatis的Mapper接口开发
 * (1)创建一个接口,接口的全路径名和mapper文件的namespace值要相同
 * (2)SQL语句的参数类型和接口中方法的参数类型要保持一致
 * (3)SQL标签上的resultType即返回值类型和接口中方法的返回值类型相同(如果返回值是集合,resultType只需要制定集合中的泛型)
 */
public class TestMyBatis4 {
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

	// 13.查询所有员工信息
	@Test
	public void testFindAll() {
		// 1.执行sql语句
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findAll");
		Iterator<Emp> it = list.iterator();
		// 2.遍历集合
		while (it.hasNext()) {
			Emp emp = it.next();
			System.out.println(emp);
		}
	}
}
