package jachs.commons.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import jachs.commons.concurrent.runnable.RunnableTest;

/****
 * 
 * @author zhanchaohan
 *
 */
public class BasicThreadFactoryTest {
	@Test
	public void test1() {
		 BasicThreadFactory factory = new BasicThreadFactory.Builder()
				     .namingPattern("&quot;workerthread-%d&quot;")//线程名称
				     .daemon(false)//设置为true，为守护线程
				     .priority(Thread.MAX_PRIORITY)//线程优先级别
				     .build();
		 
//		 factory.newThread(new RunnableTest());
		 
		 ScheduledExecutorService exec=Executors
         .newScheduledThreadPool( 1, factory );
		 
		 exec.submit(new RunnableTest());
		 exec.shutdown();
	}
}
