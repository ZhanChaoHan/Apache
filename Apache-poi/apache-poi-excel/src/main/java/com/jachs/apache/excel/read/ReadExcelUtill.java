package com.jachs.apache.excel.read;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ReadExcelUtill {
	private final static String xls = "xls";  
    private final static String xlsx = "xlsx";  
    private static Workbook workbook = null;
    
    public   ReadExcelUtill(File file) {  
        try {  
            InputStream is = new FileInputStream(file);  
            if(file.getName().endsWith(xls)){  
                //2003  
                workbook = new HSSFWorkbook(is);  
            }else if(file.getName().endsWith(xlsx)){  
                //2007  
                workbook = new XSSFWorkbook(is);  
            }  
        } catch (IOException e) {
        	e.printStackTrace();
        }  
    }
    private static Object getValue(Cell cell) {
    	Object obj = null;
    	switch (cell.getCellTypeEnum()) {
	        case BOOLEAN:
	            obj = cell.getBooleanCellValue(); 
	            break;
	        case ERROR:
	            obj = cell.getErrorCellValue(); 
	            break;
	        case NUMERIC:
	            obj = cell.getNumericCellValue(); 
	            break;
	        case STRING:
	            obj = cell.getStringCellValue(); 
	            break;
	        default:
	            break;
    	}
    	return obj;
    }

    public void getInfo() {
    	Sheet sheet= workbook.getSheetAt(0);//获取页码可以根据下标，可以根据名称
    	for (Row row : sheet) {//变量当前页面下的行
    		Iterator<Cell> cellIter=row.cellIterator();
    		System.out.println("总列数：" + row.getPhysicalNumberOfCells());
    		System.out.println("最大列数：" + row.getLastCellNum());
    		while(cellIter.hasNext()) {
    			Cell cell= cellIter.next();//变量行下的单元格
    			System.out.print(getValue(cell)+"\t\t");
    		}
    		System.out.println("\n");
		}
    	
    }
}
