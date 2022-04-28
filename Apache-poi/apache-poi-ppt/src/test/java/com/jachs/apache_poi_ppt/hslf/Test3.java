package com.jachs.apache_poi_ppt.hslf;

import java.awt.geom.Rectangle2D;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFAutoShape;
import org.apache.poi.hslf.usermodel.HSLFPictureShape;
import org.apache.poi.hslf.usermodel.HSLFShape;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hslf.usermodel.HSLFTextBox;
import org.apache.poi.sl.usermodel.Line;

/***
 * 如何获取特定幻灯片中包含的形状下面的代码演示了如何迭代每张幻灯片的形状
 * @author zhanchaohan
 * @see https://poi.apache.org/components/slideshow/how-to-shapes.html#GetShapes
 */
public class Test3 {
	private static String pptPath="D:\\ppt2.ppt";
	private static String targetPath="D:\\ppt3.ppt";
	
	public static void main(String[] args) throws IOException {
		HSLFSlideShow ppt = new HSLFSlideShow(new HSLFSlideShowImpl(pptPath));
		// get slides
		for (HSLFSlide slide : ppt.getSlides()) {
		    for (HSLFShape sh : slide.getShapes()) {
		        // name of the shape
		        String name = sh.getShapeName();
		        // shapes's anchor which defines the position of this shape in the slide
		        Rectangle2D anchor = sh.getAnchor();
		        if (sh instanceof Line) {
		            Line line = (Line) sh;
		            // work with Line
		            System.out.println("Line");
		        } else if (sh instanceof HSLFAutoShape) {
		            HSLFAutoShape shape = (HSLFAutoShape) sh;
		            // work with AutoShape
		            System.out.println("HSLFAutoShape");
		        } else if (sh instanceof HSLFTextBox) {
		            HSLFTextBox shape = (HSLFTextBox) sh;
		            // work with TextBox
		            System.out.println("HSLFTextBox");
		        } else if (sh instanceof HSLFPictureShape) {
		            HSLFPictureShape shape = (HSLFPictureShape) sh;
		            // work with Picture
		            System.out.println("HSLFPictureShape");
		        }
		    }
		}
	}
}
