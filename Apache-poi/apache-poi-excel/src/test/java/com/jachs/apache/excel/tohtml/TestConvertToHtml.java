package com.jachs.apache.excel.tohtml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;

/***
 * 转换全部sheet
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
	
	@Test
	public void test2() throws IOException, ParserConfigurationException, TransformerException {
		PoiExcelToHtml.PoiExcelToHtml("C:\\Users\\79951\\Desktop\\aaa.xls", "C:\\Users\\79951\\Desktop\\aaa.html");
	}
}
