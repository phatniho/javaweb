package com.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.tedu.util.JdbcUtils;

/*
 * 模拟用户登录案例
 */
public class LoginUser2 {
	/*
	 * 思路:提示用户在控制台输入用户名和密码,并接收
	 * 
	 * 根据用户名密码查询user表,如果查到了记录,则用户名密码正确,允许用户登录
	 * 
	 * 否则提示"用户名或密码错误"
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("输入用户名:");
		String user = in.nextLine();
		System.out.print("输入密码:");
		String pwd = in.nextLine();
		login(user, pwd);
		JdbcUtils.close(in);
	}

	private static void login(String user, String pwd) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 建立连接
			con = JdbcUtils.start();
			// 定义sql语句,?占位
			String sql = "select * from user where username = ? and password = ?";
			// 将SQL语句进行编译,固定格式
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			// 设置参数
			ps.setString(1, user);
			ps.setString(2, pwd);
			System.out.println(sql);
			// 执行SQL语句(不要传两次SQL语句)
			rs = ps.executeQuery();
			// 处理结果
			if (rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败,用户名或密码错误!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, ps, rs);
		}
	}
}
