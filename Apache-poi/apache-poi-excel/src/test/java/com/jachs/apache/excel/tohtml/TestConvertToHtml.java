package com.jachs.apache.excel.tohtml;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class TestConvertToHtml {
	Excel2HtmlUtil ehUtil=new Excel2HtmlUtil();
	
	@Test
	public void test1() {
		String filePath="C:\\Users\\79951\\Desktop\\A.xls";
		String htmlPositon="C:\\Users\\79951\\Desktop\\bb.html";
		boolean isWithStyle=true;
		String type="xls";
		String htmlTitle="测试";
		
		ehUtil.readExcelToHtml(filePath, htmlPositon, isWithStyle, type, htmlTitle);
		
	}
}
