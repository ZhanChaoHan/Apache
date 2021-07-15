package com.jachs.commons.lang.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ExceptionUtilsTest {

	private void throwsException() throws Exception{
		throw new Exception("异常");
	}
	@Test
	public void test1() {
		ExceptionUtils eu=new ExceptionUtils();
		
		System.out.println(eu.getMessage(new Throwable("异常")));
	}
}
