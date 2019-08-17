package com.tedu.test;

import com.tedu.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class Zhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("注册成功!");
		out.write("<br/>");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String[] like = request.getParameterValues("like");
		String city = request.getParameter("city");
		String code = request.getParameter("verifycode");
		String desp = request.getParameter("description");
		out.write("user:" + user);
		out.write("<br/>");
		out.write("pwd:" + pwd);
		out.write("<br/>");
		out.write("gender:" + gender);
		out.write("<br/>");
		String likes = Arrays.toString(like);
		out.write(likes);
		out.write("<br/>");
		for (String s : like) {
			out.write(s);
			out.write("<br/>");
		}
		out.write(city);
		out.write("<br/>");
		out.write(code);
		out.write("<br/>");
		out.write(desp);
		out.write("<br/>");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
//			conn = pool.getConnection();
			conn = JdbcUtils.start();
			String sql = "insert into users values(null,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ps.setString(3, gender);
			ps.setString(4, likes);
			ps.setString(5, city);
			ps.setString(6, desp);
			int i = ps.executeUpdate();
			out.println("注册成功!人数+" + i + ",5秒后跳转");
			response.setHeader("Refresh", "5;url=welcom.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("注册失败!");
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
