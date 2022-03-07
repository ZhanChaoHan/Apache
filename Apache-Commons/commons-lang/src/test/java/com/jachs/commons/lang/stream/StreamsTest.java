package com.jachs.commons.lang.stream;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.stream.Streams;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class StreamsTest {

	@Test
	public void test1() {
		Streams streams=new Streams();
		
		List<String>sList=new ArrayList<String>();
		sList.add("A");
		sList.add("f");
		sList.add("e");
		sList.add("d");
		
		streams.stream(sList).forEach(System.out::println);
	}
}
