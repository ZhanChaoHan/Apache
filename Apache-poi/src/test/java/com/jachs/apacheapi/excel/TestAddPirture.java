package com.jachs.apacheapi.excel;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.*;

/***
 * excel插入图片
 * @author zhanchaohan
 */
public class TestAddPirture {


    @Test
    public void test1() throws  Exception{
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        InputStream os=new FileInputStream(TestAddPirture.class.getResource("/image/01.jpg").getPath());

        byte []OneM=new byte[1024];
        while(os.read(OneM)!=-1){
            bos.write(OneM,0,OneM.length);
        }


        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet mySheet=wb.createSheet();

        HSSFPatriarch patriarch = (HSSFPatriarch) mySheet.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 150, 1000, 210, (short) 0, 0, (short) 1, 1);
        patriarch.createPicture(anchor, wb.addPicture(bos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

        wb.write(new File(Test2012ExcelReadAllAndFill.class.getResource("").getPath()+File.separator+"插入图片.xls"));

        bos.close();
        os.close();
    }
}
