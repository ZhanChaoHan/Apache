package com.jachs.apache.pdfbox.create;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class AddImage {
	private String projectPath = SimpleCreateTest.class.getResource("").getPath();

	@Test
	public void test1() throws Exception {
		File file = new File(projectPath + File.separator + "test2.pdf");
		PDDocument doc = PDDocument.load(file);
		
		PDPage page = doc.getPage(0);
		PDImageXObject pdImage = PDImageXObject.createFromFile(projectPath + File.separator + "test.png", doc);
		
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		//写入图片设置宽高
		contentStream.drawImage(pdImage, 50, 50);
		contentStream.close();
		doc.save(projectPath + File.separator + "test2.pdf");
		doc.close();
	}
}
