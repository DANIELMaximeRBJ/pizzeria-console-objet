package fr.pizzeria.service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;




public class PDFgenerateur {
	public static final ResourceBundle rs = ResourceBundle.getBundle("conf");
	public static final String path = rs.getString("path.absolute");
	static Document document = new Document();
	
	public void init() throws DocumentException, IOException {
		 
		 
		 try
		 {
			 PdfWriter.getInstance(document, new FileOutputStream(path));
			 
			 document.open();
		 }
		 catch(DocumentException e)
		 {
			e.printStackTrace();
		 }
	 }
	
 public void text(String o) throws DocumentException, IOException {
	 
	 try
	 {		 
		 document.add(new Paragraph(o));
	 }
	 catch(DocumentException e)
	 {
		e.printStackTrace();
	 }

 }
 
 public void close() throws DocumentException, IOException {
	 document.close();
	
 }

}
 
