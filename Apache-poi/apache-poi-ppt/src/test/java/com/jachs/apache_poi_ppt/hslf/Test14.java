package com.jachs.apache_poi_ppt.hslf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

/***
 * ppt转换为图片
 * @author zhanchaohan
 */
public class Test14 {
	private static String targetPath="D:\\ppt8.ppt";
	private static String temp="D:\\e\\";
	
	public static void main(String[] args) throws IOException {
		HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream(targetPath));
		Dimension pgsize = ppt.getPageSize();
		int idx = 1;
		for (HSLFSlide slide : ppt.getSlides()) {
		    BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics = img.createGraphics();
		    // clear the drawing area
		    graphics.setPaint(Color.white);
		    graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
		    // render
		    slide.draw(graphics);
		    // save the output
		    FileOutputStream out = new FileOutputStream(temp+"slide-" + idx + ".png");
		    javax.imageio.ImageIO.write(img, "png", out);
		    out.close();
		    idx++;
		}
		ppt.close();
	}
}