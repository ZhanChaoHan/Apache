package com.jachs.commons.lang.archutils;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.arch.Processor;
import org.junit.Test;

/****
 * os.arch系统属性的实用程序类。类定义了用于标识当前JVM体系结构的方法。
	重要提示：os.arch系统属性返回由JVM使用的体系结构，而不是操作系统的体系结构。
	没啥用的类
 * @author zhanchaohan
 *
 */
public class Demo {
	@Test
	public void ArchUtilsDemo() {
		ArchUtils archUtils=new ArchUtils();
		Processor processor=archUtils.getProcessor();//当前JVM的处理器对象。
		
		System.out.println(processor.is32Bit());//32位
		System.out.println(processor.is64Bit());//64位
		System.out.println(processor.isIA64());
		System.out.println(processor.isPPC());
		System.out.println(processor.isX86());
	}
}
