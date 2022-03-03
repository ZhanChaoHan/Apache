package jachs.commons.concurrent.runnable;

/***
 * 
 * @author zhanchaohan
 *
 */
public class RunnableTest implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"\t滴滴答答");
	}

}
