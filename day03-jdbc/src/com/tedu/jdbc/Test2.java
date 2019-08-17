package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class Test2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///jt_db", "root", "root");
		Statement cs = conn.createStatement();
		String s = "select * from account";
		ResultSet eq = cs.executeQuery(s);
		while (eq.next()) {
			int id = eq.getInt("id");
			String name = eq.getString("name");
			double money = eq.getDouble("money");
			System.out.println(id + ":" + name + ":" + money);
		}
		eq.close();
		cs.close();
		conn.close();
	}
}
