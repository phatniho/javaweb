package day04;

import com.tedu.util.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test04 {
	@Test
	public void addAcc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
			String sql = "insert into user values(null,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张三");
			ps.setString(2, "123");
			int i = ps.executeUpdate();
			System.out.println("操作成功，新增了" + i + "行数据。");
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
		try {
			conn = JdbcUtils.start();
			String sql = "update user set password = ? where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "123456");
			ps.setString(2, "张三");
			int i = ps.executeUpdate();
			System.out.println("操作成功，修改了" + i + "行数据。");
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
		try {
			conn = JdbcUtils.start();
			String sql = "delete from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张三");
			int i = ps.executeUpdate();
			System.out.println("操作成功，新增了" + i + "行数据。");
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
		try {
			conn = JdbcUtils.start();
			String sql = "select * from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "张三");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String pwd = rs.getString("password");
				System.out.println("id:" + id + "--user:" + user + "--pwd:" + pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}
}
