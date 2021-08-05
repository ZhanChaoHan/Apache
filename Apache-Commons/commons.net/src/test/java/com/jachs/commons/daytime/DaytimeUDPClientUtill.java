package com.jachs.commons.daytime;

import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.Charset;

import org.apache.commons.net.daytime.DaytimeTCPClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author zhanchaohan
 *
 */
public class DaytimeUDPClientUtill {
	DaytimeTCPClient dtcpClient = new DaytimeTCPClient();

	// 开始连接
	@Before
	public void connection() throws SocketException, IOException {
//			rCommandClient.connect("");
		dtcpClient.connect("zhanchaohan", 22);

		dtcpClient.setCharset(Charset.defaultCharset());// 设置编码
		dtcpClient.setConnectTimeout(5000);// 设置超时时间
		dtcpClient.setKeepAlive(true);
	}

	// 断开连接
	@After
	public void disConnection() throws IOException {
		dtcpClient.disconnect();
	}

	@Test
	public void test1() throws IOException {
		System.out.println(dtcpClient.getTime());
	}
}
