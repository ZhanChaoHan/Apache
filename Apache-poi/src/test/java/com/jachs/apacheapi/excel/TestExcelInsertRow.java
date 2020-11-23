package com.jachs.apacheapi.excel;


import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class TestExcelInsertRow {
    private static HSSFWorkbook hw;
    
    @Before
    public void init() throws IOException {
        hw = new HSSFWorkbook (
                Test2012ExcelReadAllAndFill.class.getResourceAsStream ( "/excel/公司员工考勤表.xls" ) );
    }
    @After
    public void destroy() throws IOException {
        hw.write(new File(Test2012ExcelReadAllAndFill.class.getResource("").getPath()+File.separator+"公司员工考勤表changRow表格.xls"));
    }
    /***
     * 测试 shiftRows
     * @author zhanchaohan
     */
    @Test
    public void tests (){
        Sheet testSheet=hw.getSheet ( "Sheet2" );
        
        System.out.println ( testSheet.getRow ( 0 ).getCell ( 0 ).getStringCellValue () );
        int lastRowNumber=testSheet.getLastRowNum ();
        
        testSheet.createRow ( 30 ).createCell ( 2 ).setCellValue ( "ABC" );
        /***
         * startRow:起始行下标
         * endRow:结束行下标
         * startRow-endRow：受影响区间，如果为正数往下同步，如果为负数往上同步
         * n:插入的行数
         * 如果n为正数则往下插入如果为负数则往上插入。
         */
//        testSheet.shiftRows ( 5  ,9 , -2 );//5上推2格顶掉了3 4,5 6 7 8 9同步上推了2格拉开2格距离和10
        testSheet.shiftRows ( 5  ,9 , 2 );//9顶掉了10 11,5-end同步后推了2格
    }
    
}
