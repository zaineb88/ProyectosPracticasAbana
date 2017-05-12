package LimpiarMets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopiarArchivo {
	

	/////////////////METODO PARA COPIAR UN ARCHIVO
	
	public static String copiaArchivo (String copia) throws IOException 
	{	
		String archivoCopiado= null;
		String linea = null;
		archivoCopiado = copia;
		String ruta=Principal.RUTACOPIAARCHIVO;
		
		File ff = new File(ruta,"copia de archivo.txt");
		  
		FileReader f = new FileReader(copia);
	    BufferedReader b = new BufferedReader(f);
		
	    FileWriter w = new FileWriter(ff);
		BufferedWriter bw = new BufferedWriter(w);
		PrintWriter wr = new PrintWriter(bw); 
		 try {
			
			 while  ((linea=b.readLine())!=null)
				{
					bw.write(linea);
					 bw.newLine();
				}
			
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		      return archivoCopiado;
	}

}
