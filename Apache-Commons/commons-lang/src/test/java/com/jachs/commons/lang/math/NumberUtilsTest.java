package com.jachs.commons.lang.math;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class NumberUtilsTest {
	
	@Test
	public void test1() {
		byte bas=NumberUtils.BYTE_MINUS_ONE;
		Byte baa=NumberUtils.BYTE_ONE;
		
		System.out.println(bas);
		System.out.println(baa);
	}
	@Test
	public void test2() {
		System.out.println(NumberUtils.compare(0.1, 0.2));//<
		System.out.println(NumberUtils.compare(0.1, 0.1));//=
		System.out.println(NumberUtils.compare(0.2, 0.1));//>
	}
	@Test
	public void test3() {//数据类型转换
		BigDecimal bigDecimal=NumberUtils.createBigDecimal("58.635748");
		
		System.out.println(bigDecimal.doubleValue());
		
		Double doub=NumberUtils.createDouble("0.6525");
		
		System.out.println(doub);
	}
	@Test
	public void test5() {//取最大数
		System.out.println(NumberUtils.max(0.5,0.3,0.9));
		System.out.println(NumberUtils.max(8,7,2));
		
		System.out.println(NumberUtils.max(new double[] {0.1,0.5,0.9,0.4,0.78,0.99}));
	}
	@Test
	public void test6() {//取最小数
		System.out.println(NumberUtils.min(0.5,0.3,0.9));
		System.out.println(NumberUtils.min(8,7,2));
		
		System.out.println(NumberUtils.min(new double[] {0.1,0.5,0.9,0.4,0.78,0.99}));
	}
	@Test
	public void test7() {//转换基础数据类型
		byte  toByte=NumberUtils.toByte("5");
		int toInt=NumberUtils.toInt("12");
		
		System.out.println(toByte);
		System.out.println(toInt);
		
		int dInt=NumberUtils.toInt("",1);
		
		System.out.println(dInt);
	}
}
