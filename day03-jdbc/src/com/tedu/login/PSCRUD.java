package com.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.tedu.util.JdbcUtils;

/*
 * PreparedStatement对象的使用
 */
public class PSCRUD {

	// 1.查询user表中的所有用户信息
	@Test
	public void findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
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
			JdbcUtils.close(conn, ps, rs);
		}
	}

	// 2.修改user表中id为2的记录,密码改为123456
	@Test
	public void updateUser() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
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
		try {
			conn = JdbcUtils.start();
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
		try {
			conn = JdbcUtils.start();
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
