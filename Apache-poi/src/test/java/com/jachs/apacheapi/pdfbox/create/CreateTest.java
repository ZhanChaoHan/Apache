package com.jachs.apacheapi.pdfbox.create;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
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
	@Test
	public void test2() throws IOException {
		PDPage page1 = new PDPage();//创建空白页
		document.addPage(page1);
		
		PDDocumentInformation pdd = document.getDocumentInformation();
	      //Setting the author of the document
	      pdd.setAuthor("IoWiki");
	      // Setting the title of the document
	      pdd.setTitle("Sample document"); 
	      //Setting the creator of the document 
	      pdd.setCreator("PDF Examples"); 
	      //Setting the subject of the document 
	      pdd.setSubject("Example document"); 
	      //Setting the created date of the document 
	      Calendar date = new GregorianCalendar();
	      date.set(2015, 11, 5); 
	      pdd.setCreationDate(date);
	      //Setting the modified date of the document 
	      date.set(2016, 6, 5); 
	      pdd.setModificationDate(date); 
	      //Setting keywords for the document 
	      pdd.setKeywords("sample, first example, my pdf"); 
	      //Saving the document 
	      document.save(testFilePath+File.separator+"test2.pdf");
	      System.out.println("Properties added successfully ");
	      //Closing the document
	}
	//先运行test2创建PDF,添加文本
	@Test
	public void test3() throws Exception {
		document = document.load(new File(testFilePath+File.separator+"test2.pdf"));
		PDPage page = document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
		
		PDFont formFont = PDType0Font.load(document,new FileInputStream("C:\\Windows\\Fonts\\mingliub.ttc"), false);
		
		contentStream.beginText();//开始写入文本
//		contentStream.setFont(formFont, 12);
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
		
		contentStream.newLineAtOffset(25, 500);//设置文本位置
		contentStream.showText("abc一二三");
		contentStream.endText();//结束写入文本
		
		contentStream.close();
		
		document.save(testFilePath+File.separator+"test3.pdf");
	}
	@Test
	public void test4() {
		
	}
}
