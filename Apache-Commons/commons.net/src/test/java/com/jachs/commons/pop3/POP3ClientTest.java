package com.jachs.commons.pop3;


import java.io.BufferedReader;
import java.nio.charset.Charset;

import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

/***
 * 
 * @author zhanchaohan
 *
 */
public class POP3ClientTest {
	public static void main(String[] args) throws Exception {
		POP3Client pop3Client=new POP3Client();
		pop3Client.setDefaultPort(110);
		pop3Client.setDefaultTimeout(60000);
		pop3Client.setCharset(Charset.defaultCharset());
//		pop3Client.setTcpNoDelay(true);
//		pop3Client.setKeepAlive(true);
		
		pop3Client.connect("pop.163.com", 110);
		if(pop3Client.login("zhanchaohan22@163.com", "")) {
			POP3MessageInfo[] message=pop3Client.listMessages();
			for (POP3MessageInfo pop3MessageInfo : message) {
				BufferedReader reader =(BufferedReader) pop3Client.retrieveMessageTop(pop3MessageInfo.number, 0);
				
				while(reader.ready()) {
					System.out.println(reader.readLine());
				}
			}
			//
			POP3MessageInfo[] unMessage=pop3Client.listUniqueIdentifiers();
			for (POP3MessageInfo pop3MessageInfo : unMessage) {
				BufferedReader reader =(BufferedReader) pop3Client.retrieveMessageTop(pop3MessageInfo.number, 0);
				
				while(reader.ready()) {
					System.out.println(reader.readLine());
				}
			}
		}
		
	}
}
