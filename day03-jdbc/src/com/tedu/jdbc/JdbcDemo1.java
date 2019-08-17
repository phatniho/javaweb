package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC的快速入门程序 查询account表中的所有记录,并输出到控制台
 */
public class JdbcDemo1 {
	public static void main(String[] args) throws Exception {
		// 1.注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");// 把绝对路径下的指定类加载到内存中
		// 2.获取数据库连接
		Connection con = DriverManager.getConnection(// 用数据库驱动管理类的方法获取数据库连接
				// jdbc连接数据库-本地主机--端口号-连接的数据库-用户名---密码
				"jdbc:mysql://localhost:3306/jt_db", "root", "root");
		// 3.获取传输器
		Statement stat = con.createStatement();// 用连接类的工具创建传输器
		// 4.发送SQL到数据库执行,并返回执行结果
		String sql = "select * from account";// 获取sql语句
		ResultSet rs = stat.executeQuery(sql);// 用传输器方法将sql语句传输到数据库执行,并返回结果
		// 5.处理结果(输出到控制台)
		while (rs.next()) {// 循环获取结果对象
			int id = rs.getInt("id");// 获取结果对象的id
			String name = rs.getString("name");// 获取结果对象的name
			double money = rs.getDouble("money");// 获取结果对象的money
			System.out.println(id + ":" + name + ":" + money);// 打印字符串
		}
		// 6.释放资源
		rs.close();// 关闭结果连接
		stat.close();// 关闭传输器
		con.close();// 关闭数据库连接
		System.out.println("执行完成!");
	}
}
