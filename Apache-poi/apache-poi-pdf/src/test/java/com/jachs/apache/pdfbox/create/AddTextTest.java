package com.jachs.apache.pdfbox.create;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.Test;

/***
 * PDType1Font.TIMES_ROMAN 定期营业<br>
 * PDType1Font.TIMES_BOLD Times bold<br>
 * PDType1Font.TIMES_ITALIC Times italic<br>
 * PDType1字体。TIMES_BOLD_ITALIC 时代粗体斜体<br>
 * PDType1Font.HELVETICA Helvetica常规<br>
 * PDType1Font.HELVETICA_BOLD Helvetica bold<br>
 * PDType1Font.HELVETICA_OBLIQUE 斜体字<br>
 * PDType1字体。HELVETICA_BOLD_OBLIQUE Helvetica粗体斜体<br>
 * PDType1Font.COURIER Courier<br>
 * PDType1Font.COURIER_BOLD Courier bold<br>
 * PDType1Font.COURIER_OBLIQUE 斜体快递<br>
 * PDType1Font.COURIER_BOLD_OBLIQUE 信使粗体斜体<br>
 * PDType1Font.SYMBOL 符号集<br>
 * PDType1Font.ZAPF_DINGBATS Dingbat字体<br>
 * 
 * @author zhanchaohan
 *
 */
public class AddTextTest {
	private String projectPath = SimpleCreateTest.class.getResource("").getPath();

	@Test
	public void test1() throws Exception {
		PDDocument document = new PDDocument();
		// 创建空白pdf页
		PDPage my_page = new PDPage();

		// 创建内容流
		PDPageContentStream contentStream = new PDPageContentStream(document, my_page);

		contentStream.beginText();
		// 设置文本位置
		contentStream.newLineAtOffset(250, 700);
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 15);
		contentStream.showText("AAA");
		contentStream.newLine();
		contentStream.showText("BBB");
		contentStream.endText();

		document.addPage(my_page);
		contentStream.close();
		document.save(new File(projectPath + File.separator + "test2.pdf"));
		document.close();
	}

	@Test
	public void test3() throws Exception {
		PDDocument document = new PDDocument();
		// 创建空白pdf页
		PDPage my_page = new PDPage();

		// 创建内容流
		PDPageContentStream contentStream = new PDPageContentStream(document, my_page);

		contentStream.beginText();
		// 设置文本位置
		contentStream.newLineAtOffset(250, 700);
		contentStream.setFont(PDType1Font.HELVETICA, 15);
		contentStream.showText("AAA");
		contentStream.newLine();
		contentStream.showText("BBB");
		contentStream.endText();

		document.addPage(my_page);
		contentStream.close();
		document.save(new File(projectPath + File.separator + "test5.pdf"));
		document.close();
	}
	@Test
	public void test6() throws Exception{
		PDDocument document = new PDDocument();
		// 创建空白pdf页
		PDPage my_page = new PDPage();

		// 创建内容流
		PDPageContentStream contentStream = new PDPageContentStream(document, my_page);
		//加载自定义字体
		PDType0Font font = PDType0Font.load(document, new File("c:/windows/fonts/FZSTK.TTF")); 
		
		contentStream.beginText();
		// 设置文本位置
		contentStream.newLineAtOffset(50, 50);
		contentStream.setFont(font, 15);
		contentStream.showText("宋体一段文字没有什么东西凑字数的文字噼里啪啦啦的文字一堆的文字");
		contentStream.moveTextPositionByAmount(20, 20);
		contentStream.newLine();
		contentStream.showText("中文");
//		contentStream.setNonStrokingColor(158);
//		contentStream.setStrokingColor(165);
		contentStream.endText();

		document.addPage(my_page);
		contentStream.close();
		document.save(new File(projectPath + File.separator + "test6.pdf"));
		document.close();
	}
}
