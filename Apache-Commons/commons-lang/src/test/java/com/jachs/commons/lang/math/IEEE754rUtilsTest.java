package com.jachs.commons.lang.math;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class IEEE754rUtilsTest {
	
	//获取最大数
	@Test
	public void test1() {
		System.out.println(IEEE754rUtils.max(5,9,4,2,3,5,1,2));
		System.out.println(IEEE754rUtils.max(0.2,0.9,0.3,0.78));
	}
	//获取最小数
	@Test
	public void test2() {
		System.out.println(IEEE754rUtils.min(5,9,4,2,3,5,1,2));
		System.out.println(IEEE754rUtils.min(0.2,0.9,0.3,0.78));
	}
}
