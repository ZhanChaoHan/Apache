package com.jachs.jdk.lang.thread.runnable.part3;

import java.util.Random;

import com.jachs.jdk.lang.thread.runnable.part3.job.BiddingJob;
import com.jachs.jdk.lang.thread.runnable.part3.job.SimpleCountJob;

/***
 * 测试线程同步
 * 
 * @author zhanchaohan 模拟竞价,规则如下:</br>
 *         1:同一个人不能再最高价基础上再次加价,最高价不能等于再次竞价</br>
 *         2：最高价为maxMonery不能超过</br>
 */
public class Part3Man {
	private static Long countMonery = 0L;
	private static String lastCustomer = null;
	private static Long maxMonery = 20000L;
	private static Random random = new Random();

	private static int intCount = 0;

	public void Count() {
		synchronized (this) {
			++intCount;
			System.out.println(Thread.currentThread().getName() + "\t" + intCount);
		}
	}

	public void Bidding() {
		synchronized (this) {
			String thName = Thread.currentThread().getName();// 线程名称
			if (thName.equals(lastCustomer)) {// 本次竞价和最高竞价同一个人跳过
				return;
			} else {
				lastCustomer = thName;
			}
			int randomC = random.nextInt(1000);
			if (randomC == 0) {
				return;
			}
			if ((countMonery + randomC) >= maxMonery) {
				System.exit(0);
			} else {
				countMonery = countMonery + randomC;
				System.out.println(lastCustomer + "最新价:" + countMonery);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
//		new Thread(new BiddingJob()).start();
//		new Thread(new BiddingJob()).start();
//		new Thread(new BiddingJob()).start();
//		new Thread(new BiddingJob()).start();
//		new Thread(new BiddingJob()).start();
		
		new Thread(new SimpleCountJob()).start();
		new Thread(new SimpleCountJob()).start();
		new Thread(new SimpleCountJob()).start();
		new Thread(new SimpleCountJob()).start();
		new Thread(new SimpleCountJob()).start();
		
		Thread.sleep(5000);
	}
}
