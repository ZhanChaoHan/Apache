package com.jachs.apache.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class TestExcellForSecond {
	
	/***
	 * 加入运算
	 * @throws IOException
	 */
	@Test
	public void testOperation() throws IOException {
		Workbook workbook=new XSSFWorkbook();
		for (int u = 0; u < 20; u++) {
			Sheet hSSFSheet = workbook.createSheet(u + "");
			Row hSSFRow = hSSFSheet.createRow(u);
			Cell hSSFCell5 = hSSFRow.createCell(5);
			Cell hSSFCell6 = hSSFRow.createCell(6);

			hSSFCell5.setCellValue(5.67);
			hSSFCell6.setCellValue(5.87);
			hSSFRow.createCell(7).setCellFormula("sum(" + hSSFCell5.getAddress() + ":" + hSSFCell6.getAddress() + ")");
			hSSFRow.createCell(8).setCellFormula("PI()");

			workbook.write(new FileOutputStream("e:\\testOperation.xlsx"));
		}
	}
	/***
	 * 设置下拉选
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testSelect() throws FileNotFoundException, IOException {
		Workbook workbook=new XSSFWorkbook();
		
		Sheet sheet= workbook.createSheet();
		
		DataValidationHelper helper = sheet.getDataValidationHelper(); 
		
		//CellRangeAddressList(firstRow, lastRow, firstCol, lastCol)设置行列范围
		CellRangeAddressList addressList = new CellRangeAddressList(1, 5, 1, 5);
		
		//设置下拉框数据
		String[]pos = new String[] {"周一","周二","周三","周四","周五"};
		DataValidationConstraint constraint = helper.createExplicitListConstraint(pos); 
		DataValidation dataValidation = helper.createValidation(constraint, addressList);
		
		//处理Excel兼容性问题
		if(dataValidation instanceof XSSFDataValidation) {
			dataValidation.setSuppressDropDownArrow(true);
			dataValidation.setShowErrorBox(true);
		}else {
			dataValidation.setSuppressDropDownArrow(false);
		}
		
		sheet.addValidationData(dataValidation);
		workbook.write(new FileOutputStream("e:\\testSelect.xlsx"));
	}
}
