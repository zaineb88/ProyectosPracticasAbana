package SumarTamano;

import java.io.File;
import java.io.IOException;

import javax.swing.text.PlainDocument;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class calcularLineas {

	public static int obtenerNumeroFicheros (String ruta)
	{
		int numFicheros = 0;
		File directorio = new File(ruta);
		
		if(directorio.exists())
		{
			File[] lista_ficheros = directorio.listFiles();
			if (lista_ficheros != null)
			{
				for(int i = 0; i < lista_ficheros.length; i++)
				{
					if(lista_ficheros[i].isDirectory())
					{
						int num = obtenerNumeroFicheros(lista_ficheros[i].getAbsolutePath());
						numFicheros += num;
					}
					else if(lista_ficheros[i].isFile())
					{
						numFicheros++;
					}
				}
			}
		}
		else
		{
			System.out.println("ERROR: Ruta de directorio incorrecta");
		}
		
		return numFicheros;
	}

	
	//////////////////////////////////////////
	
	public static int lineasSimples(String ruta) throws IOException
	{
		int res=0;
		String pdf="pdf";
		String xml="xml";
        int  sumXML=0;
        int sumPDF=0;
		File fichero = new File(ruta);
		PlainDocument pd = null;

		
		String linea=null;
		String sublinea;
	
		
		int nLineas=calcularLineas.obtenerNumeroFicheros(ruta);
		
	
				/////////////////////////
				
			     String files;
		         File folder = new File(ruta);
		          File[] listOfFiles = folder.listFiles(); 
		 
		        for (int i = 0; i < listOfFiles.length; i++)         {

		        if (listOfFiles[i].isFile())             {
		            files = listOfFiles[i].getName();
		          
		            sublinea=files.substring(files.length()-3);
		            if(sublinea.equalsIgnoreCase(xml))
		            {
		            	sumXML=sumXML+1;
		            	
		            }
		            else{sumPDF=sumPDF+1;}
		            
		            
			        }
		    }
		if(sumPDF==sumXML){res=nLineas/2;}
		
		else{res=0;}
		
		return res;
		
		
	}
	
	
	public static int lineasMets(String ruta) throws IOException
	{
		int res=0;
		String pdf="pdf";
        int sumPDF=0;

		String sublinea;
	
		
		int nLineas=calcularLineas.obtenerNumeroFicheros(ruta);
		int simples= calcularLineas.lineasSimples(ruta);
	
		
		if(simples != (nLineas/2))
		{
			
				     String files;
		         File folder = new File(ruta);
		          File[] listOfFiles = folder.listFiles(); 
		 
		        for (int i = 0; i < listOfFiles.length; i++)         {

		        if (listOfFiles[i].isFile())             {
		            files = listOfFiles[i].getName();
		          
		            sublinea=files.substring(files.length()-3);
		            if(sublinea.equalsIgnoreCase(pdf))
		            {
		            	sumPDF=sumPDF+1;
		            	
		            }
		            
		    }
		}
	
		  res=nLineas-sumPDF;
	}	else{res=0;}
		
		return res;
}
	

	public static int paginas(String ruta) throws IOException
	{
		int res=0;
		String pdf="pdf";
        int sumPDF=0;
      int paginas=0;
		String sublinea;
		int contar=0;
	
		
		int nLineas=calcularLineas.obtenerNumeroFicheros(ruta);
		int simples= calcularLineas.lineasSimples(ruta);

		
	
			
				     String files;
		         File folder = new File(ruta);
		          File[] listOfFiles = folder.listFiles(); 
		 
		        for (int i = 0; i < listOfFiles.length; i++)         {

		        if (listOfFiles[i].isFile())             {
		            files = listOfFiles[i].getName();
		          
		            sublinea=files.substring(files.length()-3);
		            
		            if(sublinea.equalsIgnoreCase(pdf))
		            {
		            	sumPDF=sumPDF+1;
		            
		            	contar=obtenerNumeroPaginas(ruta+files);
		          
		            	
		          
		            	paginas=paginas+contar;
		            }
		            
		    }
		}
	
		  res=(paginas*2)-sumPDF;
		
		
		return res;
}
	
	


	public static int obtenerNumeroPaginas (String rutaFichero){
		int numPag = 0;
		
			File fichero = new File(rutaFichero);
			PDDocument pd = null;
			
			try {
				pd = PDDocument.load(fichero);
				
				numPag = pd.getNumberOfPages();
			//	System.out.println(numPag);
			} catch (InvalidPasswordException e) {
		
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} finally{
				try {
					pd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		return numPag;
	}
}
