package com.jachs.registry;

import org.junit.Test;

import com.jachs.commons.exec.CommandUtils;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ExecTest {
	CommandUtils cu=new CommandUtils();
	
	//执行cmd命令查询注册表
	@Test
	public void test1() throws Exception{
		String str=cu.exeCommand("reg query HKEY_CURRENT_USER\\Software\\Microsoft\\Notepad ");
		System.out.println(str);
	}
	
}
