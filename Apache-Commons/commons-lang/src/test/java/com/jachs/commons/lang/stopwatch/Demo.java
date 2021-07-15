package com.jachs.commons.lang.stopwatch;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class Demo {
    @Test
    public void test1() throws Exception {
        StopWatch sw=new StopWatch();
        sw.start ();//启动
        Thread.sleep(1000);
        sw.split ();//计算耗时
        System.out.println(sw.getSplitTime());  
        Thread.sleep(2000);  
        sw.split();//计算耗时
        System.out.println(sw.getSplitTime());  
        Thread.sleep(500);  
        sw.stop();//停止
        System.out.println(sw.getTime());  
    }
    @Test
    public void test2() throws InterruptedException {
        StopWatch watch = new StopWatch();  
        watch.start();  
        Thread.sleep(1000);  
        System.out.println(watch.getTime());  
        /* 复位 归零 */  
        watch.reset();  
        watch.start();  
        Thread.sleep(1000);  
        System.out.println(watch.getTime());  
    }
    @Test
    public void test3() throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        Thread.sleep(1000);
        System.out.println(watch.getTime());
        /* 挂起 */
        watch.suspend();
        System.out.println("do something");
        Thread.sleep(500);
        /* 恢复 */
        watch.resume();
        Thread.sleep(2000);
        System.out.println(watch.getTime());
    }
}
