package com.jachs.spirepdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

/***
 * 
 * @author zhanchaohan
 * @see https://www.e-iceblue.cn/pdf_java_conversion/convert-pdf-to-html-word-svg-and-xps-file-formats-in-java.html
 */
public class Demo {
	String padPath = "E:\\EclipseWorkSpace\\SpirePdf\\src\\test\\java\\com\\jachs\\spirepdf\\test.pdf";

	// PDF转Html
	@Test
	public void test1() {
		PdfDocument pdf = new PdfDocument();
		pdf.loadFromFile(padPath);
		pdf.saveToFile("ToHTML.html", FileFormat.HTML);
	}

	// PDF转SVG
	@Test
	public void test2() {
		PdfDocument pdf = new PdfDocument(padPath);
		pdf.saveToFile("ToSVG.svg", FileFormat.SVG);
	}

	// 多页pdf转为一个svg
	@Test
	public void test3() {
		PdfDocument pdf = new PdfDocument(padPath);
		pdf.getConvertOptions().setOutputToOneSvg(true);
		pdf.saveToFile("ToOneSvg.svg", FileFormat.SVG);
	}

	// PDF 转XPS
	@Test
	public void test4() {
		PdfDocument pdf = new PdfDocument(padPath);
		pdf.saveToFile("ToXPS.xps", FileFormat.XPS);
	}

	// PDF 转Word
	@Test
	public void test5() {
		PdfDocument pdf = new PdfDocument(padPath);
		pdf.saveToFile("ToWord.docx", FileFormat.DOCX);
	}

	// PDF转图片
	@Test
	public void test6() throws IOException {
		PdfDocument pdf = new PdfDocument("test.pdf");
		BufferedImage image;
		for (int i = 0; i < pdf.getPages().getCount(); i++) {
			image = pdf.saveAsImage(i);
			File file = new File(String.format("ToImage-img-%d.png", i));
			ImageIO.write(image, "PNG", file);
		}
		pdf.close();
	}
}
