package SumarTamano;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.text.PlainDocument;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;



public class Sumar {
	
	
	public static void main(String[] args) throws IOException {
		
		
		 String ruta="C:/Users/abana62/Desktop/LOTE_0/6245/";
	double sum=suma(ruta);
		
		System.out.println("La suma del pdfs es :"+sum);
	
	}
	
	
	public static double suma(String ruta) throws IOException
	{
		double sum=0;
		String pdf="pdf";


		File fichero = new File(ruta);
		PlainDocument pd = null;

		
		String linea=null;
		String sublinea;
	
		
		int nLineas=calcularLineas.obtenerNumeroFicheros(ruta);
		// System.out.println(nLineas);
	
				/////////////////////////
				
			     String files;
		         File folder = new File(ruta);
		          File[] listOfFiles = folder.listFiles(); 
		 
		        for (int i = 0; i < listOfFiles.length; i++)         {

		        if (listOfFiles[i].isFile())             {
		            files = listOfFiles[i].getName();
		          
		            sublinea=files.substring(files.length()-3);
		            if(sublinea.equalsIgnoreCase(pdf))
		            {
		            	String rutapdf=ruta+files;
		            sum=sum+CalcularTamano.calcularPeso(rutapdf);
		            }
		            
		            
			}
		}
		
		
		return sum;
		
		
	}
	
	
          public static void leeFfichero(String ruta)
        {
         

          String files;
         File folder = new File(ruta);
          File[] listOfFiles = folder.listFiles(); 
 
        for (int i = 0; i < listOfFiles.length; i++)         {

        if (listOfFiles[i].isFile())             {
            files = listOfFiles[i].getName();
           // System.out.println(files);
        }
    }
}

}
