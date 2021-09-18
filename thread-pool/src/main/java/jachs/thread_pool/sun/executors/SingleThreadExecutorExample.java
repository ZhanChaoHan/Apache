package jachs.thread_pool.sun.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/***
 * 不建议直接Executors创建线程,默认当达到最大连接数或延迟数量最大容易出现内存泄露
 * @author zhanchaohan
 * @see 
 */
public class SingleThreadExecutorExample {
	//返回用于创建新线程的默认线程工厂。
	private ThreadFactory defaultTF=Executors.defaultThreadFactory() ;
	
	
	//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
	private ExecutorService executors=Executors.newSingleThreadExecutor();
	// 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程，并在需要时使用提供的 ThreadFactory 创建新线程。
	private ExecutorService executorsF=Executors.newSingleThreadExecutor(new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			return null;
		}
	});
	
}
