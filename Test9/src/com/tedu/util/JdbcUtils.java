package com.tedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtils {
	private JdbcUtils() {// 私有化构造方法,不允许创建该类的对象
	}

	public static void close(AutoCloseable a) {// 单独关闭指定资源,也可以接收 Wrapper a接口对象
		if (a != null) {
			try {
				a.close();
			} catch (Exception e2) {
			} finally {
				a = null;
			}
		}
	}

	public static void close(Connection c, Statement s, ResultSet r) {// 方法重载,全部关闭资源
		close(r);// 调用单参方法
		close(s);
		close(c);
	}

	public static Connection start() throws Exception {// 获取本地数据库中的特定表连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(//
				"jdbc:mysql://localhost:3306/db60?characterEncoding=utf-8", "root", "root");
		return conn;
	}
}
