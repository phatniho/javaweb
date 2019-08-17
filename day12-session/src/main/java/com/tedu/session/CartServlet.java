package com.tedu.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 负责将商品加入垢污车
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 1.获取要添加到购物车的商品信息
		String prod = request.getParameter("prod");
		// 2.获取一个session对象
		HttpSession session = request.getSession();
		// 创建一个cookie,用于保存session的id
		Cookie c = new Cookie("JSESSIONID", session.getId());
		// 设置cookie的最大存活时间,这样即使浏览器关闭,cookie也不会销毁,id也不会丢失
		c.setMaxAge(60 * 60 * 24);
		// 将保存session的id的cookie发送给浏览器
		response.addCookie(c);
		// 3.将商品信息保存到session对象中
		session.setAttribute("prod", prod);
		// 4.做出响应
		out.write("<h1>已将" + prod + "加入购物车!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
