package com.jachs.apacheapi.pdfbox.create;


import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *@see https://pdfbox.apache.org/
 *@see https://iowiki.com/pdfbox/pdfbox_quick_guide.html
 */
public class CreateTest {
	private static final String testFilePath=CreateTest.class.getResource("").getPath();
	
	private PDDocument document;
	@Before
	public void init() {
		document = new PDDocument();//创建空白的PDF
	}
	@After
	public void destroy() throws IOException {
		document.close();//关闭
	}
	
	@Test
	public void test() throws Exception {
		//写入
		document.save(testFilePath+File.separator+"test.pdf");
	}
	//添加页面
	@Test
	public void test1() throws IOException {
		PDPage page1 = new PDPage();//创建空白页
		
		document.addPage(page1);
		document.save(testFilePath+File.separator+"test1.pdf");
	}
}
