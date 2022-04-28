package com.jachs.apache_poi_ppt.xslf.to_html;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.net.util.Base64;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 * @see https://poi.apache.org/components/slideshow/xslf-cookbook.html#PPTX2PNG
 */
public class Test1 {
	private static String pptPath="C:\\Users\\79951\\Downloads\\b48-9470-e9174f81dc7f.pptx";
	private static String htmlPath="d:\\e\\aa.html";
	OutputStream os;
	Base64 base=new Base64 ();
	
	@Before
	public void init () throws Exception {
		os=new FileOutputStream(htmlPath);
		
		os.write("<html>".getBytes());
		os.write("<body>".getBytes());
	}
	@After
	public void destory() throws Exception{
		os.write("</body>".getBytes());
		os.write("</html>".getBytes());
		os.close();
	}
	@Test
	public void test1() throws Exception{
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		List<XSLFSlide> slidesList=ppt.getSlides();
		
		Dimension pgsize = ppt.getPageSize();
		for (XSLFSlide xslfSlide : slidesList) {
			BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics = img.createGraphics();
		    // clear the drawing area
		    graphics.setPaint(Color.white);
		    graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
			xslfSlide.draw(graphics);
			
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
