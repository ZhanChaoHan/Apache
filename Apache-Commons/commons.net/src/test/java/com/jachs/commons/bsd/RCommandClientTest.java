package com.jachs.commons.bsd;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.nio.charset.Charset;

import org.apache.commons.net.bsd.RCommandClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * rcmd命令
 * 
 * @author zhanchaohan
 */
public class RCommandClientTest {
	RCommandClient rCommandClient = new RCommandClient();

	// 开始连接
	@Before
	public void connection() throws SocketException, IOException {
//		rCommandClient.connect("");
		rCommandClient.connect("zhanchaohan", 22);

		rCommandClient.setCharset(Charset.defaultCharset());// 设置编码
		rCommandClient.setConnectTimeout(5000);// 设置超时时间
		rCommandClient.setKeepAlive(true);
	}

	// 断开连接
	@After
	public void disConnection() throws IOException {
		rCommandClient.disconnect();
	}

	/***
	 * 模拟socket连接
	 * 
	 * @throws IOException
	 * @see SocketServerForTest
	 */
	@Test
	public void testc() throws IOException {
		rCommandClient.getCharset();
		System.out.println(rCommandClient.getCharsetName());
		BufferedOutputStream bos = new BufferedOutputStream(rCommandClient.getOutputStream());
		bos.write("一段话".getBytes());
		bos.write("二段话".getBytes());
		bos.close();
	}

	@Test
	public void test2() throws IOException {
		String localUsername="Jachs";
		String remoteUsername="799516423@qq.com";
		String command="shutdown -s -t 3600";
		// 本地用户，远程用户,命令
		rCommandClient.rcommand(localUsername, remoteUsername, command);
	}
	@Test
	public void test3() throws IOException {
		String localUsername="Jachs";
		String remoteUsername="799516423@qq.com";
		String command="shutdown -s -t 3600";
		
		rCommandClient.rexec(localUsername, remoteUsername, command);
	}
	@Test
	public void test5() {
		
	}
}
