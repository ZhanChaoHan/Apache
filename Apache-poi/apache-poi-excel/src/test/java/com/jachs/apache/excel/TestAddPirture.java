package com.jachs.apache.excel;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.*;
import java.util.List;

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
    @Test
    public void test2() throws Exception {
    	Workbook workbook=new HSSFWorkbook(new FileInputStream("C:\\Users\\79951\\Desktop\\s.xls"));
		
		Sheet sheet=workbook.getSheetAt(0);
		
		List<HSSFPictureData> picData=(List<HSSFPictureData>) workbook.getAllPictures();
		int count=1;
		
		for (HSSFPictureData hssfPictureData : picData) {
			String type=printPicType(hssfPictureData.getFormat());
			System.out.println(hssfPictureData.getMimeType());
			System.out.println(hssfPictureData.getPictureType());
//			System.out.println(hssfPictureData.getData());
			
			
			OutputStream os=new FileOutputStream("d:\\"+count+type);
			os.write(hssfPictureData.getData());
			os.close();
			count++;
		}
		
		workbook.close();
    }
    
    private String printPicType(int code) {
    	switch (code) {
		case Workbook.PICTURE_TYPE_DIB:
			return ".DIB";
		case Workbook.PICTURE_TYPE_WMF:
			return ".WMF";
		case Workbook.PICTURE_TYPE_EMF:
			return ".EMF";
		case Workbook.PICTURE_TYPE_PNG:
			return ".PNG";
		case Workbook.PICTURE_TYPE_JPEG:
			return ".JPEG";
		case Workbook.PICTURE_TYPE_PICT:
			return ".PICT";
		default:
			return "";
		}
    }
}
