package com.jachs.apache_poi_ppt.hslf.to_html;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.util.Base64;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * ppt转换为图片
 * @author zhanchaohan
 * @see com.jachs.apache_poi_ppt.hslf.Test14
 */
public class Test14 {
	private static String targetPath="D:\\ppt8.ppt";
	private static String temp="D:\\e\\a.html";
	OutputStream os;
	Base64 base=new Base64 ();
	
	@Before
	public void init() throws IOException {
		os=new FileOutputStream(temp);
		
		os.write("<html>".getBytes());
		os.write("<body>".getBytes());
	}
	@After
	public void destory() throws IOException {
		os.write("</body>".getBytes());
		os.write("</html>".getBytes());
		os.close();
	}
	
	@Test
	public  void test1() throws IOException {
		HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream(targetPath));
		Dimension pgsize = ppt.getPageSize();
		for (HSLFSlide slide : ppt.getSlides()) {
		    BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics = img.createGraphics();
		    // clear the drawing area
		    graphics.setPaint(Color.white);
		    graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
		    // render
		    slide.draw(graphics);
		    // save the output
		    
		    ByteArrayOutputStream out =new ByteArrayOutputStream();
		    javax.imageio.ImageIO.write(img, "png", out);
		    
		    String base64=new String(base.encode(out.toByteArray()));
		    
		    os.write(("<image src='data:image/png;base64,"+base64+"'>").getBytes());
		    os.write(("<p></p>").getBytes());
		    out.close();
		}
		ppt.close();
	}
}