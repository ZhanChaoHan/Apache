package com.jachs.commons.dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbcp2.managed.BasicManagedDataSource;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class BasicManagedDataSourceDemo {
	/****
	 * 这个对象主要为了初始化读取配置文件生成BasicDataSource
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBasicDataSourceFactory() throws Exception {
		Properties properties = new Properties();
		properties.load(BasicDataSourceDemo.class.getResourceAsStream("config.properties"));
		BasicDataSourceFactory bdsf = new BasicDataSourceFactory();
		BasicDataSource bds = bdsf.createDataSource(properties);
		Connection connection = bds.getConnection();

		ResultSet resultSet = connection.createStatement().executeQuery("select * from config_areas");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
		}
	}

	/*****
	 * 管理BasicDataSource的对象,继承了BasicDataSource就是对BasicDataSource的管理添加了事务
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBasicManagedDataSource() throws Exception {
		BasicManagedDataSource bmds = new BasicManagedDataSource();
		bmds.setDriverClassName("com.mysql.jdbc.Driver");
		bmds.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		bmds.setUsername("root");
		bmds.setPassword("");
		TransactionManager transactionManager=new MyTransactionManager();//自己随便定义的事务啥都没写
//		HibernateTransactionManager htm=new HibernateTransactionManager();//可以看看Spring的源码，放着深入
		
		bmds.setTransactionManager(transactionManager);
		transactionManager.begin();
		Connection connection = bmds.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from config_areas");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
		}
		transactionManager.rollback();
	}
}
