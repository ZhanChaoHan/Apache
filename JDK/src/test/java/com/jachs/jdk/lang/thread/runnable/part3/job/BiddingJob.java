package com.jachs.jdk.lang.thread.runnable.part3.job;

import com.jachs.jdk.lang.thread.runnable.part3.Part3Man;

public class BiddingJob implements Runnable {

	public void run() {
		Part3Man p3 = new Part3Man();
		while (true) {
			p3.Bidding();
			try {
				Thread.sleep(1000);// 休眠方便控制台打印
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
