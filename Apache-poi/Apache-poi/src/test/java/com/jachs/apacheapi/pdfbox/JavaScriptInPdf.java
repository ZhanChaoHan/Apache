package com.jachs.apacheapi.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.junit.Test;

import com.jachs.apacheapi.pdfbox.create.CreateTest;

/***
 * 添加javascript脚本到pdf
 * @author zhanchaohan
 *
 */
public class JavaScriptInPdf {
	private static final String testFilePath = CreateTest.class.getResource("").getPath();
	
	@Test
	public void test() throws IOException {
		PDDocument document = PDDocument.load(new File(testFilePath + File.separator + "test4.pdf"));
		
		String javaScript ="app.alert( {cMsg: 'this is an example', nIcon: 3,"
		         + " nType: 0, cTitle: 'PDFBox Javascript example’} );";
		// Creating PDActionJavaScript object
		PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);
		// Embedding java script
		document.getDocumentCatalog().setOpenAction(PDAjavascript);
		// Saving the document
		document.save(new File(JavaScriptInPdf.class.getResource("").getPath()+File.separator+"javascriptInPdf.pdf"));
		System.out.println("Data added to the given PDF");
		// Closing the document
		document.close();
	}
}
