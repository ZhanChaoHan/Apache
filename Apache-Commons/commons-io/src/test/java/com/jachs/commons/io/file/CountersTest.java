package com.jachs.commons.io.file;

import org.apache.commons.io.file.Counters;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CountersTest {
	Counters cou=new Counters();
	
	@Test
	public void test1() {
		cou.bigIntegerCounter();
		
	}
}
