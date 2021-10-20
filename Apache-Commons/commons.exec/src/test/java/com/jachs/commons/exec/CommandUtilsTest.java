package com.jachs.commons.exec;

import java.io.IOException;

import org.junit.Test;

/****
 * 
 * @author zhanchaohan
 *
 */
public class CommandUtilsTest {
	CommandUtils cu=new CommandUtils();
	
	@Test
	public void test1() throws IOException {
		String str=cu.exeCommand("ping 127.0.0.1");
		System.out.println(str);
	}
	@Test
	public void test2() throws IOException {
		String str=cu.exeCommand("notepad");
		System.out.println(str);
	}
}
