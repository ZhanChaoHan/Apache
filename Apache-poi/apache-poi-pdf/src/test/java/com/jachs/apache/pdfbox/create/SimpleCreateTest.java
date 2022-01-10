package com.jachs.apache.pdfbox.create;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.Test;

/**
 * 
 * @author zhanchaohan
 *
 */
public class SimpleCreateTest {
	private String projectPath = SimpleCreateTest.class.getResource("/").getPath();

	@Test
	public void test1() throws Exception {
		// 创建空白文档
		PDDocument document = new PDDocument();

		document.save(new File(projectPath + File.separator + "test.pdf"));
		document.close();
	}

	@Test
	public void test2() throws Exception {
		PDDocument document = new PDDocument();
		// 创建空白pdf页
		PDPage my_page = new PDPage();

		document.addPage(my_page);
		document.save(new File(projectPath + File.separator + "test1.pdf"));
		document.close();
	}

	
}
