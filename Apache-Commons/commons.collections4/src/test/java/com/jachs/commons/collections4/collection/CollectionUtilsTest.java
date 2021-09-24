package com.jachs.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CollectionUtilsTest {
	List<String>sList1=Arrays.asList("a","b","c");
	List<String>sList2=Arrays.asList("A","B","C","F");
	List<String>sList3=Arrays.asList("1","2","3");
	List<Integer>sList5=new ArrayList<Integer>();
	List<String>sList6=Arrays.asList("K","B","C","D");
	
	@Test
	public void test1() {
		//合并数组
		List<String>sList3=CollectionUtils.collate(sList1, sList2);
		
		for (String str : sList3) {
			System.out.println(str);
		}
	}
	/****
	 * 转换数据类型
	 */
	@Test
	public void test2() {
		Collection<Integer>isc=CollectionUtils.collect(sList3, new Transformer<String, Integer>() {
			public Integer transform(String input) {
				return Integer.parseInt(input);
			}
		});
		
		for (Integer integer : isc) {
			System.out.println(integer);
		}
	}
	//过滤
	@Test
	public void test3() {
		sList5.addAll(Arrays.asList(1,2,3,4,5));
		
		CollectionUtils.filter(sList5, new Predicate<Integer>() {
			public boolean evaluate(Integer object) {
				if(object>2) {
					return true;
				}
				return false;
			}
		});
		for (Integer str : sList5) {
			System.out.println(str);
		}
	}
	@Test
	public void test5() {
		//交集
		Collection<String> sList=CollectionUtils.intersection(sList2, sList6);
		
		for (String str : sList) {
			System.out.println(str);
		}
		System.out.println("---------------------------------");
		//差集
		Collection<String> lsList=CollectionUtils.subtract(sList2, sList6);
		for (String str : lsList) {
			System.out.println(str);
		}
	}
	@Test
	public void test6() {
		//结合二个数组
		Collection<String> sList=CollectionUtils.union(sList1, sList2);
		for (String str : sList) {
			System.out.println(str);
		}
	}
}
