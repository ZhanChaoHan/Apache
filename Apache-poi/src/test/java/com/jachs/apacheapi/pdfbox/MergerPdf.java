package com.jachs.apacheapi.pdfbox;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Test;

import com.jachs.apache.ApacheApiApplication;

/***
 * 合并PDF
 * 
 * @author zhanchaohan
 *
 */
public class MergerPdf {
	private static final String filePath = MergerPdf.class.getResource("").getPath();
	
	//合并多个Pdf为一个Pdf
	@Test
	public void test() throws Exception {
		// Loading an existing PDF document
		File file1 = new File(filePath + File.separator + "1.pdf");
		PDDocument doc1 = PDDocument.load(file1);
		File file2 = new File(filePath + File.separator + "2.pdf");
		PDDocument doc2 = PDDocument.load(file2);
		File file3 = new File(filePath + File.separator + "3.pdf");
		PDDocument doc3 = PDDocument.load(file3);
		File file4 = new File(filePath + File.separator + "4.pdf");
		PDDocument doc4 = PDDocument.load(file4);
		File file5 = new File(filePath + File.separator + "5.pdf");
		PDDocument doc5 = PDDocument.load(file5);

		PDFMergerUtility PDFmerger = new PDFMergerUtility();
		// Setting the destination file
		PDFmerger.setDestinationFileName(filePath + File.separator + "merged.pdf");
		// adding the source files
		PDFmerger.addSource(file1);
		PDFmerger.addSource(file2);
		PDFmerger.addSource(file3);
		PDFmerger.addSource(file4);
		PDFmerger.addSource(file5);
		// Merging the two documents
		PDFmerger.mergeDocuments();
		System.out.println("Documents merged");
		// Closing the documents
		doc1.close();
		doc2.close();
		doc3.close();
		doc4.close();
		doc5.close();
	}
	
	//将pdf转换为图片
	@Test
	public void test1() throws Exception {
		// Loading an existing PDF document
		File file = new File(filePath + File.separator + "merged.pdf");
		PDDocument document = PDDocument.load(file);
		// Instantiating the PDFRenderer class
		PDFRenderer renderer = new PDFRenderer(document);
		// Rendering an image from the PDF document
		BufferedImage image1 = renderer.renderImage(0);
		// Writing the image to a file
		ImageIO.write(image1, "JPEG", new File(filePath + File.separator + "merged1.jpg"));
		
		BufferedImage image2 = renderer.renderImage(1);
		ImageIO.write(image2, "JPEG", new File(filePath + File.separator + "merged2.jpg"));
		
		BufferedImage image3 = renderer.renderImage(2);
		ImageIO.write(image3, "JPEG", new File(filePath + File.separator + "merged3.jpg"));
		
		BufferedImage image4 = renderer.renderImage(3);
		ImageIO.write(image4, "JPEG", new File(filePath + File.separator + "merged4.jpg"));
		
		BufferedImage image5 = renderer.renderImage(4);
		ImageIO.write(image5, "JPEG", new File(filePath + File.separator + "merged5.jpg"));
		
		System.out.println("Image created");
		// Closing the document
		document.close();
	}
}
