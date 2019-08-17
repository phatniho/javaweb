package com.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 既可以通知服务器使用utf-8发送数据
		 * 同时也可以通知浏览器使用utf-8接收数据
		 */
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("你好~~~");
		out.write("你好~~~");
		out.write("你好~~~");
		out.write("你好~~~");
		out.write("你好~~~");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}





