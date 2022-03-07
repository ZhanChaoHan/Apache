package com.jachs.commons.lang.time;


import org.apache.commons.lang3.time.CalendarUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CalendarUtilsTest {
	CalendarUtils cu=CalendarUtils.INSTANCE;
	
	//获取当前天为当前月第几天  
	@Test
	public void test1() {
		System.out.println(cu.getDayOfMonth());
	}
	//获取当前月
	@Test
	public void test2() {
		System.out.println(cu.getMonth());
	}
	//获取当前年
	@Test
	public void test3() {
		System.out.println(cu.getYear());
	}
}
