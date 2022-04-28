package com.jachs.apache_poi_ppt.xslf;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFHyperlink;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

/***
 * 如何创建超链接
 * @author zhanchaohan
 *
 */
public class Test11 {
	private static String pptPath="D:\\ppt8.pptx";
	private static String targetPath="D:\\ppt9.pptx";
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		XSLFSlide slide = ppt.createSlide();
		// assign a hyperlink to a text run
		XSLFTextBox shape = slide.createTextBox();
		XSLFTextRun r = shape.addNewTextParagraph().addNewTextRun();
		r.setText("Apache POI");
		XSLFHyperlink link = r.createHyperlink();
		link.setAddress("https://poi.apache.org");
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
