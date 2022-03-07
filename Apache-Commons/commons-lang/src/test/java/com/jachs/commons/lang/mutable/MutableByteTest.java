package com.jachs.commons.lang.mutable;

import org.apache.commons.lang3.mutable.MutableByte;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class MutableByteTest {
	
	@Test
	public void test1() {
		MutableByte mb=new MutableByte();
		mb.add(12);
		
		System.out.println(mb.decrementAndGet());
	}
}
