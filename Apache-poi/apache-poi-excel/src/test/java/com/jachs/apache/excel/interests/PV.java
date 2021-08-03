package com.jachs.apache.excel.interests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/***
 * PV函数的功能</br>
 * PV 函数是一个财务函数，用于根据固定利率计算贷款或投资的现值，或者说总额。 可以将 PV
 * 与定期付款、固定付款（如按揭或其他贷款）或投资目标的未来值结合使用。</br>
 * -------------------------------------------</br>
 * PV函数的语法结构</br>
 * PV(rate, nper, pmt, [fv], [type])</br>
 * 参数说明</br>
 * Rate:各期利率。 例如，如果您获得年利率为 10% 的汽车贷款，并且每月还款一次，则每月的利率为 10%/12（即 0.83%）。 您需要在公式中输入
 * 10%/12（即 0.83%）或 0.0083 作为利率。 </br>
 * Nper:年金的付款总期数。 例如，如果您获得为期四年的汽车贷款，每月还款一次，则贷款期数为 4*12（即 48）期。 您需要在公式中输入 48 作为
 * nper。 </br>
 * Pmt:每期的付款金额，在年金周期内不能更改。 通常，pmt 包括本金和利息，但不含其他费用或税金。 例如，对于金额为 ￥100,000、利率为 12%
 * 的四年期汽车贷款，每月付款为 ￥2633.30。 您需要在公式中输入 -2633.30 作为 pmt。 如果省略 pmt，则必须包括 fv 参数。
 * </br>
 * fv:可有可无， 未来值，或在最后一次付款后希望得到的现金余额。 如果省略 [fv]，则假定其值为 0（例如，贷款的未来值是 0）。 例如，如果要在 18
 * 年中为支付某个特殊项目而储蓄 ￥500,000，则 ￥500,000 就是未来值。 然后，您可以对利率进行保守的猜测，并确定每月必须储蓄的金额。 如果省略
 * fv，则必须包括 pmt 参数。 </br>
 * type：可有可无， 数字 0 或 1，用以指定各期的付款时间是在期初还是期末。
 * 
 * @author zhanchaohan
 *
 */
public class PV {
	private static final Workbook workbook = new XSSFWorkbook();
	private static final Sheet createSheet = workbook.createSheet("TestPV");
	int rate = 1, nper = 1;
	double val = -5000;

	@Test
	public void TestPV() throws IOException {
		// 年利率10%,5期,投入20000,期初投入。5期后可获得多少？--一次终值
		createSheet.createRow(0).createCell(0).setCellFormula("PV(10%,5,0,-20000,1)");
		// 利率10%月计算复利,5年,每月投入20000,5年*12月获得多少？---年金终值
		createSheet.createRow(1).createCell(0).setCellFormula("PV(10%/12,5*12,0,-20000,1)");
		workbook.write(new FileOutputStream("e:\\TestPV.xlsx"));
	}

}
