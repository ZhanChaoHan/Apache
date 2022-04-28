package com.jachs.apache_poi_ppt.xslf;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

/***
 * 基本文本格式
 * @author zhanchaohan
 *
 */
public class Test10 {
	private static String pptPath="D:\\ppt7.pptx";
	private static String targetPath="D:\\ppt8.pptx";
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		XSLFSlide slide = ppt.createSlide();
		XSLFTextBox shape = slide.createTextBox();
		XSLFTextParagraph p = shape.addNewTextParagraph();
		XSLFTextRun r1 = p.addNewTextRun();
		r1.setText("The");
		r1.setFontColor(Color.blue);
		r1.setFontSize(24.);
		XSLFTextRun r2 = p.addNewTextRun();
		r2.setText(" quick");
		r2.setFontColor(Color.red);
		r2.setBold(true);
		XSLFTextRun r3 = p.addNewTextRun();
		r3.setText(" brown");
		r3.setFontSize(12.);
		r3.setItalic(true);
		r3.setStrikethrough(true);
		XSLFTextRun r4 = p.addNewTextRun();
		r4.setText(" fox");
		r4.setUnderlined(true);
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
