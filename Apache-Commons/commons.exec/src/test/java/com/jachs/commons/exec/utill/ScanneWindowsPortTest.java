package com.jachs.commons.exec.utill;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.junit.Test;

import com.jachs.commons.exec.CommandUtils;
import com.jachs.commons.exec.entity.PortStatus;

/***
 * 获取windows全部端口状态
 * @author zhanchaohan</br>
协议：分为TCP和UDP</br>
    本地地址（Local Address）：代表本机IP地址和打开的端口号</br>
    外部地址（Foreign Address）：远程计算机IP地址和端口号</br>
    状态（State）：表明当前的连接状态</br>
    PID：对应进程 的PID。在任务管理器 的进程中可以根据对应的PID可以找到对应的进程</br>
其中状态的几个含义：</br>
    LISTENING时表示处于侦听状态，就是说该端口是开放的，等待连接，但还没有被连接。就像你房子的门已经敞开的，但还没有人进来。</br>
    ESTABLISHED的意思是建立连接。表示两台机器正在通信。</br>
    CLOSE_WAIT 对方主动关闭连接或者网络 异常导致连接中断</br>
    TIME_WAIT 我方主动调用close()断开连接，收到对方确认后状态变为TIME_WAIT</br>
 */
public class ScanneWindowsPortTest {
	CommandUtils cu=new CommandUtils();
	
	public List<PortStatus> getPsList() throws IOException {
		List<PortStatus>psList=new ArrayList<PortStatus>();
		String str=cu.exeCommand("netstat -ano");
		
		System.out.println("-------------------原始字符串---------------------------");
		System.out.println(str);
		List<String>strList=Arrays.asList(str.split("\n"));
		
		for (int kk = 4; kk < strList.size(); kk++) {
			String lineStr=strList.get(kk);
			String[] lineList= lineStr.split("/s+");
			
			PortStatus ps=new PortStatus();
			
			ps.setType(lineList[1]);
			ps.setLocal(lineList[2]);
			ps.setRemote(lineList[3]);
			ps.setStatus(lineList[4]);
			if(lineList.length>5&&lineList[5]!=null) {
				ps.setPid(Long.parseLong(lineList[5].trim()));
			}
			psList.add(ps);
		}
		return psList;
	}
	@Test
	public void test1() throws IOException {
		List<PortStatus>myList= getPsList();
//		System.out.println("-----------------------------------对象输出------------------------");
//		for (PortStatus psObj : myList) {
//			System.out.println(psObj.getType()+"\t"+psObj.getLocal()+"\t"+psObj.getRemote()+"\t"+psObj.getStatus()+"\t"+psObj.getPid());
//		}
	}
	//根据PID查询端口
	@Test
	public void test2() throws IOException {
		String str=cu.exeCommand("netstat -ano | findstr 3500");
		
		System.out.println(str);
	}
	//查询PID详情
	@Test
	public void test3() throws IOException {
		String str=cu.exeCommand("tasklist | findstr 3500");
		
		System.out.println(str);
	}
	//获取局域网IP段
	@Test
	public void test5 () throws IOException{
		String str=cu.exeCommand("arp -a");
		
		System.out.println(str);
	}
}
