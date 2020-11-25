package jachs.commons.stopwatch;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author zhanchaohan
 * 
 */
public class SpringStopWatch {
    @Test
    public void test() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start("起床");
        Thread.sleep(1000);
        sw.stop();

        sw.start("洗漱");
        Thread.sleep(2000);
        sw.stop();

        sw.start("锁门");
        Thread.sleep(500);
        sw.stop();

        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());//全部执行耗时
        System.out.println(sw.getLastTaskName());//最后任务名称
        System.out.println(sw.getLastTaskInfo());//最后任务信息
        System.out.println(sw.getTaskCount());//全部任务数
    }
}
