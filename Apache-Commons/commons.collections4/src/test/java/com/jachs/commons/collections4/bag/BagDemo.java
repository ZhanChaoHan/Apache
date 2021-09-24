package com.jachs.commons.collections4.bag;

import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

/***
 * Bag接口定义了一个集合，它可以计算一个对象出现在集合中的次数。
 * 例如，如果Bag包含{a，a，b，c}，则getCount("a")方法将返回2，而uniqueSet()返回唯一值。
 * 
 * @author zhanchaohan
 *
 */
public class BagDemo {
	@Test
	public void test1() {
		Bag<Integer>bag=new HashBag<Integer>();
		
		bag.add(1);
		bag.add(2);
		bag.add(3);
		bag.add(1);
		bag.add(1);
		
		System.out.println("集合中出现次数"+bag.getCount(1));
		System.out.println("转换Set去重----------");
		Set<Integer>iSet= bag.uniqueSet();
		for (Integer integer : iSet) {
			System.out.println(integer);
		}
	}
	@Test
	public void test2() {
		Bag<String>bag=new HashBag<String>();
		
		bag.add("a");
		bag.add("b");
		bag.add("c");
		bag.add("c");
		bag.add("c");
		
		
		System.out.println("集合中出现次数"+bag.getCount("c"));
		System.out.println("转换Set去重----------");
		Set<String>iSet= bag.uniqueSet();
		for (String str : iSet) {
			System.out.println(str);
		}
	}
}
