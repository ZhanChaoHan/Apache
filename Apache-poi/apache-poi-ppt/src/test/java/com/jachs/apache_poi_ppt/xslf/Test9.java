package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;

/***
 * 阅读演示文稿中包含的图像
 * @author zhanchaohan
 *
 */
public class Test9 {
	private static String targetPath="C:\\Users\\79951\\Downloads\\b48-9470-e9174f81dc7f.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(targetPath));
		for(XSLFPictureData data : ppt.getPictureData()){
		    byte[] bytes = data.getData();
		    String fileName = data.getFileName();
		    
		    System.out.println(fileName);
		}
	}
}
