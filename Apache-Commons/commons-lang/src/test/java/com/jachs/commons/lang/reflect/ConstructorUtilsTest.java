package com.jachs.commons.lang.reflect;

import java.lang.reflect.Constructor;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.junit.Test;

import com.jachs.commons.reflect.ClassForTest;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ConstructorUtilsTest {

	@Test
	public void test1() throws Exception {
		ConstructorUtils cu=new ConstructorUtils();
		Constructor<ClassForTest> cft=cu.getAccessibleConstructor(ClassForTest.class);
		
		System.out.println(cft.getName());
		
		ClassForTest cfts=cu.invokeConstructor(ClassForTest.class, "zhnag",12);
		
		System.out.println(cfts.getName());
	}
}
