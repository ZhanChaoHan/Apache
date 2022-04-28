package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFConnectorShape;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/***
 * 阅读形状
 * @author zhanchaohan
 *
 */
public class Test6 {
	private static String pptPath="D:\\ppt6.pptx";
	private static String targetPath="D:\\ppt7.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		// get slides
		for (XSLFSlide slide : ppt.getSlides()) {
		    for (XSLFShape sh : slide.getShapes()) {
		        // name of the shape
		        String name = sh.getShapeName();
		        // shapes's anchor which defines the position of this shape in the slide
		        if (sh instanceof PlaceableShape) {
		            java.awt.geom.Rectangle2D anchor = ((PlaceableShape)sh).getAnchor();
		        }
		        if (sh instanceof XSLFConnectorShape) {
		            XSLFConnectorShape line = (XSLFConnectorShape) sh;
		            // work with Line
		        } else if (sh instanceof XSLFTextShape) {
		            XSLFTextShape shape = (XSLFTextShape) sh;
		            // work with a shape that can hold text
		        } else if (sh instanceof XSLFPictureShape) {
		            XSLFPictureShape shape = (XSLFPictureShape) sh;
		            // work with Picture
		        }
		    }
		}
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
