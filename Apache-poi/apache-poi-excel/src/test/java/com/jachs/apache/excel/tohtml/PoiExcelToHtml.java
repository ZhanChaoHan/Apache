package com.jachs.apache.excel.tohtml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.usermodel.Picture;
import org.w3c.dom.Document;
 
public class PoiExcelToHtml {
	/***
	 * 
	 * @param sourcePath 文件路径
	 * @param exportPath 转换html路径
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	 public static void PoiExcelToHtml(String sourcePath,String exportPath) throws IOException, ParserConfigurationException, TransformerException {
			 InputStream input=new FileInputStream(sourcePath);
			 HSSFWorkbook excelBook=new HSSFWorkbook(input);
			 ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter (DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument() );
			 excelToHtmlConverter.processWorkbook(excelBook);
			 List pics = excelBook.getAllPictures();
			   if (pics != null) {
			     for (int i = 0; i < pics.size(); i++) {
			       Picture pic = (Picture) pics.get (i);
			       try {
			         pic.writeImageContent (new FileOutputStream (sourcePath + pic.suggestFullFileName() ) );
			       } catch (FileNotFoundException e) {
			         e.printStackTrace();
			       }
			     }
			   }
			   Document htmlDocument =excelToHtmlConverter.getDocument();
			   ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			   DOMSource domSource = new DOMSource (htmlDocument);
			   StreamResult streamResult = new StreamResult (outStream);
			   TransformerFactory tf = TransformerFactory.newInstance();
			   Transformer serializer = tf.newTransformer();
			   serializer.setOutputProperty (OutputKeys.ENCODING, "utf-8");
			   serializer.setOutputProperty (OutputKeys.INDENT, "yes");
			   serializer.setOutputProperty (OutputKeys.METHOD, "html");
			   serializer.transform (domSource, streamResult);
			   outStream.close();
			   String content = new String (outStream.toByteArray() );
			   FileUtils.writeStringToFile(new File (exportPath), content, "utf-8");
	 }
}