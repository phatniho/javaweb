package com.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的快速入门程序 查询account表中的所有记录,并输出到控制台
 */
public class JdbcDemo2 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			// 1.注册数据库驱动
			Class.forName("com.mysql.jdbc.Driver");// 把绝对路径下的指定类加载到内存中
			// 2.获取数据库连接
			con = DriverManager.getConnection(// 用数据库驱动管理类的方法获取数据库连接
					// jdbc连接数据库-本地主机--端口号-连接的数据库-用户名---密码
					"jdbc:mysql:///jt_db", "root", "root");
			// 如果连接本机数据库,端口为3306,可以省略不写
			// 3.获取传输器
			stat = con.createStatement();// 用连接类的工具创建传输器对象,用于向数据库发送SQL语句
			// con.prepareStatement(null);// 创建传输器对象,是Statement对象的子对象,比父对象更安全,更高效
			// 4.发送SQL到数据库执行,并返回执行结果
			String sql = "select * from account";// 获取sql语句
			// 用传输器方法将查询类sql语句传输到数据库执行,并返回结果集
			rs = stat.executeQuery(sql);
			// executeUpdate(sql) 发送增删改类型的sql语句,返回int值,表示该语句执行后影响的记录行数
			// 5.处理结果(输出到控制台)
			while (rs.next()) {// 循环获取结果集对象,获取下一行,默认表头
				int id = rs.getInt("id");// 获取结果集对象的id
				String name = rs.getString("name");// 获取结果集对象的name
				double money = rs.getDouble("money");// 获取结果集对象的money
				System.out.println(id + ":" + name + ":" + money);// 打印对象字符串
			}
			System.out.println("执行完成!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("执行失败!");
		} finally {// 这里的代码一定会被执行
			// 6.释放资源
			if (rs != null) {
				try {
					rs.close();// 关闭结果集连接
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					rs = null;// 将对象引用设为空,等待垃圾回收器自动回收
				}
			}
			if (stat != null) {
				try {
					stat.close();// 关闭传输器
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					stat = null;
				}
			}
			if (con != null) {
				try {
					con.close();// 关闭数据库连接
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					con = null;
				}
			}
		}
	}
}
