package com.jachs.apache.doc.writer;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/***
 * 
 * @author zhanchaohan
 *
 */
public class P1 {
	static String filePath=P1.class.getResource("").getPath();
	
	public static void main(String[] args) throws Exception {
		XWPFDocument docxDocument = new XWPFDocument();
	
		 //创建第一段落
        XWPFParagraph firstParagraphX = docxDocument.createParagraph();
        firstParagraphX.setAlignment(ParagraphAlignment.CENTER);
        
        XWPFRun runTitle = firstParagraphX.createRun();
        runTitle.setText("大标题");
        runTitle.setBold(true);
        runTitle.setFontSize(24);
        runTitle.setFontFamily("宋体");
        runTitle.addCarriageReturn();//回车键
        
        FileOutputStream stream = new FileOutputStream(filePath+File.separator+"P1.doc");
        docxDocument.write(stream);
        stream.close();
        System.out.println("文件生成完成!");
	}
}
