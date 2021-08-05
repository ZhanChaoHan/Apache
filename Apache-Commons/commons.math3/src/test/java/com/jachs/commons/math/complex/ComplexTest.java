package com.jachs.commons.math.complex;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ComplexTest {
	
	
	@Test
	public void test1() {
		Complex complex=new Complex(20.2258);
		
		System.out.println(complex.abs());
		System.out.println(complex.getArgument());
		System.out.println(complex.getImaginary());
		System.out.println(complex.getReal());
		complex.acos();
		
	}
}
