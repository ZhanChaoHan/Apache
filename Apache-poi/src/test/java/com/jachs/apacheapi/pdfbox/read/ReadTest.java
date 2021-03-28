package com.jachs.apacheapi.pdfbox.read;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.junit.Test;

import com.jachs.apacheapi.pdfbox.create.CreateTest;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ReadTest {
	private static final String testFilePath=CreateTest.class.getResource("").getPath();
	
	//參考CreateTest.test2
	@Test
	public void test() throws Exception {
		 //Loading an existing document 
	      File file = new File(testFilePath+File.separator+"test2.pdf");
	      PDDocument document = PDDocument.load(file);
	      //Getting the PDDocumentInformation object
	      PDDocumentInformation pdd = document.getDocumentInformation();
	      //Retrieving the info of a PDF document
	      System.out.println("Author of the document is :"+ pdd.getAuthor());
	      System.out.println("Title of the document is :"+ pdd.getTitle());
	      System.out.println("Subject of the document is :"+ pdd.getSubject());
	      System.out.println("Creator of the document is :"+ pdd.getCreator());
	      System.out.println("Creation date of the document is :"+ pdd.getCreationDate());
	      System.out.println("Modification date of the document is :"+ 
	         pdd.getModificationDate()); 
	      System.out.println("Keywords of the document are :"+ pdd.getKeywords()); 
	      //Closing the document 
	      document.close();        
	}
}
