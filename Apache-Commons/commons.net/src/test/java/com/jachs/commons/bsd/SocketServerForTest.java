package com.jachs.commons.bsd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SocketServerForTest {
	
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(22);

		Socket socket = ss.accept();

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		while (br.ready()) {
			System.out.println(br.readLine());
		}
	}
}
