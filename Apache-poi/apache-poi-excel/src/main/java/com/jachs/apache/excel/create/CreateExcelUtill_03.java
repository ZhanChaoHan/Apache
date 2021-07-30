package com.jachs.apache.excel.create;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CreateExcelUtill_03 implements CreateExcelUtill{
	Workbook workbook;
	
	public CreateExcelUtill_03() {
		workbook = new HSSFWorkbook();  
	}

	public CreateExcelUtill_03(InputStream is) {
		try {
			workbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

	public void writerExcel(OutputStream stream) {
		try {
			workbook.write(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public Sheet createShell(String shellName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
