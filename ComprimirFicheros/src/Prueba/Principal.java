package Prueba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class Principal {
	
	public static void main(String[] args) throws IOException, DocumentException {
//		try {
//			System.out.println("Reduciendo PDF...");
//			new ResizeImage().manipulatePdf("C:/Users/ABANA53/Desktop/PDF/4_140734.pdf", "C:/Users/ABANA53/Desktop/PDF/compress4_140734.pdf");
//			System.out.println("Compresión finalizada.");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		PdfReader reader = new PdfReader(new FileInputStream("C:/Users/ABANA53/Desktop/PDF/4_1666.pdf"));
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:/Users/ABANA53/Desktop/PDF/compress4_1666.pdf"));
		int total = reader.getNumberOfPages() + 1;
		for ( int i=1; i<total; i++) {
		   reader.setPageContent(i, reader.getPageContent(i));
		}
		stamper.setFullCompression();
		stamper.close();
		
		
		//Prueba
//		PdfReader reader = new PdfReader(new FileInputStream("C:/Users/ABANA53/Desktop/PDF/4_1666.pdf"));
//		
//		Document document = new Document(reader.getPageSizeWithRotation(1));
//
//		PdfCopy writer = new PdfCopy(document, new FileOutputStream("C:/Users/ABANA53/Desktop/PDF/compress4_1666.pdf"));
//
//		document.open();
//
//		int i = 0;
//		PdfImportedPage page = writer.getImportedPage(reader, ++i);
//
//		writer.setFullCompression();
//
//		writer.addPage(page);
//
//		document.close();
//
//		writer.close();


	}
}
