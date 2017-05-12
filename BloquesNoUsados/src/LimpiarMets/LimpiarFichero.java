package LimpiarMets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LimpiarFichero {
	
	public static ArrayList<String>  leerFichero (String archivo,String archivo2) throws IOException
	 {
		
		String linea=null;
		String sublinea2=null;
		String sublinea=null;
		String linea2=null;;
		int size=MetodosSecundarios.contarLineas(archivo);
		
		ArrayList<String> lista_linea = new ArrayList<String>();

		FileReader f = new FileReader(archivo);
	    BufferedReader b = new BufferedReader(f);
		
		for(int i=0;i<= size-1;i++)
	  {	 int con=0;
		  linea=b.readLine();
		  if((linea.length()<91) && (linea.length()>9))
		  {lista_linea.add(linea);}
		   FileReader f2 = new FileReader(archivo2);
		    BufferedReader b2 = new BufferedReader(f2);
				
				if(linea.length()==91){
					sublinea=linea.substring(65,70);
	//System.out.println(linea);

		
	
		while  ((linea2=b2.readLine())!=null)
		{
			if ( (linea2.length()==91) )
			{    sublinea2=linea2.substring(65,70);
			   
		       
		        	if(sublinea.equals(sublinea2))
		        	{con++;
		        	   if(con==2)
		        	   { 
		        	 
		        	  lista_linea.add(linea);
		        	//  System.out.println(linea);
		     
		        	   		        	    }
		        	
		        	}
			}
			
		}
		
		
		 b2.close();	
	}
	
	}
		System.out.println("Se ha creado el archivo !!");
   
		b.close();
	
		
			return lista_linea;
	
	 }
	
	
	
	/////////////////////////////
	
	   public static  ArrayList<String>  leerFicheroFinal(ArrayList<String> fichero) throws IOException
	   {
		   String linea=null;
			String sublinea2=null;
			String sublinea=null;

			
			
			ArrayList<String> lista_linea = new ArrayList<String>();

		
			
			for(int i=0;i<= fichero.size()-1;i++)
			{
				linea=fichero.get(i);
				if(linea.length()==91)
				   {
					sublinea=linea.substring(65, 70);
					
						if(sublinea.equals(sublinea2))
						{
							System.out.println(linea);
							lista_linea.add(linea);
						}
				   }
				else{lista_linea.add(linea);}
				sublinea2=sublinea;
			}
			return lista_linea;
	   }

	   
	   
		////////////////////// METODO PARA CREAR NUEVO FICHERO 
		
	   public static void imprimir (ArrayList<String> linea){
		
		 File ff = new File(Principal.RUTAMETSREPETIDOS,MetodosSecundarios.nombraArchivo());
		 try{

			FileWriter w = new FileWriter(ff);
			
			BufferedWriter bw = new BufferedWriter(w);
			
			PrintWriter wr = new PrintWriter(bw);  
			
			bw.write(" METS:   ");
			bw.append(System.getProperty("line.separator"));
			bw.append(System.getProperty("line.separator"));
			
			for (String cadena :linea) {
				bw.write(cadena);
				 bw.newLine();	 
	              bw.append(System.getProperty("line.separator"));
			}
			wr.close();
			
			bw.close();
			
			}catch(IOException e){};
			
			 }
	   
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
