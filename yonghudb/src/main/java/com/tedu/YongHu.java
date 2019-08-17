package com.tedu;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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
import java.util.ArrayList;
import java.util.Iterator;

public class YongHu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int id = 0;
			String name = null;
			String job = null;
			double salary = 0.0;
			ArrayList<Emp> al = new ArrayList<Emp>();
			while (rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				job = rs.getString("job");
				salary = rs.getDouble("salary");
				Emp e = new Emp(id, name, job, salary);
				al.add(e);
			}
			Iterator<Emp> it = al.iterator();
			while (it.hasNext()) {
				Emp e = it.next();
				out.write(e.toString() + "<br/>");
				System.out.println(e.toString());
			}
		} catch (Exception e) {
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
