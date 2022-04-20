package com.jachs.apache;

import org.junit.Test;

import com.jachs.apache.docx.transformation.DocToHtml;


public class TransformationTest {
	DocToHtml dth = new DocToHtml ();
	
    @Test
    public void DocToHtmlTest () throws Exception {
        //        dth.docx ( "e:\\", "index.docx", "index.html" );
    	 dth.doc( "C:\\Users\\79951\\Desktop\\a\\", "b.doc", "b.html" );
    }
    @Test
    public void DocxToHtmlTest() throws Exception {
    	 dth.docx( "C:\\Users\\79951\\Desktop\\a\\", "冲向云霄年终总结.docx", "a.html" );
    }
}
