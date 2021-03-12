package com.jachs.jdk.lang.thread.runnable.part3.job;

import com.jachs.jdk.lang.thread.runnable.part3.Part3Man;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SimpleCountJob implements Runnable{

	public void run() {
		Part3Man p3 = new Part3Man();
		p3.Count();
	}

}
