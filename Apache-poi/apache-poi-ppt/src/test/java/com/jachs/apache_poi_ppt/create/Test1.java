package com.jachs.apache_poi_ppt.create;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow();
        // 创建幻灯片
        XSLFSlide slide = ppt.createSlide();
        // 创建文本框
        XSLFTextBox textBox = slide.createTextBox();
        // x y设置距离  w h 设置大小
        textBox.setAnchor(new Rectangle2D.Double(300,50, 100, 50));
		// 设置文本框的内容        
		textBox.addNewTextParagraph().addNewTextRun().setText("创建PPT");
		// 插入图片
		// 获取图片的file对象
        File file = new File("D:\\8.png");
        // 获取字节流
        byte[] bt = FileUtils.readFileToByteArray(file);
        XSLFPictureData idx = ppt.addPicture(bt, PictureData.PictureType.PNG);
        // 插入图片
        XSLFPictureShape pic = slide.createPicture(idx);
        pic.setAnchor(new Rectangle2D.Double(100,100,500,350));
        // 创建新一页的幻灯片
        XSLFSlide slide2 = ppt.createSlide();
        XSLFTextBox textBox2 = slide2.createTextBox();
        // x y设置距离  w h 设置大小
        textBox2.setAnchor(new Rectangle2D.Double(300,50, 100, 50));
        textBox2.addNewTextParagraph().addNewTextRun().setText("创建ppt2");
        // 写入ppt中
        ppt.write(new FileOutputStream("D:\\ppt8.pptx"));

	}

}
