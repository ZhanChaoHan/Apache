package com.jachs.apache_poi_ppt.xslf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/***
 * 创建具有预定义布局的幻灯片
 * @author zhanchaohan
 *
 */
public class Test3 {
	private static String pptPath="D:\\ppt2.pptx";
	private static String targetPath="D:\\ppt3.pptx";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(pptPath));
		// first see what slide layouts are available :
		System.out.println("Available slide layouts:");
		for(XSLFSlideMaster master : ppt.getSlideMasters()){
		    for(XSLFSlideLayout layout : master.getSlideLayouts()){
		        System.out.println(layout.getType());
		    }
		}
		// blank slide
		XSLFSlide blankSlide = ppt.createSlide();
		// there can be multiple masters each referencing a number of layouts
		// for demonstration purposes we use the first (default) slide master
		XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);
		// title slide
		XSLFSlideLayout titleLayout = defaultMaster.getLayout(SlideLayout.TITLE);
		// fill the placeholders
		XSLFSlide slide1 = ppt.createSlide(titleLayout);
		XSLFTextShape title1 = slide1.getPlaceholder(0);
		title1.setText("First Title");
		// title and content
		XSLFSlideLayout titleBodyLayout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
		XSLFSlide slide2 = ppt.createSlide(titleBodyLayout);
		XSLFTextShape title2 = slide2.getPlaceholder(0);
		title2.setText("Second Title");
		XSLFTextShape body2 = slide2.getPlaceholder(1);
		body2.clearText(); // unset any existing text
		body2.addNewTextParagraph().addNewTextRun().setText("First paragraph");
		body2.addNewTextParagraph().addNewTextRun().setText("Second paragraph");
		body2.addNewTextParagraph().addNewTextRun().setText("Third paragraph");
		
		ppt.write(new FileOutputStream(targetPath));
	}
}
