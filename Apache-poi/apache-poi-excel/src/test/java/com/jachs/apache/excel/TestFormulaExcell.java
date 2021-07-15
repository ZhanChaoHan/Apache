package com.jachs.apache.excel;


import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.junit.Test;

import com.jachs.apache.excel.create.CreateExcelUtill;
import com.jachs.apache.excel.read.ReadExcelUtill;


/***
 * 
 * @author zhanchaohan
 *
 */
public class TestExcell {
	@Test
	public void testWrite() throws IOException {
		CreateExcelUtill createExcelUtill = new CreateExcelUtill();
		for (int u = 0; u < 20; u++) {
			HSSFSheet hSSFSheet = createExcelUtill.createShell(u + "");
			HSSFRow hSSFRow = createExcelUtill.createRow(hSSFSheet, u); // hSSFRow.createCell(6);
			HSSFCell hSSFCell5 = hSSFRow.createCell(5);
			HSSFCell hSSFCell6 = hSSFRow.createCell(6);

			hSSFCell5.setCellValue(5.67);
			hSSFCell6.setCellValue(5.87);
			hSSFRow.createCell(7).setCellFormula("sum(" + hSSFCell5.getAddress() + ":" + hSSFCell6.getAddress() + ")");
			hSSFRow.createCell(8).setCellFormula("PI()");
			createExcelUtill.createCell(hSSFRow, u, createExcelUtill.createCellStyle(), u);
			createExcelUtill.writerExcel("e:\\a.xls");

		}

	}

	@Test
	public void testRead() {
		ReadExcelUtill readExcelUtill = new ReadExcelUtill(new File("e:\\\\a.xls"));
		readExcelUtill.getInfo();
	}
}
