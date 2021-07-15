package com.jachs.commons.io;

import org.apache.commons.io.EndianUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class EndianUtilsTest {

	@Test
	public void test1() {
		System.out.println(EndianUtils.swapDouble(0.5));
	}
}
