package com.jachs.apache.pdfbox;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.junit.Test;

/***
 * pdf转换html
 * @author zhanchaohan
 *
 */
public class PdfToHtml {
    @Test
    public void pdfToHtmlTest()  {
        String outputPath = "D:\\HashMap.html";
        byte[] bytes = getBytes("C:\\Users\\79951\\Desktop\\a\\保密协议-最新.pdf");
//        try() 写在()里面会自动关闭流
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outputPath)),"UTF-8"));){
            //加载PDF文档
            PDDocument document = PDDocument.load(bytes);
            PDFDomTree pdfDomTree = new PDFDomTree();
            pdfDomTree.writeText(document,out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    将文件转换为byte数组
     */
    private byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
