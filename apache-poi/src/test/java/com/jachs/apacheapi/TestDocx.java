package com.jachs.apacheapi;

import org.junit.Test;

import com.jachs.apache.docx.read.DocToHtml;


public class TestDocx {
    @Test
    public void DocToHtmlTest () throws Exception {
        DocToHtml dth = new DocToHtml ();
        //        dth.docx ( "e:\\", "index.docx", "index.html" );
        dth.dox( "e:\\", "index.doc", "index.html" );
    }
}
