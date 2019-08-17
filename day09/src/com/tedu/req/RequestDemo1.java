package com.tedu.req;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request功能一：获取请求参数
 * 	getParameter()
 * 	getParameterValues()
 */
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		//获取用户名
		String user = request.getParameter("user");
		System.out.println("user:"+user);
		
		//处理POST提交的参数乱码问题
		request.setCharacterEncoding("utf-8");
			
		//获取爱好
		String[] likes = request
				.getParameterValues("like");
		for(String like : likes) {
			System.out.println(like);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
