package student;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentManager {
	public static void main(String[] args) {
		while (true) {
			System.out.println("a.查询学生表");
			System.out.println("b.添加学生");
			System.out.println("c.修改学生");
			System.out.println("d.删除学生");
			System.out.println("q.退出");
			System.out.print("输入选择:");
			String s = new Scanner(System.in).nextLine();
			if (s.equals("q")) {
				System.out.println("程序结束!");
				break;
			}
			switch (s) {
			case "a":
				find();
				break;
			case "b":
				add();
				break;
			case "c":
				update();
				break;
			case "d":
				delete();
				break;
			default:
				System.out.println("没有这个选项,请重新输入!");
				break;
			}
		}
	}

	private static void find() {
		System.out.println("选择查询方式:");
		System.out.println("a.查询全部");
		System.out.println("b.按学号查询");
		System.out.println("c.按姓名查询");
		System.out.println("d.按性别查询");
		System.out.println("e.按地址查询");
		System.out.println("f.按分数段查询");
		System.out.println("选择:");
		String s = new Scanner(System.in).nextLine();
		String sql = null;
		String l = null;
		switch (s) {
		case "a":
			sql = "select * from stu";
			find(sql);
			break;
		case "b":
			System.out.println("输入学号:");
			l = new Scanner(System.in).nextLine();
			sql = "select * from stu where stuid = ?";
			findby(sql, l);
			break;
		case "c":
			System.out.println("输入姓名:");
			l = new Scanner(System.in).nextLine();
			sql = "select * from stu where name = ?";
			findby(sql, l);
			break;
		case "d":
			System.out.println("输入性别:");
			l = new Scanner(System.in).nextLine();
			sql = "select * from stu where gender = ?";
			findby(sql, l);
			break;
		case "e":
			System.out.println("输入地址:");
			l = new Scanner(System.in).nextLine();
			sql = "select * from stu where addr = ?";
			findby(sql, l);
			break;
		case "f":
			System.out.println("输入分数1:");
			Double d1 = new Scanner(System.in).nextDouble();
			System.out.println("输入分数2:");
			Double d2 = new Scanner(System.in).nextDouble();
			sql = "select * from stu where score between ? and ?";
			findby(sql, d1, d2);
			break;
		default:
			break;
		}
	}

	private static void findby(String sql, Double d1, Double d2) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, d1);
			ps.setDouble(2, d2);
			rs = ps.executeQuery();
			System.out.println("stuid \tname \tgender \taddr \tscore");
			while (rs.next()) {
				String stuid = rs.getString("stuid");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String addr = rs.getString("addr");
				Double score = rs.getDouble("score");
				System.out.println(stuid + "\t" + name + "\t" + gender + "\t" + addr + "\t" + score);
			}
			System.out.println("\n------------------------------------------");
		} catch (Exception e) {
			System.out.println("查询失败!");
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	private static void find(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("stuid \tname \tgender \taddr \tscore");
			while (rs.next()) {
				String stuid = rs.getString("stuid");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String addr = rs.getString("addr");
				Double score = rs.getDouble("score");
				System.out.println(stuid + "\t" + name + "\t" + gender + "\t" + addr + "\t" + score);
			}
			System.out.println("\n------------------------------------------");
		} catch (Exception e) {
			System.out.println("查询失败!");
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	private static void findby(String sql, String l) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, l);
			rs = ps.executeQuery();
			System.out.println("stuid \tname \tgender \taddr \tscore");
			while (rs.next()) {
				String stuid = rs.getString("stuid");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String addr = rs.getString("addr");
				Double score = rs.getDouble("score");
				System.out.println(stuid + "\t" + name + "\t" + gender + "\t" + addr + "\t" + score);
			}
			System.out.println("\n------------------------------------------");
		} catch (Exception e) {
			System.out.println("查询失败!");
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	private static void add() {
		System.out.println("输入学号");
		String id = new Scanner(System.in).nextLine();
		System.out.println("输入姓名");
		String nam = new Scanner(System.in).nextLine();
		System.out.println("输入性别");
		String gen = new Scanner(System.in).nextLine();
		System.out.println("输入地址");
		String add = new Scanner(System.in).nextLine();
		System.out.println("输入分数");
		double sco = new Scanner(System.in).nextDouble();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "insert into stu values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nam);
			ps.setString(3, gen);
			ps.setString(4, add);
			ps.setDouble(5, sco);
			int i = ps.executeUpdate();
			System.out.println("成功添加了" + i + "名学生!");
			System.out.println("\n------------------------------------------");
		} catch (Exception e) {
			System.out.println("增加失败!");
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	private static void update() {
		System.out.println("输入目标学号");
		String id = new Scanner(System.in).nextLine();
		System.out.println("输入需要修改的姓名");
		String nam = new Scanner(System.in).nextLine();
		System.out.println("输入需要修改的性别");
		String gen = new Scanner(System.in).nextLine();
		System.out.println("输入需要修改的地址");
		String add = new Scanner(System.in).nextLine();
		System.out.println("输入需要修改的分数");
		double sco = new Scanner(System.in).nextDouble();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "update stu set name = ?,gender = ?, addr = ?, score = ? where stuid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nam);
			ps.setString(2, gen);
			ps.setString(3, add);
			ps.setDouble(4, sco);
			ps.setString(5, id);
			int i = ps.executeUpdate();
			System.out.println("成功修改了" + i + "名学生!");
			System.out.println("\n------------------------------------------");
		} catch (Exception e) {
			System.out.println("修改失败!");
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	private static void delete() {
		System.out.println("输入目标学号");
		String id = new Scanner(System.in).nextLine();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			String sql = "delete from stu where stuid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			System.out.println("成功删除了" + i + "名学生!");
			System.out.println("\n------------------------------------------");
		} catch (Exception e) {
			System.out.println("删除失败!");
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}
}
