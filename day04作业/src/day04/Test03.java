package day04;

import com.tedu.util.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test03 {
	@Test
	public void addAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
			stat = conn.createStatement();
			String sql = "insert into account values(null,'lucy',3500)";
			int i = stat.executeUpdate(sql);
			System.out.println("操作成功，新增了" + i + "行数据。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stat, rs);
		}
	}

	@Test
	public void updateAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
			stat = conn.createStatement();
			String sql = "update account set money = 1500 where name = 'lucy'";
			int i = stat.executeUpdate(sql);
			System.out.println("操作成功，修改了" + i + "行数据。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stat, rs);
		}
	}

	@Test
	public void deleteAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
			stat = conn.createStatement();
			String sql = "delete from account where name = 'lucy'";
			int i = stat.executeUpdate(sql);
			System.out.println("操作成功，删除了" + i + "行数据。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stat, rs);
		}
	}

	@Test
	public void findAcc() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.start();
			stat = conn.createStatement();
			String sql = "select * from account where name = 'lucy'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double money = rs.getDouble("money");
				System.out.println("id:" + id + "--name:" + name + "--money:" + money);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stat, rs);
		}
	}
}
