package com.tedu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JdbcUtils;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "select * from users where user = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (!rs.next()) {
				out.write("登录失败!用户名或密码错误!");
			} else {
				out.write("登录成功!");
				String id = null;
				String name = null;
				String password = null;
				String gender = null;
				String like = null;
				String city = null;
				String desc = null;
//				while (rs.next()) {
				id = rs.getString("id");
				name = rs.getString("user");
				password = rs.getString("password");
				gender = rs.getString("gender");
				like = rs.getString("like");
				city = rs.getString("city");
				desc = rs.getString("description");
				out.write("<br/>");
				out.write(id);
				out.write("<br/>");
				out.write(name);
				out.write("<br/>");
				out.write(password);
				out.write("<br/>");
				out.write(gender);
				out.write("<br/>");
				out.write(like);
				out.write("<br/>");
				out.write(city);
				out.write("<br/>");
				out.write(desc);
				out.write("<br/>");
				out.write("登录成功,5秒后跳转到主页");
				response.setHeader("Refresh", "5;url=success.jsp");
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("登录失败!");
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
