package com.jachs.apacheapi.pdfbox;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import com.jachs.apache.ApacheApiApplication;

/***
 * 切分pdf,一个页码切分为一个PDF
 * @author zhanchaohan
 *
 */
public class SpliPdf {
	@Test
	public void test() throws Exception {
		// Loading an existing PDF document
		File file = new File(ApacheApiApplication.class.getResource("/pdf/vocabulary.pdf").getPath());
		PDDocument document = PDDocument.load(file);
		// Instantiating Splitter class
		Splitter splitter = new Splitter();
		// splitting the pages of a PDF document
		List<PDDocument> Pages = splitter.split(document);
		// Creating an iterator
		Iterator<PDDocument> iterator = Pages.listIterator();
		// Saving each page as an individual document
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			pd.save(SpliPdf.class.getResource("").getPath()+File.separator+ i++ + ".pdf");
		}
		System.out.println("Multiple PDF’s created");
		document.close();
	}
}
