package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/***
 * 阅读演示文稿中包含的图像
 * @author zhanchaohan
 *
 */
public class Test9 {
	private static String targetPath="D:\\ppt7.pptx";
	private static String imagePath="C:\\Users\\79951\\Desktop\\sucai\\GF3VYWXK$7$)ZA]JS_KYN7S.jpg";
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(targetPath));
		for(XSLFPictureData data : ppt.getPictureData()){
		    byte[] bytes = data.getData();
		    String fileName = data.getFileName();
		    
		    System.out.println(fileName);
		}
	}
}
