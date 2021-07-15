package com.jachs.commons.dbcp;

import java.sql.Connection;
import java.sql.ResultSet;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceMXBean;
import org.apache.commons.dbcp2.managed.BasicManagedDataSource;
import org.junit.Test;

/****
 * 配置http://commons.apache.org/proper/commons-dbcp/configuration.html
 * 文档http://commons.apache.org/proper/commons-dbcp/api-2.6.0/index.html
 * 
 * @author zhanchaohan
 *
 */
public class BasicDataSourceDemo {
	/****
	 * 一个泛型接口主要读取数据源信息,BasicManagedDataSource差不多都有了没啥用的对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void testBasicDataSourceMXBean() throws InstantiationException, IllegalAccessException {
		BasicDataSourceMXBean bdsMXBean=new BasicManagedDataSource();
	}
	
	/****
	 * 数据源对象
	 * @throws Exception
	 */
	@Test
	public void testBasicDataSource() throws Exception {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		bds.setUsername("root");
		bds.setPassword("");
		bds.setCacheState(true);// 设置缓存状态
		bds.setMaxWaitMillis(10000);// 最大等待时间
		
		Connection connection = bds.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from config_areas");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
		}
	}
}
