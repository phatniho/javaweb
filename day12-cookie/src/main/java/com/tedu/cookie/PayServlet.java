package com.tedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 负责对购物车中的商品进行结算
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 1.获取请求中的所有cookie组成的数组
		Cookie[] cs = request.getCookies();
		// 2.遍历cookie数组,找到名称为prod的cookie
		String prod = null;
		if (cs == null) {
			out.write("<h1>购物车为空!</h1>");
		} else {
			for (Cookie c : cs) {
				if ("prod".equals(c.getName())) {// c.getName()放后面是为了防止null值引起空指针异常
					prod = c.getValue();
				}
			}
		}
		// 3.从cookie获取之前添加的商品信息

		// 4.(响应)模拟支付,为商品进行支付
		if (prod == null) {
			out.write("<h1>没有找到可以支付的商品</h1>");
		} else {
			out.write("<h1>成功为" + prod + "支付了1000.0元</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
