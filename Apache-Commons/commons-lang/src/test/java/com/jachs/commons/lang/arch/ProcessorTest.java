package com.jachs.commons.lang.arch;

import org.apache.commons.lang3.arch.Processor;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ProcessorTest {

	@Test
	public void test1() throws Exception{
		Processor proce=new Processor(Processor.Arch.BIT_32, Processor.Type.PPC);
		
		System.out.println(proce.getArch().name());
		
		System.out.println(proce.is32Bit());
		System.out.println(proce.is64Bit());
		System.out.println(proce.isIA64());
		System.out.println(proce.isPPC());
		System.out.println(proce.isX86());
	}
}
