package com.tedu.jdbc;

import com.tedu.util.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC增删改查(CRUD) Create 增加 Retrieve 查询 Update 修改 Delete 删除
 */
public class JdbcCRUD {
	/**
	 * 1.增加:往account表中插入一条新的记录,name为"john",money为30000
	 * 
	 * insert into account values(null,'john',30000);
	 */
	@Test
	public void addAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet re = null;
		try {
			conn = JdbcUtils.start();// 注册驱动并获取连接对象
			stat = conn.createStatement();
			String s = "insert into account values(null,'john',3000)";
			int a = stat.executeUpdate(s);
			System.out.println("成功修改了" + a + "行");
			System.out.println("执行成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败!");
		} finally {
			JdbcUtils.close(conn, stat, re);// 关闭所有开启的资源
		}
	}

	/**
	 * 2.修改：修改account表中name为 "john" 的记录，将金额改为2500
	 * 
	 * update account set money = 2500 where name = 'john';
	 */
	@Test
	public void updateAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet re = null;
		try {
			conn = JdbcUtils.start();// 注册驱动并获取连接对象
			stat = conn.createStatement();
			String s = "update account set money = 2500 where name = 'john'";
			int a = stat.executeUpdate(s);
			System.out.println("成功修改了" + a + "行");
			System.out.println("执行成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败!");
		} finally {
			JdbcUtils.close(conn, stat, re);
		}
	}

	/**
	 * 3.删除：删除account表中name为 "john" 的记录
	 * 
	 * delete from account where name = 'john';
	 */
	@Test
	public void deleteAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet re = null;
		try {
			conn = JdbcUtils.start();// 注册驱动并获取连接对象
			stat = conn.createStatement();
			String s = "delete from account where name = 'john'";
			int a = stat.executeUpdate(s);
			System.out.println("成功修改了" + a + "行");
			System.out.println("执行成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败!");
		} finally {
			JdbcUtils.close(conn, stat, re);
		}
	}

	/**
	 * 4.查询：查询account表中id为1的记录
	 * 
	 * select * from account where id = 1;
	 */
	@Test
	public void findById() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();// 注册驱动并获取连接对象
			stat = conn.createStatement();// 获取传输器
			String s = "select * from account where id = 3";// 获取sql语句
			rs = stat.executeQuery(s);// 将sql语句用传输器传输到数据库执行,并返回结果
//			while (rs.next()) {// 循环获取结果对象,单个对象可以不用循环获取
			// 将指针指向数据区域,默认指针位置在表头,不能获取数据,如果没有数据也会报错,所以可以加if判断
			if (rs.next()) {
				int id = rs.getInt("id");// 获取对象成员变量
				String name = rs.getString("name");
				double money = rs.getDouble("money");
				System.out.println(id + ":" + name + ":" + money);// 打印对象字符串
			}
			System.out.println("执行成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败!");
		} finally {
			JdbcUtils.close(conn, stat, rs);// 关闭全部资源
		}
	}

}
