package com.jachs.apache.docx.read;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class TestDocx {
    @Test
    public void tests () throws IOException, OpenXML4JException {
        XWPFDocument doc = new XWPFDocument ( TestDocx.class.getResourceAsStream ( "/docx/冲向云霄年终总结.docx" ) );
        
    }
}
