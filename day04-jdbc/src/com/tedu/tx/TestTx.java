package com.tedu.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestTx {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			conn = pool.getConnection();
			conn.setAutoCommit(false);// 关闭自动提交(默认打开事务)
			String sql = "update acc set money = money - 100 where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "A");
			int i = ps.executeUpdate();
			System.out.println("修改成功,修改行数:" + i);
//			int a = 1/0;
			sql = "update acc set money = money + 100 where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "B");
			i = ps.executeUpdate();
			System.out.println("修改成功,修改行数:" + i);
			conn.commit();// 手动提交事务
			System.out.println("成功!");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();// 事务回滚
			System.out.println("失败,回滚...");
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
	}
}
