package com.jachs.apache_poi_ppt.hslf;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;

/***
 * 
 * @author zhanchaohan
 * @see https://poi.apache.org/components/slideshow/how-to-shapes.html#PageSize
 */
public class Test2 {
	
	public static void main(String[] args) throws IOException {
		HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl("slideshow.ppt"));
		//retrieve page size. Coordinates are expressed in points (72 dpi)
		java.awt.Dimension pgsize = ppt.getPageSize();
		int pgx = pgsize.width; //slide width
		int pgy = pgsize.height; //slide height
		//set new page size
		ppt.setPageSize(new java.awt.Dimension(1024, 768));
		//save changes 
		FileOutputStream out = new FileOutputStream("slideshow.ppt");
		ppt.write(out);
		out.close();
	}
}
