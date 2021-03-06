package com.jachs.apache.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class TestPdfBox {
    @Test
    public void readTest () throws IOException {
        int startPage = 1;
        PDDocument document = PDDocument.load ( TestPdfBox.class.getResourceAsStream ( "/pdf/vocabulary.pdf" ) );
        int endPage = null == document ? Integer.MAX_VALUE : document.getNumberOfPages ();
        PDFTextStripper stripper = new PDFTextStripper ();
        stripper.setSortByPosition ( true );
        stripper.setStartPage ( startPage );
        stripper.setEndPage ( endPage );
        System.out.println ( stripper.getText ( document ) );
    }
}
