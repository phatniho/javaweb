package com.tedu.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.pojo.Emp;

/*
 * 通过mybatis查询yonghedb库中Emp表中的所有数据
 * 将每一条记录封装到一个Emp对象中
 * 将多条记录的多个Emp对象封装到一个list<Emp>集合并返回
 */
public class TestMybatis {
	public static void main(String[] args) throws Exception {
		// 1.读取mybatis的核心配置文件(sqlMapConfig.xml)
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 2.通过配置信息创建sqlSession工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 3.通过工厂获取SQLSession对象
		SqlSession session = factory.openSession();
		// 4.执行sql语句,返回执行结果(EmpMapper.xml)
		List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.findAll");
		// 5.处理结果(打印)
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

	@Test
	public void testUpdate() throws Exception {
		// 1.读取mybatis的核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 2.通过配置信息创建SQLSession工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 3.通过工厂获取SQLSession对象
		SqlSession session = factory.openSession();
		// 4.执行sql语句,返回执行结果
		int i = session.update("com.tedu.pojo.EmpMapper.updateById");
		// 5.提交事务
		session.commit();
		// 6.处理结果
		System.out.println("成功修改了" + i + "行数据!");
	}
}
