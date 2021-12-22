package com.jachs.commons.exec;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *@see https://commons.apache.org/proper/commons-exec/tutorial.html
 *@see 
 */
public class Example {
	File file=new File("");
	
	/***
让我们看一个真实的例子——我们希望从Java应用程序中打印PDF文档。在谷歌搜索了一段时间后，结果发现这是一个小问题，使用AdobeAcrobat似乎是一个不错的选择。
假设在路径中找到Acrobat Reader，Windows下的命令行应类似于“AcroRd32.exe/p/h文件”。 
	 * @throws ExecuteException
	 * @throws IOException
	 */
	@Test
	public void test1() throws ExecuteException, IOException {
		String line = "AcroRd32.exe /p /h " + file.getAbsolutePath();
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		int exitValue = executor.execute(cmdLine);

	}
	/***
	 * 您成功打印了第一个PDF文档，但最后引发了异常-发生了什么？很抱歉，Acrobat Reader在成功时返回了退出值“1”，
	 * 这通常被视为执行失败。因此，我们必须调整代码来修复这种奇怪的行为——我们定义“1”的退出值被视为成功执行。
	 * @throws ExecuteException
	 * @throws IOException
	 */
	@Test
	public void test2() throws ExecuteException, IOException {
		String line = "AcroRd32.exe /p /h " + file.getAbsolutePath();
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		int exitValue = executor.execute(cmdLine);
	}
	@Test
	public void test3() throws ExecuteException, IOException {
		String line = "AcroRd32.exe /p /h " + file.getAbsolutePath();
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
		executor.setWatchdog(watchdog);
		int exitValue = executor.execute(cmdLine);

	}
	@Test
	public void test4() throws ExecuteException, IOException {
		String line = "AcroRd32.exe /p /h \"" + file.getAbsolutePath() + "\"";
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
		executor.setWatchdog(watchdog);
		int exitValue = executor.execute(cmdLine);
	}
	@Test
	public void test5() throws ExecuteException, IOException {
		Map<String,File> map =new HashMap<String, File>();
		map.put("file", new File("invoice.pdf"));
		CommandLine cmdLine = new CommandLine("AcroRd32.exe");
		cmdLine.addArgument("/p");
		cmdLine.addArgument("/h");
		cmdLine.addArgument("${file}");
		cmdLine.setSubstitutionMap(map);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
		executor.setWatchdog(watchdog);
		int exitValue = executor.execute(cmdLine);

	}
	/*
	@Test
	public void test6() throws ExecuteException, IOException {
		CommandLine cmdLine = new CommandLine("AcroRd32.exe");
		cmdLine.addArgument("/p");
		cmdLine.addArgument("/h");
		cmdLine.addArgument("${file}");
		HashMap map = new HashMap();
		map.put("file", new File("invoice.pdf"));
		commandLine.setSubstitutionMap(map);

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

		ExecuteWatchdog watchdog = new ExecuteWatchdog(60*1000);
		Executor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.setWatchdog(watchdog);
		executor.execute(cmdLine, resultHandler);

		// some time later the result handler callback was invoked so we
		// can safely request the exit value
		int exitValue = resultHandler.waitFor();
	}
	*/
}
