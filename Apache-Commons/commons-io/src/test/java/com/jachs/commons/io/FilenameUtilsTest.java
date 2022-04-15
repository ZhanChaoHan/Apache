package com.jachs.commons.io;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class FilenameUtilsTest {

	/***
	 * 使用常规命令行样式规则将文件名连接到基本路径。
	 */
	@Test
	public void concatTest() {
		System.out.println(FilenameUtils.concat("/foo/", "bar"));
		System.out.println(FilenameUtils.concat("/foo", "bar"));
		System.out.println(FilenameUtils.concat("/foo", "/bar"));
		System.out.println(FilenameUtils.concat("/foo", "C:/bar"));
		System.out.println(FilenameUtils.concat("/foo", "C:bar"));
		System.out.println(FilenameUtils.concat("/foo/a/", "../bar"));
		System.out.println(FilenameUtils.concat("/foo/", "../../bar"));
		System.out.println(FilenameUtils.concat("/foo/", "/bar"));
		System.out.println(FilenameUtils.concat("/foo/..", "/bar"));
		System.out.println(FilenameUtils.concat("/foo", "bar/c.txt"));
		System.out.println(FilenameUtils.concat("/foo/c.txt", "bar"));
	}

	// 文件夹下是否包含文件
	@Test
	public void directoryContainsTest() {
		String canonicalParent = "E:\\dev";
		String canonicalChild = "aa.txt";

		System.out.println(FilenameUtils.directoryContains(canonicalParent, canonicalChild));
	}

	// 将所有分隔符转换为正斜杠的Unix分隔符
	@Test
	public void separatorsToUnixTest() {
		System.out.println(FilenameUtils.separatorsToUnix("e:\\a\\c"));
	}

	// 将所有分隔符转换为反斜杠的Windows分隔符
	@Test
	public void separatorsToWindowsTest() {
		System.out.println(FilenameUtils.separatorsToWindows("e:\\a\\c"));
	}

	// 将所有分隔符转换为系统分隔符
	@Test
	public void separatorsToSystemTest() {
		System.out.println(FilenameUtils.separatorsToSystem("e:\\a\\c"));
	}

	/***
	 * 不管代码在哪台机器上运行，输出都是相同的。 不管怎样，Unix和Windows的前缀都是匹配的。
	 * 请注意，前导//（或\\）用于指示Windows上的UNC名称。 它们后面必须跟一个服务器名，这样就不会折叠双斜杠 在文件名的开头添加一个斜杠。
	 */
	@Test
	public void getPrefixLength() {
		System.out.println(FilenameUtils.getPrefixLength("e:\\a\\c"));
	}
	//获取文件后缀
	@Test
	public void getExtension() {
		System.out.println(FilenameUtils.getExtension("anc.html"));
		System.out.println(FilenameUtils.getExtension("anc.pdf"));
		System.out.println(FilenameUtils.getExtension("anc.xml"));
		System.out.println(FilenameUtils.getExtension("anc.c"));
	}
}
