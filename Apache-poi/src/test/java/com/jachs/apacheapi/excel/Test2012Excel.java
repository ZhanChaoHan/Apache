package com.jachs.apacheapi.excel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Test2012Excel {
	/****
	 * 读取全量表格数据
	 * @throws Exception
	 */
	@Test
	public void ReadAll() throws Exception {
		HSSFWorkbook hw=new HSSFWorkbook(Test2012Excel.class.getResourceAsStream("/excel/2012年员工考勤表.xls"));
		
		HSSFSheet hs= hw.getSheet("2012年1月");
		
		 Iterator<Row> iR=hs.rowIterator();
		 while(iR.hasNext()) {
			 Row rw= iR.next();
			 
			 Iterator<Cell> lc= rw.cellIterator();
			 while(lc.hasNext()) {
				 Cell ce=lc.next();
				 switch (ce.getCellType()) {
				case _NONE :
					System.out.print("");
					break;
				case NUMERIC :
					System.out.print(ce.getNumericCellValue());
						break;
				case STRING :
					System.out.print(ce.getStringCellValue());
					break;
				case FORMULA :
					System.out.print(ce.getCellFormula());	
					break;
				case BLANK :
					System.out.print("空");	
					break;
				case BOOLEAN :
					System.out.print(ce.getBooleanCellValue());	
					break;
				case ERROR :
					System.out.print(ce.getErrorCellValue());	
					break;
				default:
					break;
				}
				 
			 }
			 System.out.println();
		 }
	}
	/***
	 * 填满表格
	 * @throws IOException 
	 */
	@Test
	public void fillExcel() throws IOException {
		HSSFWorkbook hw=new HSSFWorkbook(Test2012Excel.class.getResourceAsStream("/excel/2012年员工考勤表.xls"));
		HSSFSheet hs= hw.getSheet("2012年1月");
		
		
		System.out.println(hs.getRow(0).getCell(0).getStringCellValue());//员工考勤表

		Row row1= hs.getRow(1);
		System.out.println(row1.getCell(0).getStringCellValue());//     单位：财务部
		row1.getCell(0).setCellValue("单位：财务部-测试组");//修改名称
		
		
		hw.write(new File(Test2012Excel.class.getResource("").getPath()+File.separator+"2012年填充表格.xls"));
	}
}
