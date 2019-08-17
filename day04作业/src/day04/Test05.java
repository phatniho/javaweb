package day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test05 {
	@Test
	public void addAcc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8");
			pool.setUser("root");
			pool.setPassword("root");
			conn = pool.getConnection();
			String sql = "insert into user values(null,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张三丰");
			ps.setString(2, "123");
			int i = ps.executeUpdate();
			System.out.println("操作成功，修改了" + i + "行数据！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	@Test
	public void updateAcc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8");
			pool.setUser("root");
			pool.setPassword("root");
			conn = pool.getConnection();
			String sql = "update user set password = ? where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "123456");
			ps.setString(2, "张三丰");
			int i = ps.executeUpdate();
			System.out.println("操作成功，修改了" + i + "行数据！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	@Test
	public void deleteAcc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8");
			pool.setUser("root");
			pool.setPassword("root");
			conn = pool.getConnection();
			String sql = "delete from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张三丰");
			int i = ps.executeUpdate();
			System.out.println("操作成功，修改了" + i + "行数据！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}

	@Test
	public void findAcc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8");
			pool.setUser("root");
			pool.setPassword("root");
			conn = pool.getConnection();
			String sql = "select * from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张三丰");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String pwd = rs.getString("password");
				System.out.println("id:" + id + "--username:" + user + "--password:" + pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}
}
