package com.jachs.commons.lang.compare;

import org.apache.commons.lang3.compare.ObjectToStringComparator;
import org.junit.Test;

import com.jachs.commons.reflect.ClassForTest;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ObjectToStringComparatorTest {

	
	@Test
	public void test1() {
		ObjectToStringComparator otsc=ObjectToStringComparator.INSTANCE;
		
		System.out.println(otsc.compare("a", "b"));
		System.out.println(otsc.compare("a", "a"));
		System.out.println("-----------------------");
		System.out.println(otsc.compare(1, 10));
		System.out.println(otsc.compare(10, 1));
		System.out.println("-----------------------");
		System.out.println(otsc.compare(new ClassForTest("MyNameIs12",12), new ClassForTest("MyNameIs12",12)));
		System.out.println(otsc.compare(new ClassForTest("MyNameIs12",12), new ClassForTest("MyNameIs10",10)));
	}
}
