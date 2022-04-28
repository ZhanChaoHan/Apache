package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/***
 * 阅读现有的演示文稿
 * @author zhanchaohan
 *
 */
public class Test2 {
	private static String pptPath="D:\\ppt1.pptx";
	private static String targetPath="D:\\ppt2.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		//append a new slide to the end
		XSLFSlide blankSlide = ppt.createSlide();
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
