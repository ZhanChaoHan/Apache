package com.jachs.commons.lang.compare;

import java.util.function.Predicate;

import org.apache.commons.lang3.compare.ComparableUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ComparableUtilsTest {
	
	//匹配a或者b
	@Test
	public void test1() {
		String a="a";
		String b="b";
		Predicate<String> cu=ComparableUtils.between(a,b);
		
		System.out.println(cu.test("c"));
		System.out.println(cu.test("a"));
	}
	//匹配a-x之间全部
	@Test
	public void test2() {
		String a="a";
		String b="x";
		Predicate<String> cu=ComparableUtils.between(a,b);
		
		System.out.println(cu.test("c"));
		System.out.println(cu.test("z"));
	}
	
	@Test
	public void test3() {
		int a=1;
		int b=10;
		Predicate<Integer> cu=ComparableUtils.between(a,b);
		
		System.out.println(cu.test(0));
		System.out.println(cu.test(5));
	}
}
