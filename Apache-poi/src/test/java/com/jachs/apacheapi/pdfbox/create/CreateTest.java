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
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 * @see https://pdfbox.apache.org/
 * @see https://iowiki.com/pdfbox/pdfbox_quick_guide.html
 */
public class CreateTest {
	private static final String testFilePath = CreateTest.class.getResource("").getPath();

	private PDDocument document;

	@Before
	public void init() {
		document = new PDDocument();// 创建空白的PDF
	}

	@After
	public void destroy() throws IOException {
		document.close();// 关闭
	}

	@Test
	public void test() throws Exception {
		// 写入
		document.save(testFilePath + File.separator + "test.pdf");
	}

	// 添加页面
	@Test
	public void test1() throws IOException {
		PDPage page1 = new PDPage();// 创建空白页

		document.addPage(page1);
		document.save(testFilePath + File.separator + "test1.pdf");
	}

	@Test
	public void test2() throws IOException {
		PDPage page1 = new PDPage();// 创建空白页
		document.addPage(page1);

		PDDocumentInformation pdd = document.getDocumentInformation();
		// Setting the author of the document
		pdd.setAuthor("IoWiki");
		// Setting the title of the document
		pdd.setTitle("Sample document");
		// Setting the creator of the document
		pdd.setCreator("PDF Examples");
		// Setting the subject of the document
		pdd.setSubject("Example document");
		// Setting the created date of the document
		Calendar date = new GregorianCalendar();
		date.set(2015, 11, 5);
		pdd.setCreationDate(date);
		// Setting the modified date of the document
		date.set(2016, 6, 5);
		pdd.setModificationDate(date);
		// Setting keywords for the document
		pdd.setKeywords("sample, first example, my pdf");
		// Saving the document
		document.save(testFilePath + File.separator + "test2.pdf");
		System.out.println("Properties added successfully ");
		// Closing the document
	}

	// 添加文本
	@Test
	public void test3() throws Exception {
		PDPage page = new PDPage(PDRectangle.A4);
		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		PDFont font = PDType0Font.load(document, new File("c:/windows/fonts/times.ttf"));
		contentStream.beginText();// 开始写入文本
		contentStream.setFont(font, 12);
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

		contentStream.newLineAtOffset(5, 5);// 设置文本位置
		contentStream.showText("AACCCCC");
		contentStream.endText();// 结束写入文本

		contentStream.close();

		document.save(testFilePath + File.separator + "test3.pdf");
	}

	// 添加多行文本
	@Test
	public void test4() throws Exception {
		// Loading an existing document
		File file = new File(testFilePath + File.separator + "test3.pdf");
		PDDocument doc = document.load(file);
		// Creating a PDF Document
		PDPage page = doc.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		// Begin the Content stream
		contentStream.beginText();
		// Setting the font to the Content stream
//	      contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );
		PDFont font = PDType0Font.load(document, new File("c:/windows/fonts/times.ttf"));
		contentStream.setFont(font, 16);

		// Setting the leading
		contentStream.setLeading(14.5f);
		// Setting the position for the line
		contentStream.newLineAtOffset(25, 725);
		String text1 = "This is an example of adding text to a page in the pdf document.we can add as many lines";
		String text2 = "as we want like this using the ShowText()  method of the  ContentStream class";
		// Adding text in the form of string
		contentStream.showText(text1);
		contentStream.newLine();
		contentStream.showText(text2);
		// Ending the content stream
		contentStream.endText();
		System.out.println("Content added");
		// Closing the content stream
		contentStream.close();
		// Saving the document
		doc.save(new File(testFilePath + File.separator + "test4.pdf"));
		// Closing the document
		doc.close();
	}
	//插入图片
	@Test
	public void test5() throws Exception {
		// Loading an existing document
		File file = new File(testFilePath + File.separator + "test4.pdf");
		
		PDDocument doc = PDDocument.load(file);
		PDPage page = doc.getPage(0);
		PDImageXObject pdImage = PDImageXObject.createFromFile(CreateTest.class.getResource("/image/01.jpg").getPath(), doc);
		// creating the PDPageContentStream object
		PDPageContentStream contents = new PDPageContentStream(doc, page);
		// Drawing the image in the PDF document
		contents.drawImage(pdImage, 70, 250);
		System.out.println("Image inserted");
		// Closing the PDPageContentStream object
		contents.close();
		// Saving the document
		doc.save(new File(testFilePath + File.separator + "test5.pdf"));
		// Closing the document
		doc.close();
	}
}
