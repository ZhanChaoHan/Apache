package com.jachs.commons.collections4.queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;

import com.jachs.commons.vo.People;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CircularFifoQueueTest {

	@Test
	public void test1() {
		CircularFifoQueue<People> cfq=new CircularFifoQueue<People>();
		
		cfq.add(new People("amn", 0));
		cfq.add(new People("bmn", 1));
		cfq.add(new People("cmn", 2));
		cfq.add(new People("dmn", 3));
		cfq.add(new People("emn", 4));
		
		cfq.peek();
		
	}
}
