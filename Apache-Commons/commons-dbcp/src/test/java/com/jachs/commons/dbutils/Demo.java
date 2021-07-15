package com.jachs.commons.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;

import com.jachs.commons.dbcp.BasicDataSourceDemo;


/****
 * 文档http://commons.apache.org/proper/commons-dbutils/apidocs/index.html
 * 示例http://commons.apache.org/proper/commons-dbutils/examples.html
 * 
 * @author zhanchaohan
 *
 */
public class Demo {
	private BasicDataSource bds = new BasicDataSource();

	@Before
	public void init() throws Exception {
		Properties properties = new Properties();
		properties.load(BasicDataSourceDemo.class.getResourceAsStream("config.properties"));
		BasicDataSourceFactory bdsf = new BasicDataSourceFactory();
		bds = bdsf.createDataSource(properties);
	}

	@Test
	public void insert() throws SQLException {
//		QueryRunner run = new QueryRunner();
		QueryRunner run = new QueryRunner(bds, true);// 使用的QueryRunner的构造函数。
		ScalarHandler scalarHandler = new ScalarHandler();
		run.insert("insert into test value('lks',15,'日本')", scalarHandler);
		run.insert("insert into test value(?,?,?)", scalarHandler, "zhangsan", 20, "南京");
	}

	@Test
	public void delete() throws SQLException {
		QueryRunner run = new QueryRunner(bds, true);
//		int index=run.execute("delete from test where name=? or name=?", "zhangsan","lks");
		int count = run.execute("delete from test where name='zhangsan' or name='lks'");
		System.out.println(count);
	}

	@Test
	public void update() throws SQLException {
		QueryRunner run = new QueryRunner(bds, true);
//		int count=run.update("update test set name='lisi' where name='lks'");
		int count = run.update("update test set name=? where name=?", "lisi", "lks");
		System.out.println(count);
	}

	/****
	 * 查询 1. ResultSetHandler 的作用: QueryRunner 的 query 方法的返回值最终取决于 query 方法的
	 * ResultHandler 参数的 hanlde 方法的返回值。 2. BeanListHandler: 把结果集转为一个 Bean 的 List,
	 * 并返回.。Bean的类型在创建 BeanListHanlder对象时以 Class对象的方式传入，可以适应列的别名来映射 JavaBean 的属性 名:
	 * String sql = "SELECT id, name customerName, email, birth " + "FROM customers
	 * WHERE id = ?"; BeanListHandler(Class<T> type)。 3. BeanHandler: 把结果集转为一个
	 * Bean,并返回.。Bean的类型在创建BeanHandler 对象时以 Class 对象的方式传入 BeanHandler(Class<T>
	 * type)。 4. MapHandler: 把结果集转为一个 Map 对象, 并返回。若结果集中有多条记录, 仅返回
	 * 第一条记录对应的Map对象.。Map的键: 列名(而非列的别名), 值: 列的值。 5. MapListHandler: 把结果集转为一个 Map
	 * 对象的集合, 并返回.。Map的键: 列名(而非列的别名), 值: 列的值。 6. ScalarHandler:
	 * 可以返回指定列的一个值或返回一个统计函数的值，比如count(1)。
	 * 
	 * @throws SQLException
	 */
	@Test
	public void query() throws SQLException {
		ResultSetHandler<List<List<Object>>> rsh = new ResultSetHandler<List<List<Object>>>() {
			public List<List<Object>> handle(ResultSet rs) throws SQLException {
				List<List<Object>> data = new ArrayList<List<Object>>();
				while (rs.next()) {
					List<Object> obj = new ArrayList<Object>();
					obj.add(rs.getObject(1));
					obj.add(rs.getObject(2));
					obj.add(rs.getObject(3));
					data.add(obj);
				}
				return data;
			}
		};
		QueryRunner run = new QueryRunner(bds, true);
		String sql = "select * from test where name='lisi' or name='zhangsan' or name='张三'";
		List<List<Object>> ls = run.query(sql, rsh);
		for (List<Object> list : ls) {
			System.out.println(list.get(0) + "\t" + list.get(1) + "\t" + list.get(2));
		}
	}

	@Test
	public void query1() throws SQLException {
//		QueryRunner run = new QueryRunner(bds, true);
//		BeanHandler bh = new BeanHandler<test>(test.class);
//		String sql = "select * from test where name=?";
//		test tsArr = run.query(sql, "lisi", bh);
//		System.out.println(tsArr.getName() + "\t" + tsArr.getAge() + "\t" + tsArr.getArea());

		// 提供了一个自定义接口RowProcessor,要自己实现
//		MyRowProcessor mrp = new MyRowProcessor();
		// 多条
		QueryRunner run = new QueryRunner(bds, true);
		ResultSetHandler<Map<String, test>> h = new BeanMapHandler<String, test>(test.class, "name");
		String sql = "select * from test where name=? or name=? or name=?";
		Map<String, test> tsArr = run.query(sql, new String[] { "lisi", "zhangsan", "张三" }, h);
		for (String key : tsArr.keySet()) {
			System.out.println(key);
			System.out.println(tsArr.get(key).getName()+"\t"+tsArr.get(key).getAge()+"\t"+tsArr.get(key).getAge());
			System.out.println("-----------------------------------------");
		}
	}
}
