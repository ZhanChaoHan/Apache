package com.jachs.apache.pdfbox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

/**
 * 
 * @author zhanchaohan
 *
 */
public class PdfToWord {
	/**
	 * 转换
	 */
	public void convertText(String pdfPath) {
		PDDocument doc = null;
		OutputStream fos = null;
		Writer writer = null;
		PDFTextStripper stripper = null;
		try {
			doc = PDDocument.load(new File(pdfPath));
			fos = new FileOutputStream(pdfPath.substring(0, pdfPath.indexOf(".")) + ".doc");
			writer = new OutputStreamWriter(fos, "UTF-8");
			stripper = new PDFTextStripper();
			int pageNumber = doc.getNumberOfPages();
			stripper.setSortByPosition(true);
			stripper.setStartPage(1);
			stripper.setEndPage(pageNumber);
			stripper.writeText(doc, writer);
			writer.close();
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end..");
	}

	@Test
	public void test1() {
		PdfToWord convert = new PdfToWord();
		convert.convertText("G:\\A\\vocabulary.pdf");
	}
}
