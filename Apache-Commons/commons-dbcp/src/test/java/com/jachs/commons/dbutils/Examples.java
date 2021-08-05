package com.jachs.commons.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Before;
import org.junit.Test;

import com.jachs.commons.dbcp.BasicDataSourceDemo;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Examples {
	private BasicDataSource bds = new BasicDataSource();

	@Before
	public void init() throws Exception {
		Properties properties = new Properties();
		properties.load(BasicDataSourceDemo.class.getResourceAsStream("config.properties"));
		BasicDataSourceFactory bdsf = new BasicDataSourceFactory();
		bds = bdsf.createDataSource(properties);
	}

	/****
	 * 查单条
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		ResultSetHandler<Object[]> h = new ResultSetHandler<Object[]>() {
			public Object[] handle(ResultSet rs) throws SQLException {
				if (!rs.next()) {
					return null;
				}

				ResultSetMetaData meta = rs.getMetaData();
				int cols = meta.getColumnCount();
				Object[] result = new Object[cols];

				for (int i = 0; i < cols; i++) {
					result[i] = rs.getObject(i + 1);
				}
				return result;
			}
		};
		QueryRunner run = new QueryRunner(bds);
		Object[] result = run.query("SELECT id FROM config_areas WHERE areaid=?", h, "130101");
		for (Object object : result) {
			System.out.println(object);
		}
	}

	/****
	 * 查多条
	 * @throws SQLException
	 */
	@Test
	public void test1() throws SQLException {
		ResultSetHandler<List<Object[]>> h = new ResultSetHandler<List<Object[]>>() {
			public List<Object[]> handle(ResultSet rs) throws SQLException {
				List<Object[]> data = new ArrayList<Object[]>();

				while (rs.next()) {
					Object[] date = new Object[4];
					date[0] = rs.getObject(1);
					date[1] = rs.getObject(2);
					date[2] = rs.getObject(3);
					date[3] = rs.getObject(4);

					data.add(date);
				}
				return data;
			}
		};

		QueryRunner run = new QueryRunner();
		Connection conn = bds.getConnection();
		try {
			List<Object[]> result = run.query(conn, "SELECT * FROM config_areas WHERE cityid=?", h, "130100");
			for (Object[] object : result) {
				System.out.println(object[0]+"\t"+object[1]+"\t"+object[2]+"\t"+object[3]);
			}
		} finally {
			DbUtils.close(conn);
		}
	}
}
