package com.jachs.apache_poi_ppt.hslf;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;

/***
 * 如何检索或更改幻灯片大小
 * @author zhanchaohan
 * @see https://poi.apache.org/components/slideshow/how-to-shapes.html#PageSize
 */
public class Test2 {
	private static String pptPath="D:\\ppt1.ppt";
	private static String targetPath="D:\\ppt2.ppt";
	
	public static void main(String[] args) throws IOException {
		HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl(pptPath));
		//retrieve page size. Coordinates are expressed in points (72 dpi)
		java.awt.Dimension pgsize = ppt.getPageSize();
		int pgx = pgsize.width; //slide width
		int pgy = pgsize.height; //slide height
		//set new page size
		ppt.setPageSize(new java.awt.Dimension(1024, 768));
		//save changes 
		FileOutputStream out = new FileOutputStream(targetPath);
		ppt.write(out);
		out.close();
	}
}
