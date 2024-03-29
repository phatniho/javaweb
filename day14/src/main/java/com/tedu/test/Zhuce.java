package com.tedu.test;

import com.tedu.dan.EmpMapper;
import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class Zhuce extends HttpServlet {
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
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String sal = request.getParameter("salary");
		Double salary = Double.parseDouble(sal);
		Emp emp = new Emp(null, name, job, salary);
		mapper.addUser(emp);
		session.commit();
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
