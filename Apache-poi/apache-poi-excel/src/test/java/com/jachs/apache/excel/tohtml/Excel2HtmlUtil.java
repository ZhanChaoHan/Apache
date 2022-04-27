package com.jachs.apache.excel.tohtml;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Excel2HtmlUtil {
    /**
     * @param filePath    excel源文件文件的路径
     * @param htmlPositon 生成的html文件的路径
     * @param isWithStyle 是否需要表格样式 包含 字体 颜色 边框 对齐方式
     * @param type        文件的后缀，比如: xlsx
     * @param htmlTitle   生成的html文件中meta里的title
     */
    public static String readExcelToHtml(String filePath, String htmlPositon, boolean isWithStyle, String type, String htmlTitle) {
        InputStream is = null;
        String htmlExcel = null;
        Map<String, String> stylemap = new HashMap<String, String>();
        try {
            if ("csv".equalsIgnoreCase(type)) {
                htmlExcel = getCSVInfo(filePath);
                writeFile1(htmlExcel, htmlPositon, stylemap, htmlTitle);
            } else {
                File sourcefile = new File(filePath);
                is = new FileInputStream(sourcefile);
                Workbook wb = WorkbookFactory.create(is);
                if (wb instanceof XSSFWorkbook) {//03版excel处理方法
                    XSSFWorkbook xWb = (XSSFWorkbook) wb;
                    htmlExcel = getExcelInfo(xWb, isWithStyle, stylemap);
                } else if (wb instanceof HSSFWorkbook) {//07及10版以后的excel处理方法
                    HSSFWorkbook hWb = (HSSFWorkbook) wb;
                    htmlExcel = getExcelInfo(hWb, isWithStyle, stylemap);
                }
                writeFile(htmlExcel, htmlPositon, stylemap, htmlTitle);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("文件被损坏或不能打开，无法预览");
            //throw new Exception("文件被损坏或不能打开，无法预览");
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return htmlPositon;
    }

    private static void getcscvvalue(BufferedReader reader, List col, String oldvalue, List list) {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",", -1);
                boolean isbreak = false;
                for (int i = 0; i < item.length; i++) {
                    String value = item[i];
                    if (value.endsWith("\"")) {
                        value = oldvalue + value;
                        col.add(value);
                    } else if (item.length == 1) {
                        value = oldvalue + value;
                        getcscvvalue(reader, col, value, list);
                        isbreak = true;
                    } else if (value.startsWith("\"")) {
                        getcscvvalue(reader, col, value, list);
                        isbreak = true;
                    } else {
                        col.add(value);
                    }
                }
                if (!isbreak) {
                    list.add(col);
                    col = new ArrayList();
                }
            }
        } catch (IOException e) {
        }
    }

    private static String getCSVInfo(String filePath) {
        StringBuffer sb = new StringBuffer();
        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream(filePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            List list = new ArrayList();
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                List col = new ArrayList();
                for (int i = 0; i < item.length; i++) {
                    String value = item[i];
                    if (value.startsWith("\"")) {
                        getcscvvalue(reader, col, value, list);
                    } else {
                        col.add(value);
                    }
                }
                list.add(col);
            }
            sb.append("<table>");
            for (int i = 0; i < list.size(); i++) {
                List col = (List) list.get(i);
                if (col == null || col.size() == 0) {
                    sb.append("<tr><td ></td></tr>");
                }
                sb.append("<tr>");
                for (int j = 0; j < col.size(); j++) {
                    String value = (String) col.get(j);
                    if (value == null || "".equals(value)) {
                        sb.append("<td> </td>");
                        continue;
                    } else {
                        sb.append("<td>" + value + "</td>");
                    }
                }
                sb.append("</tr>");
            }
            sb.append("</table>");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static String getExcelInfo(Workbook wb, boolean isWithStyle, Map<String, String> stylemap) {
        StringBuffer sb = new StringBuffer();
        StringBuffer ulsb = new StringBuffer();
        ulsb.append("<ul>");
        int num = wb.getNumberOfSheets();
        for (int i = 0; i < num; i++) {
            Sheet sheet = wb.getSheetAt(i);// 获取第一个Sheet的内容
            String sheetName = sheet.getSheetName();
            if (i == 0) {
                ulsb.append("<li id='li_" + i + "' class='cur' οnclick='changetab(" + i + ")'>" + sheetName + "</li>");
            } else {
                ulsb.append("<li id='li_" + i + "' οnclick='changetab(" + i + ")'>" + sheetName + "</li>");
            }
            int lastRowNum = sheet.getLastRowNum();
            Map<String, String> map[] = getRowSpanColSpanMap(sheet);
            Map<String, String> map1[] = getRowSpanColSpanMap(sheet);
            sb.append("<table id='table_" + i + "' ");
            if (i == 0) {
                sb.append("class='block'");
            }
            sb.append(">");
            Row row = null; // 兼容
            Cell cell = null; // 兼容

            int maxRowNum = 0;
            int maxColNum = 0;
            for (int rowNum = sheet.getFirstRowNum(); rowNum <= lastRowNum; rowNum++) {
                row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }
                int lastColNum = row.getLastCellNum();
                for (int colNum = 0; colNum < lastColNum; colNum++) {
                    cell = row.getCell(colNum);
                    if (cell == null) { // 特殊情况 空白的单元格会返回null
                        continue;
                    }
                    String stringValue = getCellValue1(cell);
                    if (map1[0].containsKey(rowNum + "," + colNum)) {
                        map1[0].remove(rowNum + "," + colNum);
                        if (maxRowNum < rowNum) {
                            maxRowNum = rowNum;
                        }
                        if (maxColNum < colNum) {
                            maxColNum = colNum;
                        }
                    } else if (map1[1].containsKey(rowNum + "," + colNum)) {
                        map1[1].remove(rowNum + "," + colNum);
                        if (maxRowNum < rowNum) {
                            maxRowNum = rowNum;
                        }
                        if (maxColNum < colNum) {
                            maxColNum = colNum;
                        }
                        continue;
                    }
                    if (stringValue == null || "".equals(stringValue.trim())) {
                        continue;
                    } else {
                        if (maxRowNum < rowNum) {
                            maxRowNum = rowNum;
                        }
                        if (maxColNum < colNum) {
                            maxColNum = colNum;
                        }
                    }
                }
            }
            for (int rowNum = sheet.getFirstRowNum(); rowNum <= maxRowNum; rowNum++) {
                row = sheet.getRow(rowNum);
                if (row == null) {
                    sb.append("<tr><td ></td></tr>");
                    continue;
                }
                sb.append("<tr>");
                int lastColNum = row.getLastCellNum();
                for (int colNum = 0; colNum <= maxColNum; colNum++) {
                    cell = row.getCell(colNum);
                    if (cell == null) { // 特殊情况 空白的单元格会返回null
                        sb.append("<td> </td>");
                        continue;
                    }
                    String stringValue = getCellValue(cell);
                    if (map[0].containsKey(rowNum + "," + colNum)) {
                        String pointString = map[0].get(rowNum + "," + colNum);
                        map[0].remove(rowNum + "," + colNum);
                        int bottomeRow = Integer.valueOf(pointString.split(",")[0]);
                        int bottomeCol = Integer.valueOf(pointString.split(",")[1]);
                        int rowSpan = bottomeRow - rowNum + 1;
                        int colSpan = bottomeCol - colNum + 1;
                        sb.append("<td rowspan= '" + rowSpan + "' colspan= '" + colSpan + "' ");
                    } else if (map[1].containsKey(rowNum + "," + colNum)) {
                        map[1].remove(rowNum + "," + colNum);
                        continue;
                    } else {
                        sb.append("<td ");
                    }

                    // 判断是否需要样式
                    if (isWithStyle) {
                        dealExcelStyle(wb, sheet, cell, sb, stylemap);// 处理单元格样式
                    }

                    sb.append("><nobr>");
                    if (stringValue == null || "".equals(stringValue.trim())) {
                        sb.append("   ");
                    } else {
                        // 将ascii码为160的空格转换为html下的空格（ ）
                        sb.append(stringValue.replace(String.valueOf((char) 160), " "));
                    }
                    sb.append("</nobr></td>");
                }
                sb.append("</tr>");
            }
            sb.append("</table>");
        }
        ulsb.append("</ul>");
        return ulsb.toString() + sb.toString();
    }


    private static Map<String, String>[] getRowSpanColSpanMap(Sheet sheet) {
        Map<String, String> map0 = new HashMap<String, String>();
        Map<String, String> map1 = new HashMap<String, String>();
        int mergedNum = sheet.getNumMergedRegions();
        CellRangeAddress range = null;
        for (int i = 0; i < mergedNum; i++) {
            range = sheet.getMergedRegion(i);
            int topRow = range.getFirstRow();
            int topCol = range.getFirstColumn();
            int bottomRow = range.getLastRow();
            int bottomCol = range.getLastColumn();
            map0.put(topRow + "," + topCol, bottomRow + "," + bottomCol);
            // System.out.println(topRow + "," + topCol + "," + bottomRow + "," +
            // bottomCol);
            int tempRow = topRow;
            while (tempRow <= bottomRow) {
                int tempCol = topCol;
                while (tempCol <= bottomCol) {
                    map1.put(tempRow + "," + tempCol, "");
                    tempCol++;
                }
                tempRow++;
            }
            map1.remove(topRow + "," + topCol);
        }
        Map[] map = {map0, map1};
        return map;
    }

    private static String getCellValue1(Cell cell) {
        String result = new String();
        switch (cell.getCellType()) {
            case NUMERIC:// 数字类型
                result = "1";
                break;
            case STRING:// String类型
                result = "1";
                break;
            case BLANK:
                result = "";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }

    /**
     * 获取表格单元格Cell内容
     *
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case NUMERIC:// 数字类型
                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                    result = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();
                    CellStyle style = cell.getCellStyle();
                    DecimalFormat format = new DecimalFormat();
                    String temp = style.getDataFormatString();
                    // 单元格设置成常规
                    if (temp.equals("General")) {
                        format.applyPattern("#");
                    }
                    result = format.format(value);
                }
                break;
            case STRING:// String类型
                result = cell.getRichStringCellValue().toString();
                break;
            case BLANK:
                result = "";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }

    /**
     * 处理表格样式
     *
     * @param wb
     * @param sheet
     * @param sb
     */
    private static void dealExcelStyle(Workbook wb, Sheet sheet, Cell cell, StringBuffer sb, Map<String, String> stylemap) {
        CellStyle cellStyle = cell.getCellStyle();
        if (cellStyle != null) {
            HorizontalAlignment alignment = cellStyle.getAlignment();
            // sb.append("align='" + convertAlignToHtml(alignment) + "' ");//单元格内容的水平对齐方式
            VerticalAlignment verticalAlignment = cellStyle.getVerticalAlignment();
            String _style = "vertical-align:" + convertVerticalAlignToHtml(verticalAlignment) + ";";
            if (wb instanceof XSSFWorkbook) {

                XSSFFont xf = ((XSSFCellStyle) cellStyle).getFont();
                //short boldWeight = xf.getBoldweight();
                short boldWeight = 400;
                String align = convertAlignToHtml(alignment);
                int columnWidth = sheet.getColumnWidth(cell.getColumnIndex());
                _style += "font-weight:" + boldWeight + ";font-size: " + xf.getFontHeight() / 2 + "%;width:" + columnWidth + "px;text-align:" + align + ";";

                XSSFColor xc = xf.getXSSFColor();
                if (xc != null && !"".equals(xc)) {
                    _style += "color:#" + xc.getARGBHex().substring(2) + ";";
                }

                XSSFColor bgColor = (XSSFColor) cellStyle.getFillForegroundColorColor();
                if (bgColor != null && !"".equals(bgColor)) {
                    _style += "background-color:#" + bgColor.getARGBHex().substring(2) + ";"; // 背景颜色
                }
                _style += getBorderStyle(0, cellStyle.getBorderTop().getCode(), ((XSSFCellStyle) cellStyle).getTopBorderXSSFColor());
                _style += getBorderStyle(1, cellStyle.getBorderRight().getCode(), ((XSSFCellStyle) cellStyle).getRightBorderXSSFColor());
                _style += getBorderStyle(2, cellStyle.getBorderBottom().getCode(), ((XSSFCellStyle) cellStyle).getBottomBorderXSSFColor());
                _style += getBorderStyle(3, cellStyle.getBorderLeft().getCode(), ((XSSFCellStyle) cellStyle).getLeftBorderXSSFColor());
            } else if (wb instanceof HSSFWorkbook) {

                HSSFFont hf = ((HSSFCellStyle) cellStyle).getFont(wb);
                short boldWeight = hf.getFontHeight();
                short fontColor = hf.getColor();
                HSSFPalette palette = ((HSSFWorkbook) wb).getCustomPalette(); // 类HSSFPalette用于求的颜色的国际标准形式
                HSSFColor hc = palette.getColor(fontColor);
                String align = convertAlignToHtml(alignment);
                int columnWidth = sheet.getColumnWidth(cell.getColumnIndex());
                _style += "font-weight:" + boldWeight + ";font-size: " + hf.getFontHeight() / 2 + "%;text-align:" + align + ";width:" + columnWidth + "px;";
                String fontColorStr = convertToStardColor(hc);
                if (fontColorStr != null && !"".equals(fontColorStr.trim())) {
                    _style += "color:" + fontColorStr + ";"; // 字体颜色
                }
                short bgColor = cellStyle.getFillForegroundColor();
                hc = palette.getColor(bgColor);
                String bgColorStr = convertToStardColor(hc);
                if (bgColorStr != null && !"".equals(bgColorStr.trim())) {
                    _style += "background-color:" + bgColorStr + ";"; // 背景颜色
                }
                _style += getBorderStyle(palette, 0, cellStyle.getBorderTop().getCode(), cellStyle.getTopBorderColor());
                _style += getBorderStyle(palette, 1, cellStyle.getBorderRight().getCode(), cellStyle.getRightBorderColor());
                _style += getBorderStyle(palette, 3, cellStyle.getBorderLeft().getCode(), cellStyle.getLeftBorderColor());
                _style += getBorderStyle(palette, 2, cellStyle.getBorderBottom().getCode(), cellStyle.getBottomBorderColor());
            }
            String calssname = "";
            if (!stylemap.containsKey(_style)) {
                int count = stylemap.size();
                calssname = "td" + count;
                stylemap.put(_style, calssname);
            } else {
                calssname = stylemap.get(_style);
            }
            if (!"".equals(calssname)) {
                sb.append("class='" + calssname + "'");
            }
        }
    }

    /**
     * 单元格内容的水平对齐方式
     *
     * @param alignment
     * @return
     */
    private static String convertAlignToHtml(HorizontalAlignment alignment) {
        String align = "center";
        switch (alignment) {
            case LEFT:
                align = "left";
                break;
            case CENTER:
                align = "center";
                break;
            case RIGHT:
                align = "right";
                break;
            default:
                break;
        }
        return align;
    }

    /**
     * 单元格中内容的垂直排列方式
     *
     * @param verticalAlignment
     * @return
     */
    private static String convertVerticalAlignToHtml(VerticalAlignment verticalAlignment) {

        String valign = "middle";
        switch (verticalAlignment) {
            case BOTTOM:
                valign = "bottom";
                break;
            case CENTER:
                valign = "middle";
                break;
            case TOP:
                valign = "top";
                break;
            default:
                break;
        }
        return valign;
    }

    private static String convertToStardColor(HSSFColor hc) {
        StringBuffer sb = new StringBuffer("");
        if (hc != null) {
            if (HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex() == hc.getIndex()) {
                return null;
            }
            sb.append("#");
            for (int i = 0; i < hc.getTriplet().length; i++) {
                sb.append(fillWithZero(Integer.toHexString(hc.getTriplet()[i])));
            }
        }
        return sb.toString();
    }

    private static String fillWithZero(String str) {
        if (str != null && str.length() < 2) {
            return "0" + str;
        }
        return str;
    }

    static String[] bordesr = {"border-top:", "border-right:", "border-bottom:", "border-left:"};
    static String[] borderStyles = {"solid ", "solid ", "solid ", "solid ", "solid ", "solid ", "solid ", "solid ",
            "solid ", "solid", "solid", "solid", "solid", "solid"};

    private static String getBorderStyle(HSSFPalette palette, int b, short s, short t) {
        if (s == 0)
            return bordesr[b] + borderStyles[s] + "#d0d7e5 1px;";
        ;
        String borderColorStr = convertToStardColor(palette.getColor(t));
        borderColorStr = borderColorStr == null || borderColorStr.length() < 1 ? "#000000" : borderColorStr;
        return bordesr[b] + borderStyles[s] + borderColorStr + " 1px;";
    }

    private static String getBorderStyle(int b, short s, XSSFColor xc) {
        if (s == 0)
            return bordesr[b] + borderStyles[s] + "#d0d7e5 1px;";
        if (xc != null && !"".equals(xc)) {
            String borderColorStr = xc.getARGBHex();// t.getARGBHex();
            borderColorStr = borderColorStr == null || borderColorStr.length() < 1 ? "#000000"
                    : borderColorStr.substring(2);
            return bordesr[b] + borderStyles[s] + borderColorStr + " 1px;";
        }
        return "";
    }

    /*
     * @param content 生成的excel表格标签
     *
     * @param htmlPath 生成的html文件地址
     */
    private static void writeFile(String content, String htmlPath, Map<String, String> stylemap, String name) {
        File file2 = new File(htmlPath);
        StringBuilder sb = new StringBuilder();
        try {
            file2.createNewFile();// 创建文件
            sb.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><title>" + name + "</title><style type=\"text/css\">");
            sb.append("ul{list-style: none;max-width: calc(100%);padding: 0px;margin: 0px;overflow-x: scroll;white-space: nowrap;} ul li{padding: 3px 5px;display: inline-block;border-right: 1px solid #768893;} ul li.cur{color: #F59C25;} table{border-collapse:collapse;display:none;width:100%;} table.block{display: block;}");
            for (Map.Entry<String, String> entry : stylemap.entrySet()) {
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                sb.append(" ." + mapValue + "{" + mapKey + "}");
            }
            sb.append("</style><script>");
            sb.append("function changetab(i){var block = document.getElementsByClassName(\"block\");block[0].className = block[0].className.replace(\"block\",\"\");var cur = document.getElementsByClassName(\"cur\");cur[0].className = cur[0].className.replace(\"cur\",\"\");var curli = document.getElementById(\"li_\"+i);curli.className += ' cur';var curtable = document.getElementById(\"table_\"+i);curtable.className=' block';}");
            sb.append("</script></head><body>");
            sb.append("<div>");
            sb.append(content);
            sb.append("</div>");
            sb.append("</body></html>");
            FileUtils.write(file2, sb.toString(), "UTF-8");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void writeFile1(String content, String htmlPath, Map<String, String> stylemap, String name) {
        File file2 = new File(htmlPath);
        StringBuilder sb = new StringBuilder();
        try {
            file2.createNewFile();// 创建文件
            sb.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><title>" + name + "</title><style type=\"text/css\">");
            sb.append("ul{list-style: none;max-width: calc(100%);padding: 0px;margin: 0px;overflow-x: scroll;white-space: nowrap;} ul li{padding: 3px 5px;display: inline-block;border-right: 1px solid #768893;} ul li.cur{color: #F59C25;} table{border-collapse:collapse;width:100%;} td{border: solid #000000 1px; min-width: 200px;}");
            sb.append("</style></head><body>");
            sb.append("<div>");
            sb.append(content);
            sb.append("</div>");
            sb.append("</body></html>");
            FileUtils.write(file2, sb.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

