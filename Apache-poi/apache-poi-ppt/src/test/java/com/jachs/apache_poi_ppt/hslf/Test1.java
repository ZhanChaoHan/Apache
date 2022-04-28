package com.jachs.apache_poi_ppt.hslf;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

/***
 * 如何创建新演示文稿并向其中添加新幻灯片
 * @author zhanchaohan
 * @see https://poi.apache.org/components/slideshow/how-to-shapes.html#NewPresentation
 */
public class Test1 {
	private static String pptPath="D:\\ppt1.ppt";
	
	public static void main(String[] args) throws IOException {
		//create a new empty slide show
		HSLFSlideShow ppt = new HSLFSlideShow();
		//add first slide
		HSLFSlide s1 = ppt.createSlide();
		//add second slide
		HSLFSlide s2 = ppt.createSlide();
		//save changes in a file
		FileOutputStream out = new FileOutputStream(pptPath);
		ppt.write(out);
		out.close();
	}
}
