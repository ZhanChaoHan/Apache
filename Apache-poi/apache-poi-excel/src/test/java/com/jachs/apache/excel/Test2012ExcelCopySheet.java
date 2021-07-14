package com.jachs.apache.excel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

/**
 * 复制sheet页
 * @author zhanchaohan
 * 
 */
public class Test2012ExcelCopySheet {
    @Test
    public void copySheet () throws IOException {
        HSSFWorkbook hw = new HSSFWorkbook (
                Test2012ExcelReadAllAndFill.class.getResourceAsStream ( "/excel/2012年员工考勤表.xls" ) );

        Sheet cs = hw.cloneSheet ( 0 );//直接克隆了一个sheet页

        Sheet copySheet = hw.createSheet ( "copySheet" );//自定义要克隆的sheet页

        Iterator<Row> iRow = cs.iterator ();
        int rowNumber = 0;
        while ( iRow.hasNext () ) {
            Row row = iRow.next ();

            Row Trow = copySheet.createRow ( rowNumber );

            Iterator<Cell> iCell = row.cellIterator ();
            int cellNumber = 0;
            while ( iCell.hasNext () ) {
                Cell cell = iCell.next ();

                Cell Tcell = Trow.createCell ( cellNumber );

//                System.out.println ( cell.getCellType ().getCode () );
//                System.out.println ( cell.getCellType ().name () );
                
                //复制样式
                Tcell.setCellStyle ( cell.getCellStyle () );
                
                //复制文本内容
                switch (cell.getCellType()) {
                    case _NONE :
                        Tcell.setCellValue ( "" );
                        break;
                    case NUMERIC :
                        Tcell.setCellValue ( cell.getNumericCellValue () );
                        break;
                    case STRING :
                        Tcell.setCellValue ( cell.getStringCellValue() );
                        break;
                    case FORMULA :
                        Tcell.setCellValue ( cell.getCellFormula() );
                        break;
                    case BLANK :
                        Tcell.setCellValue ( "" );
                        break;
                    case BOOLEAN :
                        Tcell.setCellValue ( cell.getBooleanCellValue () );
                        break;
                    case ERROR :
                        Tcell.setCellValue ( cell.getErrorCellValue () );
                        break;
                    default:
                        break;
                }
                cellNumber++;
            }
            rowNumber++;
        }
        List<CellRangeAddress>craList= cs.getMergedRegions ();//合并单元格集合
        for ( CellRangeAddress cellRangeAddress : craList ) {//开始复制合并单元格
            copySheet.addMergedRegion ( cellRangeAddress );
        }
        copySheet.setDefaultRowHeight (cs.getDefaultRowHeight ());//复制默认行高
        copySheet.setDefaultColumnWidth ( cs.getDefaultColumnWidth () );//复制默认表格宽度
        hw.write(new File(Test2012ExcelReadAllAndFill.class.getResource("").getPath()+File.separator+"2012年copySheet表格.xls"));
    }
}
