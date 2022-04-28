package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/***
 * 重新订购幻灯片
 * @author zhanchaohan
 *
 */
public class Test5 {
	private static String pptPath="D:\\ppt4.pptx";
	private static String targetPath="D:\\ppt5.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		List<XSLFSlide> slides = ppt.getSlides();
		XSLFSlide thirdSlide = slides.get(2);
		ppt.setSlideOrder(thirdSlide, 0); // move the third slide to the beginning
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
