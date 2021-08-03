package com.jachs.apache.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/***
 * 终值函数（FV），FV（ rate,nper,pmt,pv,type）</br>
 * 现值函数（PV），PV（ rate,nper,pmt,fv,type）</br>
 * 年金函数（PMT），PMT（ rate,nper,pv,fv,type）</br>
 * 净现值函数（NPV），NPV（rate,value1,value2）</br>
 * -------------------------------------------
 * 利率，收益率函数（RATE），RATE（nper,pmt,pv,fv,type,guess）</br>
 * 内部收益率函数（IRR）（values,guess）</br>
 * 计息期、收益期函数（NPER）（rate,pmt,pv,fv,type）</br>
 *--------------------------------------------
 * rate:有效利率或收益率</br>
 * nper:计息期</br>
 * pmt:等额序列现金流量，年金</br>
 * pv:现值</br>
 * type:选择性输入项，0发生期末，1发生期初，默认0</br>
 * fv:终值</br>
 * NPV：定期序列净现金流量的现值之和</br>
 * value:每期期末发生的定期序列净现金流量</br>
 * IRR：内部收益率</br>
 * guess:内部收益率的估值</br>
 * 
 * 
 * @author zhanchaohan
 *
 */
public class TestInterests {
	private static final Workbook workbook = new XSSFWorkbook();

	int rate = 1, nper = 1;
	double val = -5000;

	private void createRow(String tiltle, String type,String path) throws FileNotFoundException, IOException {
		Sheet createSheet = workbook.createSheet(tiltle);

		createSheet.createRow(0).createCell(0).setCellValue(type);
		for (nper = 1; nper < 10; nper++) {
			StringBuffer sb = new StringBuffer();

			sb.append(type).append("(").append(rate).append("%,");
			sb.append(nper).append(",,").append(val).append(")");

			System.out.println(sb.toString());
			Row hSSFRow = createSheet.createRow(nper);

			hSSFRow.createCell(0).setCellFormula(sb.toString());
		}
		workbook.write(new FileOutputStream(path));
	}

	@Test
	public void TestFV() throws IOException {
		createRow("现金的终值","FV","e:\\TestFV.xlsx");
	}

	@Test
	public void testPV() throws FileNotFoundException, IOException {
		createRow("终值的现值","PV","e:\\TestPV.xlsx");
	}
	//年金
	@Test
	public void testPMT() throws FileNotFoundException, IOException {
		Sheet createSheet = workbook.createSheet("PMT");
		
		createSheet.createRow(0).createCell(0).setCellFormula("PMT(12%/12,5*12,,350000,1)");
		
		workbook.write(new FileOutputStream("e:\\testPMT.xlsx"));
	}
}
