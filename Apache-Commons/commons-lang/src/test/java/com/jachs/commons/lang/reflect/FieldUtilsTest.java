package com.jachs.commons.lang.reflect;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import com.jachs.commons.reflect.ClassForTest;

/***
 * 
 * @author zhanchaohan
 *
 */
public class FieldUtilsTest {
	
	//获取全部字段
	@Test
	public void test1() {
		Field[] fLst=FieldUtils.getAllFields(ClassForTest.class);
		
		for (Field field : fLst) {
			System.out.println(field.getName());
		}
	}
	@Test
	public void test2() {
		List<Field>fList=FieldUtils.getAllFieldsList(ClassForTest.class);
		
		fList.forEach(a->{
			System.out.println(a.getName());
		});
	}
	@Test
	public void test3() throws Exception {
		
	}
}
