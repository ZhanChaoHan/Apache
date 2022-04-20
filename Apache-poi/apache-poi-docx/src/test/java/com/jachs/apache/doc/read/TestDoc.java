package com.jachs.apache.doc.read;

import java.io.IOException;

import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class TestDoc {

    @Test
    public void tests () throws IOException {
        WordExtractor extractor = new WordExtractor ( TestDoc.class.getResourceAsStream ( "/doc/个人车辆租赁协议合同范本Word模板.doc" ) );

        //输出word文档所有的文本 
        System.out.println ( extractor.getText () );
        System.out.println ( extractor.getTextFromPieces () );
        System.out.println ( "页眉：" + extractor.getHeaderText () );
        System.out.println ( "页脚：" + extractor.getFooterText () );
        //输出当前word文档的元数据信息，包括作者、文档的修改时间等。 
        System.out.println ( extractor.getMetadataTextExtractor ().getText () );
        //获取各个段落的文本
        String paraTexts[] = extractor.getParagraphText ();
        for ( int i = 0 ; i < paraTexts.length ; i++ ) {
            System.out.println ( "段落 " + ( i + 1 ) + " : " + paraTexts[i] );
        }
        SummaryInformation sInfo=extractor.getSummaryInformation();
        System.out.println("作者  :\t"+sInfo.getAuthor());  
        System.out.println("字符统计  :\t"+sInfo.getCharCount());  
        System.out.println("页数 :\t"+sInfo.getPageCount());  
        System.out.println("标题 :\t"+sInfo.getTitle());  
        System.out.println("主题  :\t"+sInfo.getSubject());
        
    }
}
