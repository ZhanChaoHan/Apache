package com.jachs.apacheapi.excel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
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
		
		fillRow(hs.getRow(4),"马X国");//第4列，序号1上午
		fillRow(hs.getRow(5),null);//第4列，序号1下午
		
		fillRow(hs.getRow(6),"马X云");//第5列，序号2上午
		fillRow(hs.getRow(7),null);//第5列，序号2下午
		
		
		fillRow(hs.getRow(8),"马X腾");
		fillRow(hs.getRow(9),null);
		
		fillRow(hs.getRow(10),"老x马");
		fillRow(hs.getRow(11),null);
		
		fillRow(hs.getRow(12),"小x马");
		fillRow(hs.getRow(13),null);
		
		fillRow(hs.getRow(14),"马x师");
		fillRow(hs.getRow(15),null);
		
		fillRow(hs.getRow(16),"Giao");
		fillRow(hs.getRow(17),null);
		
		fillRow(hs.getRow(18),"Jca");
		fillRow(hs.getRow(19),null);
		
		//添加备注
		hs.getRow(20).getCell(1).setCellValue("备注就是这是测试表格Only For Test");
		//添加
		hs.getRow(21).getCell(0).setCellValue("               部门负责人签字：      Jachs                                                   考勤员签字：    NoOne                                  ");
		hw.write(new File(Test2012Excel.class.getResource("").getPath()+File.separator+"2012年填充表格.xls"));
	}
	
	private void fillRow(Row row,String name) {
		if(StringUtils.isNotBlank(name)) {
			row.getCell(1).setCellValue(name);
		}
		for (int kl = 3; kl < 35; kl++) {//第三格开始循环
			row.getCell(kl).setCellValue(RandomStringUtils.random(1, 0x4e00, 0x9fa5, false,false));//随机个字符串
		}
	}
}
