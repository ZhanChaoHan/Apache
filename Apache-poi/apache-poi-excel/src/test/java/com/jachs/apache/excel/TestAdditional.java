package com.jachs.apache.excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

import com.jachs.apache.excel.create.CreateExcelUtill;
import com.jachs.apache.excel.read.ReadExcelUtill;

/**
 * 给定模板追加数据
 * @author zhanchaohan
 * 
 */
public class TestAdditional {
    @Test
    public void test() throws IOException {
        CreateExcelUtill ceu=new CreateExcelUtill();
        ReadExcelUtill reu=new ReadExcelUtill(new File(TestAdditional.class.getResource ( "/test.xls" ).getPath ()) );
        
        reu.getInfo ();
        
    }
}
