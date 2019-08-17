package com.tedu.jdbc;

import com.tedu.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 通过JDBC查询yonghedb库中Emp表中的所有数据
 * 将每一条记录封装到一个Emp对象中
 * 将多条记录的多个Emp对象封装到一个list<Emp>集合并返回
 */
public class TestJdbc {
	public static void main(String[] args) {
		List<Emp> list = findAll();
		Iterator<Emp> it = list.iterator();
		while (it.hasNext()) {
			Emp emp = it.next();
			System.out.println(emp);
		}
	}

	// 查询所有员工信息
	private static List<Emp> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///yonghedb", "root", "root");
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Emp> list = new ArrayList<Emp>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String job = rs.getString("job");
				Double salary = rs.getDouble("salary");
				Emp emp = new Emp(id, name, job, salary);
				list.add(emp);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败!");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					rs = null;
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					ps = null;
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}
		}
		return null;
	}
}
