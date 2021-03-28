package com.jachs.apacheapi.pdfbox.create;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;


/***
 * 
 * @author zhanchaohan
 *@see https://pdfbox.apache.org/docs/2.0.13/javadocs/
 */
public class PDPageDemo {
	public   void initPDPage(PDPage pg) {
		List<PDAnnotation> paList=new ArrayList<PDAnnotation>();
		
		PDAnnotation pa=new PDAnnotationPopup();
		PDAnnotation pa1=new PDAnnotationWidget();
		PDAnnotation pa2=new PDAnnotationUnknown(null);
		PDAnnotation pa3=new PDAnnotationMarkup();
		PDAnnotation pa4=new PDAnnotationLine();
		PDAnnotation pa5=new PDAnnotationLink();
		PDAnnotation pa6=new PDAnnotationFileAttachment();
		PDAnnotation pa7=new PDAnnotationRubberStamp();
		PDAnnotation pa8=new PDAnnotationText();
		
		pg.setAnnotations(paList);
	}
}
