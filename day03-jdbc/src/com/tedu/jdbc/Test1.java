package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 1.注册数据库驱动
// 把绝对路径下的指定类加载到内存中
// 2.获取数据库连接
// 用数据库驱动管理类的方法获取数据库连接
// jdbc连接数据库-本地主机--端口号-连接的数据库-用户名---密码
// 3.获取传输器
// 用连接类的工具创建传输器
// 4.发送SQL到数据库执行,并返回执行结果
// 获取sql语句
// 用传输器方法将sql语句传输到数据库执行,并返回结果
// 5.处理结果(输出到控制台)
// 循环获取结果对象
// 获取结果对象的id
// 获取结果对象的name
// 获取结果对象的money
// 打印字符串
// 6.释放资源
// 关闭结果连接
// 关闭传输器
// 关闭数据库连接
public class Test1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet ex = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jt_db", "root", "root");
			stat = conn.createStatement();
			String s = "select * from account";
			ex = stat.executeQuery(s);
			while (ex.next()) {
				int id = ex.getInt("id");
				String name = ex.getString("name");
				double money = ex.getDouble("money");
				System.out.println(id + ":" + name + ":" + money);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ex != null) {
				try {
					ex.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					ex = null;
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					stat = null;
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
	}
}
