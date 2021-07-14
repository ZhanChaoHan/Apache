package com.jachs.apache.pdf.create;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * @author zhanchaohan
 * 
 */
public class CreatePdf {
    public static void main ( String[] args ) {
        PDDocument document = null;
        try{
            document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDFont font = PDType1Font.HELVETICA_BOLD;
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            contentStream.beginText();
            contentStream.setFont(font, 20);
            contentStream.newLineAtOffset(100, 100);
            //contentStream.showText("Hello World !");
            //contentStream.newLine();
            contentStream.showText("Hello World !");
            //contentStream.showTextWithPositioning(args);
            contentStream.newLineAtOffset(0, 200);
            contentStream.setFont(font, 200);
            contentStream.showText("The individual calls to add resources such as PDResources.addFont(PDFont font) and PDResources.addXObject(PDXObject xobject, String prefix) have been replaced with PDResources.add(resource type) where resource type represents the different resource classes such as PDFont, PDAbstractPattern and so on. The add method now supports all the different type of resources available.");
            contentStream.endText();
            
            
            contentStream.moveTo(0, 0);
            contentStream.lineTo(300, 300);
            contentStream.stroke();
            //contentStream.drawLine(0, 0, 100, 100);
            contentStream.close();
            document.save("HelloWorld.pdf");
            
            System.out.println(PDRectangle.A4.getWidth());
            System.out.println(PDRectangle.A4.getHeight());
            System.out.println(PDRectangle.A4.getLowerLeftX());
            System.out.println(PDRectangle.A4.getLowerLeftY());
            System.out.println(PDRectangle.A4.getUpperRightX());
            System.out.println(PDRectangle.A4.getUpperRightY());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                document.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}
