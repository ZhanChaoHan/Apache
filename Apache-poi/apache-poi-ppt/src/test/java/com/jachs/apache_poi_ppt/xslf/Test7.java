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
 * 更改幻灯片大小
 * @author zhanchaohan
 *
 */
public class Test7 {
	private static String pptPath="D:\\ppt5.pptx";
	private static String targetPath="D:\\ppt6.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		//retrieve page size. Coordinates are expressed in points (72 dpi)
		java.awt.Dimension pgsize = ppt.getPageSize();
		int pgx = pgsize.width; //slide width in points
		int pgy = pgsize.height; //slide height in points
		//set new page size
		
		System.out.println("width:"+pgx+"\theight:"+pgy);
		ppt.setPageSize(new java.awt.Dimension(1024, 768));
		              
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
