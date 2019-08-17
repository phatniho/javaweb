package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test3 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db40", "root", "root");
		Statement stat = conn.createStatement();
		String s = "select * from emp";
		ResultSet ex = stat.executeQuery(s);
		while (ex.next()) {
			int id = ex.getInt("id");
			String name = ex.getString("name");
			String job = ex.getString("job");
			String topid = ex.getString("topid");
			String date = ex.getString("hdate");
			double sal = ex.getDouble("sal");
			String bonus = ex.getString("bonus");
			String dept_id = ex.getString("dept_id");
			System.out.println(
					id + ":" + name + ":" + job + ":" + topid + ":" + date + ":" + sal + ":" + bonus + ":" + dept_id);
		}
		ex.close();
		stat.close();
		conn.close();
	}
}
