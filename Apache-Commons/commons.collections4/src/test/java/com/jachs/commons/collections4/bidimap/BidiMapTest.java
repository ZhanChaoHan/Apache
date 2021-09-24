package com.jachs.commons.collections4.bidimap;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;

/***
 * 使用双向映射，可以使用值查找键，并且可以使用键轻松查找值。
 * @author zhanchaohan
 *
 */
public class BidiMapTest {

	@Test
	public void test1() {
		BidiMap<String, String>bMap=new DualHashBidiMap<String, String>();
		
		bMap.put("one", "a");
		bMap.put("two", "b");
		bMap.put("three", "c");
		bMap.put("four", "d");
		bMap.put("five", "e");
		
		System.out.println("指定key查询value"+bMap.get("one"));
		System.out.println("指定value查询key"+bMap.getKey("a"));
		System.out.println("--------------------------------");
		for (String key : bMap.keySet()) {
			System.out.println(key+":"+bMap.get(key));
		}
		System.out.println("---------------------------翻转key,value-----------------");
		BidiMap<String, String>ivsbMap=	bMap.inverseBidiMap();
		for (String key : ivsbMap.keySet()) {
			System.out.println(key+":"+ivsbMap.get(key));
		}
	}
}
