package com.jachs.commons.lang.math;

import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

/****
 * 
 * @author zhanchaohan
 *
 */
public class FractionTest {

	@Test
	public void test1() {
		//4/5,0.8
		Fraction fraction=Fraction.FOUR_FIFTHS;
		
		System.out.println(fraction.doubleValue());
		//1+4/5=9/5
		System.out.println(fraction.add(Fraction.ONE));
		System.out.println(fraction.add(Fraction.ONE).doubleValue());
	}
}
