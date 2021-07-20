package com.jachs.apache.excel.create;

import java.io.OutputStream;

/****
 * 
 * @author zhanchaohan
 *
 */
public interface CreateExcelUtill {
	//写入
	public void writerExcel(OutputStream stream);
	
//	HSSFWorkbook wb = new HSSFWorkbook();
//	
//	public CreateExcelUtill () {
//        wb=new HSSFWorkbook ();
//    }
//
//    public CreateExcelUtill ( HSSFWorkbook wb ) {
//        super ();
//        this.wb = wb;
//    }
//    
//    public int getLastRowNumber(HSSFSheet ss) {
//        return ss.getLastRowNum ();
//    }
//	/****
//	 * 创建Shell页
//	 * 
//	 * @param shellName
//	 * @return
//	 */
//	public HSSFSheet createShell(String shellName) {
//		return wb.createSheet(shellName);
//	}
//
//	/****
//	 * 创建Row
//	 * 
//	 * @param sheet
//	 * @param rowNum
//	 * @return
//	 */
//	public HSSFRow createRow(HSSFSheet sheet, int rowNum) {
//		return sheet.createRow(rowNum);
//	}
//
//	/****
//	 * 创建Cell
//	 * 
//	 * @param row
//	 * @param cellNum
//	 * @param value
//	 * @return
//	 */
//	public HSSFCell createCell(HSSFRow row, int cellNum, CellStyle style, boolean value) {
//		HSSFCell cell = row.createCell(cellNum);
//		if (style != null)
//			cell.setCellStyle(style);
//		cell.setCellValue(value);
//		return cell;
//	}
//
//	public HSSFCell createCell(HSSFRow row, int cellNum, CellStyle style, Calendar value) {
//		HSSFCell cell = row.createCell(cellNum);
//		if (style != null)
//			cell.setCellStyle(style);
//		cell.setCellValue(value);
//		return cell;
//	}
//
//	public HSSFCell createCell(HSSFRow row, int cellNum, CellStyle style, Date value) {
//		HSSFCell cell = row.createCell(cellNum);
//		if (style != null)
//			cell.setCellStyle(style);
//		cell.setCellValue(value);
//		return cell;
//	}
//
//	public HSSFCell createCell(HSSFRow row, int cellNum, CellStyle style, double value) {
//		HSSFCell cell = row.createCell(cellNum);
//		if (style != null)
//			cell.setCellStyle(style);
//		cell.setCellValue(value);
//		return cell;
//	}
//
//	public HSSFCell createCell(HSSFRow row, int cellNum, CellStyle style, RichTextString value) {
//		HSSFCell cell = row.createCell(cellNum);
//		if (style != null)
//			cell.setCellStyle(style);
//		cell.setCellValue(value);
//		return cell;
//	}
//
//	public HSSFCell createCell(HSSFRow row, int cellNum, CellStyle style, String value) {
//		HSSFCell cell = row.createCell(cellNum);
//		if (style != null)
//			cell.setCellStyle(style);
//		cell.setCellValue(value);
//		return cell;
//	}
//
//	/****
//	 * 写入函数
//	 * 
//	 * @param hSSFCell
//	 * @param formula可以是PI()参考公式
//	 */
//	public void setCellFormula(HSSFCell hSSFCell, String formula) {
//		hSSFCell.setCellFormula(formula);
//	}
//
//	/**
//	 * 
//	 * 设置单元格的边框（细）且为红色
//	 * 
//	 * @param workbook
//	 * 
//	 * @param cellnum
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public HSSFCellStyle createCellStyle() {
//		HSSFCellStyle style = wb.createCellStyle();
//		// 设置上下左右四个边框宽度
//		style.setBorderTop(BorderStyle.THIN);
//		style.setBorderBottom(BorderStyle.THIN);
//		style.setBorderLeft(BorderStyle.THIN);
//		style.setBorderRight(BorderStyle.THIN);
//		// 设置上下左右四个边框颜色
//		style.setTopBorderColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
//		style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
//		style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
//		style.setRightBorderColor(HSSFColor.HSSFColorPredefined.ORANGE.getIndex());
//		// 设置背景颜色
//		style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
//		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//		// 设置字体格式
//		HSSFFont font = wb.createFont();
//		font.setFontName("幼圆");
//		font.setFontHeightInPoints((short) 9);
//		font.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
//		font.setBold(true);// 加粗或不加
//		font.setItalic(true);
//		font.setStrikeout(true);
//		font.setUnderline((byte) 1);
//		// 将字体格式设置到HSSFCellStyle上
//		style.setFont(font);
//		// 设置单元格居中方式
//		style.setAlignment(HorizontalAlignment.CENTER);// 水平居中
//
//		return style;
//	}
//
//
//	/****
//	 * 写入
//	 * 
//	 * @param path
//	 * @throws IOException
//	 */
//	public void writerExcel(String path) throws IOException {
//		FileOutputStream fout = new FileOutputStream(path);
//		wb.write(fout);
//		wb.close();
//	}

}
