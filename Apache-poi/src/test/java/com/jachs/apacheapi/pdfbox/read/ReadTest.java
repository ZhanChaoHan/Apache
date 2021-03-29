package com.jachs.apacheapi.pdfbox.read;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import com.jachs.apacheapi.pdfbox.create.CreateTest;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ReadTest {
	private static final String testFilePath = CreateTest.class.getResource("").getPath();

	// 參考CreateTest.test2，读取pdf文件信息
	@Test
	public void test() throws Exception {
		// Loading an existing document
		File file = new File(testFilePath + File.separator + "test2.pdf");
		PDDocument document = PDDocument.load(file);
		// Getting the PDDocumentInformation object
		PDDocumentInformation pdd = document.getDocumentInformation();
		// Retrieving the info of a PDF document
		System.out.println("Author of the document is :" + pdd.getAuthor());
		System.out.println("Title of the document is :" + pdd.getTitle());
		System.out.println("Subject of the document is :" + pdd.getSubject());
		System.out.println("Creator of the document is :" + pdd.getCreator());
		System.out.println("Creation date of the document is :" + pdd.getCreationDate());
		System.out.println("Modification date of the document is :" + pdd.getModificationDate());
		System.out.println("Keywords of the document are :" + pdd.getKeywords());
		// Closing the document
		document.close();
	}
	// 參考CreateTest.test4，读取pdf文字信息
	@Test
	public void test1() throws IOException {
		// Loading an existing document
		File file =new File(testFilePath+File.separator+"test4.pdf");
		PDDocument document = PDDocument.load(file);
		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		// Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		System.out.println(text);
		// Closing the document
		document.close();
	}
}
