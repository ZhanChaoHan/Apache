package com.jachs.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

/***
 * Commons-collections使用一种类似于标准Java集合的设计方法进行同步。没有附加同步，集合，地图和包的各种实现中的大多数都不是线程安全的。集合上适当的syncnizeXXX方法是可以同步这些实现以用于多线程应用程序的一种方式。
    类级别的javadocs应该指示在没有附加同步的情况下，特定实现对于多线程访问是否安全。如果没有明确表明该实现是线程安全的，则应假定需要同步。请向公共资源开发团队报告缺少的文档。
 * @author zhanchaohan
 * @see https://commons.apache.org/proper/commons-collections/javadocs/api-4.4/index.html
 */
public class BagTest {
    
    /***
     * jdkmap接口总是难以迭代。API用户被迫迭代EntrySet或KeySet。Commons集合现在提供了一个新的接口-MapIterator，它允许在映射上进行简单的迭代。
     */
	@Test
	public void MapIteration() {
	    IterableMap map = new HashedMap();
	    
	    map.put ( "key1", "value1" );
	    map.put ( "key2", "value2" );
	    map.put ( "key3", "value3" );
	    map.put ( "key4", "value4" );
	    map.put ( "key5", "value5" );
	    MapIterator it = map.mapIterator();
	    while (it.hasNext()) {
	      Object key = it.next();
	      Object value = it.getValue();
	      
	      if(key.equals ( "key4" )) {
	          it.setValue("新的值");
	      }
	      System.out.println ( key+"\t\t"+value );
	    }
	    System.out.println ( map.get ( "key4" ));
	}
	/***
	 * 为具有顺序但未排序的映射提供了一个新接口-OrderedMap。提供了两个实现—LinkedMap和ListOrderedMap（一个装饰器）。此接口支持map迭代器，还允许在映射中向前和向后迭代。
	 */
	@Test
	public void OrderedMaps() {
	    OrderedMap map = new LinkedMap();
	    map.put("FIVE", "5");
	    map.put("SIX", "6");
	    map.put("SEVEN", "7");
	    System.out.println (  map.firstKey() );  // returns "FIVE"
	    System.out.println ( map.nextKey("FIVE") );  // returns "SIX"
	    System.out.println ( map.nextKey("SIX") );  // returns "SEVEN"
	    System.out.println ( map.lastKey () );
	}
	/**
	 * 添加了一个新的接口层次结构来支持双向映射-BidiMap。这些表示映射，其中键可以查找值，而值可以同样轻松地查找键。
	 */
	@Test
	public void BidirectionalMaps() {
	    BidiMap bidi = new TreeBidiMap();
	    bidi.put("SIX", "6");
	    bidi.get("SIX");  // returns "6"
	    bidi.getKey("6");  // returns "SIX"
	    bidi.removeValue("6");  // removes the mapping
	    BidiMap inverse = bidi.inverseBidiMap();  // returns a map with keys and values swapped
	    
	}
	/***
	 * 添加了一个新的接口层次结构来支持bags-Bag。这些表示每个元素的一定数量副本的集合。
	 */
	@Test
	public void Bags() {
	    Bag bag = new HashBag();
	    bag.add("ONE", 6);  // add 6 copies of "ONE"
	    bag.remove("ONE", 2);  // removes 2 copies of "ONE"
	    bag.getCount("ONE");  // returns 4, the number of copies in the bag (6 - 2)
	}
}
