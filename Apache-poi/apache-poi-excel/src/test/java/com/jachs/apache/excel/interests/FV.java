package com.jachs.apache.excel.interests;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/***
 * 返回一笔投资的未来值</br>
 * FV(rate,nper,pmt,[pv],[type])</br>
 * 有关函数 FV 中各参数以及年金函数的详细信息，请参阅函数 PV。</br>
 * -------------------------------------------------------
 * FV 函数语法具有下列参数：</br>
 * Rate 必需。 各期利率。</br>
 * Nper 必需。 年金的付款总期数。</br>
 * Pmt 必需。 各期所应支付的金额，在整个年金期间保持不变。 通常 pmt 包括本金和利息，但不包括其他费用或税款。 如果省略 pmt，则必须包括 pv
 * 参数。</br>
 * pv 可选。 现值，或一系列未来付款的当前值的累积和。 如果省略 pv，则假定其值为 0（零），并且必须包括 pmt 参数。</br>
 * Type 可选。 数字 0 或 1，用以指定各期的付款时间是在期初还是期末。 如果省略 type，则假定其值为 0。</br>
 * 
 * @author zhanchaohan
 * @see https://support.microsoft.com/zh-cn/office/fv-%E5%87%BD%E6%95%B0-2eef9f44-a084-4c61-bdd8-4fe4bb1b71b3
 */
public class FV {
	private static final Workbook workbook = new XSSFWorkbook();
	private static final Sheet createSheet = workbook.createSheet("TestPV");

	@Test
	public void TestFV() throws IOException {
		// 利率10%,1期,现在投入10000,未来可获得多少？
		createSheet.createRow(0).createCell(0).setCellFormula("FV(10%,1,,-10000,1)");
		createSheet.createRow(1).createCell(0).setCellFormula("FV(10%,1,,-10000,0)");
		//利率8%,5期,现在投入1000，到期可获得多少？
		createSheet.createRow(2).createCell(0).setCellFormula("FV(8%,5,,-1000)");
		workbook.write(new FileOutputStream("e:\\TestFV.xlsx"));
	}
	//年金
	@Test
	public void TestFV2() throws IOException {
		createSheet.createRow(0).createCell(0).setCellFormula("FV(10%/12,12*20,-600)");
		
		workbook.write(new FileOutputStream("e:\\TestFV.xlsx"));
	}
}
