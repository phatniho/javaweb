package com.tedu.req;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 访问RequestDemo2，负责查询当前用户的个人信息
 * 将用户的个人信息转向JSP，由JSP负责做响应
 */
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1.模拟查询当前用户的个人信息
		String user = "王海涛";
		String addr = "北京";
		
		//2.将个人信息存入request的map集合中
		request.setAttribute("user", user);
		request.setAttribute("addr", addr);
		System.out.println("数据已经存入了request域中...");
		//3.将请求和request对象一起转发到jsp
		request.getRequestDispatcher("RequestDemo3")
				.forward(request, response);
		
		/*
		 * //2.做出响应 out.write("<!doctype html>"); out.write("<html>");
		 * out.write("<head>"); out.write("<style>");
		 * out.write("p{border:1px solid red;}"); out.write("</style>");
		 * out.write("</head>"); out.write("<body>"); out.write("<p>姓名: "+user+"</p>");
		 * out.write("<p>地址: "+addr+"</p>"); out.write("</body>"); out.write("</html>");
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}





