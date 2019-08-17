package com.tedu.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * PreparedStatement对象的使用
 */
public class TestC3P02 {

	// 1.查询user表中的所有用户信息
	@Test
	public void findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 创建一个连接池对象
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			// 设置连接数据库的基本信息
			// 自动从配置文件中获取配置信息
			// 从连接池中获取一个连接对象
			conn = pool.getConnection();
			// 声明SQL语句
			String sql = "select * from user";
			// 获取传输器
			ps = conn.prepareStatement(sql);
			// 使用传输器将语句传输到数据库执行
			rs = ps.executeQuery();
			System.out.println("id username \tpassword");
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String pwd = rs.getString("password");
				System.out.println(id + " \t" + user + " \t" + pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 用完连接对象后要将连接对象还回连接池中
			// conn.close();
			// 如果是自己创建的连接对象,调用方法是关闭连接.
			// 如果是从连接池中获取的对象,连接池会复写close()方法,功能从关闭变成了归还.
			JdbcUtils.close(conn, ps, rs);
		}
	}

	// 2.修改user表中id为2的记录,密码改为123456
	@Test
	public void updateUser() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "update user set password =? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "123456");
			ps.setInt(2, 2);
			int i = ps.executeUpdate();
			System.out.println("修改成功,修改了" + i + "行");
		} catch (Exception e) {
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	// 3.新增user,用户名:关羽,密码456
	@Test
	public void addUser() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "insert into user values(null,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "关羽");
			ps.setString(2, "456");
			int i = ps.executeUpdate();
			System.out.println("增加成功,增加了" + i + "行");
		} catch (Exception e) {
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	// 4.删除user表中姓名为关羽的记录
	@Test
	public void deleteUser() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "delete from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "关羽");
			int i = ps.executeUpdate();
			System.out.println("删除成功,删除了" + i + "行");
		} catch (Exception e) {
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}

	}
}
