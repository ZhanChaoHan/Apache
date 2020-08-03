/*
 * 文件名: TestPdfBox.java
 * 文件编号: 
 * 版权: Copyright (c) 2020, Sinosoft and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述: TODO
 * 创建人: zhanchaohan
 * 创建时间: 2020年06月22日 11:04
 * 修改人:
 * 修改时间: 2020年06月22日 11:04
 * 修改变更号: 
 * 修改内容: TODO
 */
package com.jachs.apacheapi;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

/**
 * @Title TestPdfBox
 * @Description TODO
 * @author zhanchaohan
 * @date 2020年06月22日 11:04
 * @version V1.0
 * @see
 * @since V1.0
 * 
 */
public class TestPdfBox {
    @Test
    public void readTest () throws IOException {
        int startPage = 1;
        PDDocument document = PDDocument.load ( TestPdfBox.class.getResourceAsStream ( "/pdf/英语大纲词汇（4500词）.pdf" ) );
        int endPage = null == document ? Integer.MAX_VALUE : document.getNumberOfPages ();
        PDFTextStripper stripper = new PDFTextStripper ();
        stripper.setSortByPosition ( true );
        stripper.setStartPage ( startPage );
        stripper.setEndPage ( endPage );
        System.out.println ( stripper.getText ( document ) );
    }
}
