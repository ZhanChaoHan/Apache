package com.jachs.apacheapi;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.junit.Test;

import com.jachs.apache.excel.create.CreateExcelUtill;

/***
 * 终值函数（FV），FV（ rate,nper,pmt,pv,type）</br>
 * 现值函数（PV），PV（ rate,nper,pmt,fv,type）</br>
 * 年金函数（PMT），PMT（ rate,nper,pv,fv,type）</br>
 * 净现值函数（NPV），NPV（rate,value1,value2）</br>
 * 利率，收益率函数（RATE），RATE（nper,pmt,pv,fv,type,guess）</br>
 * 内部收益率函数（IRR）（values,guess）</br>
 * 计息期、收益期函数（NPER）（rate,pmt,pv,fv,type）</br>
 *
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
public class TestExcellForSecond {

	/**
	 * @throws IOException ***
	 * 
	 */
	@Test
	public void TestFV() throws IOException {
		CreateExcelUtill createExcelUtill = new CreateExcelUtill();
		
		HSSFRow hSSFRow = createExcelUtill.createRow(createExcelUtill.createShell("FV"), 0);
		hSSFRow.createCell(1).setCellFormula("FV(6%,5,,-50000)");//现金的终值五期
		createExcelUtill.writerExcel("e:\\f.xls");
	}
}
