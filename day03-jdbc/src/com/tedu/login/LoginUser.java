package com.tedu.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

import com.tedu.util.JdbcUtils;

/*
 * 模拟用户登录案例
 * 
 * SQL注入攻击
 * 输入用户名:张飞'#'
 * 输入密码:
 * select * from user where username = '张飞'#'' and password = ''
 * 登录成功
 * #是注释标记,会将后面的语句全部无效化
 * 
 * 输入用户名:张飞' or '1=1
 * 输入密码:
 * select * from user where username = '张飞' or '1=1' and password = ''
 * 登录成功
 * and优先判断,会将1=1和密码判断成一个条件,与用户名进行or判断,只要用户名正确就正确
 * 
 * 输入用户名:
 * 输入密码:' or '2=2
 * select * from user where username = '' and password = '' or '2=2'
 * 登录成功
 * and优先判断,将用户名和密码合并成一个条件,与2=2进行or判断,可以查询出所有的用户信息
 */
public class LoginUser {
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
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.start();
			stat = con.createStatement();
			String s = "select * from user where username = '" + user + "' and password = '" + pwd + "'";
			System.out.println(s);
			rs = stat.executeQuery(s);
			if (rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败,用户名或密码错误!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, stat, rs);
		}
	}
}
