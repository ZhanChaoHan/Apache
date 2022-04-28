package com.jachs.apache_poi_ppt.xslf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/***
 * 创建一个新的演示文稿
 * @author zhanchaohan
 *
 */
public class Test1 {
	private static String pptPath="D:\\ppt1.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//create a new empty slide show
		XMLSlideShow ppt = new XMLSlideShow();
		//add first slide
		XSLFSlide blankSlide = ppt.createSlide();
		
		ppt.write(new FileOutputStream(pptPath));
	}
}
