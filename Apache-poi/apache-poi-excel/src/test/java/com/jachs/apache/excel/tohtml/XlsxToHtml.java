package com.jachs.apache.excel.tohtml;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class XlsxToHtml {
	private static String filePath="C:\\Users\\79951\\Desktop\\sucai\\aa.xlsx";
	private static String htmlPath="C:\\Users\\79951\\Desktop\\a.html";
	
	BufferedWriter bw;
	
	@Before
	public void init() throws Exception {
		bw=new BufferedWriter(new FileWriter(htmlPath));
		
		bw.write("<html>\n");
		bw.write("<body>\n");
	}
	@After
	public void close() throws Exception {
		
		printLine("</body>\n");
		printLine("</html>\n");
		bw.close();
	}
	
	private void printLine(String info) throws IOException {
		bw.write("<span>"+info+"</span>");
	}
	@Test
	public void test1() throws Exception {
		Workbook workbook;
		
		String hz=FilenameUtils.getExtension(filePath);
		if(!hz.equalsIgnoreCase("xlsx")&&!hz.equalsIgnoreCase("xls")) {
			throw new Exception("格式错误");
		}
		if(hz.equalsIgnoreCase("xlsx")) {
			workbook=new XSSFWorkbook(new FileInputStream(filePath));
		}else {
			workbook=new HSSFWorkbook(new FileInputStream(filePath));
		}
		Sheet sheet=workbook.getSheetAt(0);
		
		int lastRow=sheet.getLastRowNum();
		for (int kk = 0; kk < lastRow; kk++) {
			Row row=sheet.getRow(kk);
			if(row!=null) {
				int lastCell=row.getLastCellNum();
				
				printLine("<br>\n");
				copyText(lastCell,row);
			}
		}
	}
	
	private void copyText(int lastCell,Row row) throws IOException {
		for (int mm = 0; mm < lastCell; mm++) {
			Cell cell=row.getCell(mm);
			if(cell!=null) {
				CellType ct=row.getCell(mm).getCellType();
				 switch (ct) {
					case _NONE :
						System.out.print("\n");
						break;
					case NUMERIC :
						printLine(cell.getNumericCellValue()+"");
						break;
					case STRING :
						printLine(cell.getStringCellValue());
						break;
					case FORMULA :
						printLine(cell.getCellFormula());	
						break;
					case BLANK :
//						printLine("                    \n");	
						break;
					case BOOLEAN :
						printLine(cell.getBooleanCellValue()+"");	
						break;
					case ERROR :
						printLine(cell.getErrorCellValue()+"");	
						break;
					default:
						break;
				}
			}
		}
	}
}
