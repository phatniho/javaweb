package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.dan.EmpMapper;
import com.tedu.pojo.Emp;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SqlSessionFactory factory;
	private static SqlSession session;
	private static EmpMapper mapper;
	static {
		try {
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
			mapper = session.getMapper(EmpMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String i = request.getParameter("id");
		Integer id = Integer.parseInt(i);
		String name = request.getParameter("name");
		out.write("登录成功");
		Map map = new HashMap();
		map.put("id", id);
		map.put("name", name);
		Emp emp = mapper.login(map);
		out.write(emp.toString());
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
