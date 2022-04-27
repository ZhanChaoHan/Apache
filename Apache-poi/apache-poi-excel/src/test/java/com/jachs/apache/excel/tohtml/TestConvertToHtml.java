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
		String filePath="C:\\Users\\79951\\Desktop\\sucai\\20210713182310.xlsx";
		String htmlPositon="C:\\Users\\79951\\Desktop\\aa.html";
		boolean isWithStyle=true;
		String type="xlsx";
		String htmlTitle="测试";
		
		ehUtil.readExcelToHtml(filePath, htmlPositon, isWithStyle, type, htmlTitle);
	}
	@Test
	public void test11() {
		String filePath="C:\\Users\\79951\\Desktop\\sucai\\aaa.xls";
		String htmlPositon="C:\\Users\\79951\\Desktop\\bb.html";
		boolean isWithStyle=true;
		String type="xls";
		String htmlTitle="测试";
		
		ehUtil.readExcelToHtml(filePath, htmlPositon, isWithStyle, type, htmlTitle);
	}
	
	
	@Test
	public void test2() throws IOException, ParserConfigurationException, TransformerException {
		PoiExcelToHtml.PoiExcelToHtml("C:\\Users\\79951\\Desktop\\sucai\\aaa.xls", "C:\\Users\\79951\\Desktop\\aaa.html");
	}
	//xlsx版本冲突
	@Test
	public void test22() throws IOException, ParserConfigurationException, TransformerException {
		PoiExcelToHtml.PoiExcelToHtml("C:\\Users\\79951\\Desktop\\sucai\\20210713182310.xlsx", "C:\\Users\\79951\\Desktop\\bbb.html");
	}
}
