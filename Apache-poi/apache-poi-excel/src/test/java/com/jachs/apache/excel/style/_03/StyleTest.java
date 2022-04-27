package com.jachs.apache.excel.style._03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class StyleTest {
	private String filePath="C:\\Users\\79951\\Desktop\\a.xls";
	
	@Test
	public void test1() throws FileNotFoundException, IOException {
		Workbook workbook=new HSSFWorkbook(new FileInputStream(filePath));
		
		Sheet sheet=workbook.getSheetAt(0);
		Row row=sheet.getRow(3);
		Cell cell=row.getCell(2);
		
		//
		CellStyle style=cell.getCellStyle();
		
//		CellStyle cellStyle=workbook.getCellStyleAt(0);
		Font font=workbook.getFontAt(style.getFontIndex());
		printFont(font);
		
	}
	//字体
	private void printFont(Font font) {
		System.out.println("Bold\t"+font.getBold());
		System.out.println("CharSet\t"+font.getCharSet());
		System.out.println("Color\t"+font.getColor());
		System.out.println("FontHeight\t"+font.getFontHeight());
		System.out.println("FontHeightInPoints\t"+font.getFontHeightInPoints());
		System.out.println("FontName\t"+font.getFontName());
		System.out.println("Index\t"+font.getIndex());
		System.out.println("IndexAsInt\t"+font.getIndexAsInt());
		System.out.println("TypeOffset\t"+font.getTypeOffset());
		System.out.println("Underline\t"+font.getUnderline());
		System.out.println("Italic\t"+font.getItalic());
		System.out.println("Strikeout\t"+font.getStrikeout());
	}
	private void printStyle(CellStyle style) {
		style.getAlignment();//单元格水平对齐
		style.getAlignmentEnum();//单元格的水平对齐
		
	}
}
