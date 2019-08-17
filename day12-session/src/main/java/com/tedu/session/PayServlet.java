package com.tedu.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 对购物车商品进行结算
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 1.获取之前的session对象
		HttpSession session = request.getSession();
		// 2.从session中获取要支付的商品信息
		String prod = (String) session.getAttribute("prod");
		// 3.(响应)模拟为商品进行结算
		if (prod == null) {
			out.write("<h1>购物车里没有商品!</h1>");
		} else {
			out.write("<h1>已为" + prod + "结算,花费1000元!</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
