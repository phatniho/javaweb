package com.tedu;

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

public class AjaxCheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		boolean flag = checkUsernameIsExist(username);
		String responseText = flag ? "用户名已存在" : "恭喜用户名可以使用";
		response.getWriter().write(responseText);

	}

	private boolean checkUsernameIsExist(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.注册驱动、获取连接对象
			conn = JdbcUtils.start();
			// 2.声明查询SQL,获取传输器对象
			String sql = "select * from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			// 3.执行SQL语句,获取结果集
			rs = ps.executeQuery();
			// 4.处理结果集，返回true:表示用户名存在,反之则不存在!
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败!");
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
