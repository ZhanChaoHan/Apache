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
 * 将图像添加到幻灯片
 * @author zhanchaohan
 *
 */
public class Test8 {
	private static String pptPath="D:\\ppt6.pptx";
	private static String targetPath="D:\\ppt7.pptx";
	private static String imagePath="C:\\Users\\79951\\Desktop\\sucai\\GF3VYWXK$7$)ZA]JS_KYN7S.jpg";
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		XSLFSlide slide = ppt.createSlide();
		byte[] pictureData = IOUtils.toByteArray(new FileInputStream(imagePath));
		XSLFPictureData pd = ppt.addPicture(pictureData, PictureData.PictureType.PNG);
		XSLFPictureShape pic = slide.createPicture(pd);
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
