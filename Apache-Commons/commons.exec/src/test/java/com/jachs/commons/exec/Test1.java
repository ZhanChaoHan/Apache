package com.jachs.commons.exec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {
	/**
	 * 执行不需要返回结果的命令
	 * @throws IOException 
	 * @throws ExecuteException 
	 * @throws InterruptedException 
	 * 
	 * @throws Exception
	 */
	@Test
	public void execCmdWithoutResult() throws ExecuteException, IOException, InterruptedException {
		// 开启windows telnet: net start telnet
		// 注意：第一个空格之后的所有参数都为参数
		CommandLine cmdLine = new CommandLine("net");
		cmdLine.addArgument("start");
		cmdLine.addArgument("telnet");
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		// 设置60秒超时，执行超过60秒后会直接终止
		ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);
		executor.setWatchdog(watchdog);
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		executor.execute(cmdLine, handler);
		// 命令执行返回前一直阻塞
		handler.waitFor();
	}

	/**
	 * 带返回结果的命令执行
	 * 
	 * @return
	 */
	@Test
	public void execCmdWithResult() {
		try {
			String command = "ping 192.168.1.10";
			// 接收正常结果流
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			// 接收异常结果流
			ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
			CommandLine commandline = CommandLine.parse(command);
			DefaultExecutor exec = new DefaultExecutor();
			exec.setExitValues(null);
			// 设置一分钟超时
			ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);
			exec.setWatchdog(watchdog);
			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, errorStream);
			exec.setStreamHandler(streamHandler);
			exec.execute(commandline);
			// 不同操作系统注意编码，否则结果乱码
			String out = outputStream.toString("UTF-8");
			String error = errorStream.toString("UTF-8");
			
			System.out.println(out);
			System.out.println(error);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
