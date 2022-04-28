package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/***
 * 合并多个演示文稿
 * @author zhanchaohan
 *
 */
public class Test12 {
	private static String pptPath="D:\\ppt8.pptx";
	private static String targetPath="D:\\merged.pptx";
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		String[] inputs = {"D:\\ppt2.pptx", "D:\\ppt3.pptx"};
		for(String arg : inputs){
		    FileInputStream is = new FileInputStream(arg);
		    XMLSlideShow src = new XMLSlideShow(is);
		    is.close();
		    for(XSLFSlide srcSlide : src.getSlides()){
		        ppt.createSlide().importContent(srcSlide);
		    }
		}
		FileOutputStream out = new FileOutputStream(targetPath);
		ppt.write(out);
		out.close();
		
	}
}
