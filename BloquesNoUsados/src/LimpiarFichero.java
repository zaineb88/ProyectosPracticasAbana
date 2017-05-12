import java.awt.List;
import java.awt.ScrollPaneAdjustable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LimpiarFichero {
	
	 static int index=0;
	
	public static void main(String[] args) throws IOException
	{
		 
	
		//String ax = JOptionPane.showInputDialog("Ingrese la ruta del archivo: ");
		//JOptionPane.showMessageDialog(null, "La ruta  ingresad es: "+ax);
		//String ax = JOptionPane.showInputDialog("Ingrese la ruta del nuevo archivo: ");
				//JOptionPane.showMessageDialog(null, "La ruta  ingresad es: "+ax);
		
		
		ArrayList<String> linea=leerFichero("C:/Users/ABANA55/Desktop/Id_Bloques_No_Usados_1943.txt","C:/Users/ABANA55/Desktop/Id_Bloques_No_Usados_1943 - copia.txt");
		
	   imprimir(linea);
	 //  String archivo ="C:/Users/ABANA55/Desktop/Id_Bloques_No_Usados_1943.txt";
	//  int n= contarLineas(archivo);
		

	}
	
	
	/////////////////////// METODO DE PARA LEER FICHERO
	
	public static ArrayList<String>  leerFichero (String archivo,String archivo2) throws IOException
	 {
	
		       FileReader f = new FileReader(archivo);
		         BufferedReader b = new BufferedReader(f);
	
		         ArrayList<String> lista_linea = new ArrayList<String>();
		
		String linea=null;
		String sublinea2=null;
		String sublinea=null;
		String linea2=null;;
		int size=contarLineas(archivo);
		
	for(int i=0;i< size;i++)
	  {int con=0;
		linea=b.readLine();
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
		        	  System.out.println(linea);
		     
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
	
	
	////////////////////// METODO PARA CREAR NUEVO FICHERO 
	
public static void imprimir (ArrayList<String> linea){
	
	File ff;
	
	ff = new File("metsRepetidos.txt");
	try{

		FileWriter w = new FileWriter(ff);
		
		BufferedWriter bw = new BufferedWriter(w);
		
		PrintWriter wr = new PrintWriter(bw);  
		

		for (String cadena :linea) {
			bw.write(cadena +"\n");
			bw.newLine();
		}
		wr.close();
		
		bw.close();
		
		}catch(IOException e){};
		
		 }

///////////////////////// METODO PARA CONTAR LAS LINEAS DEL FICHERO 

 public static int  contarLineas (String archivo) throws IOException
   { int numeroLineas;
	
      FileReader fr=new FileReader(archivo);
      BufferedReader bf=new BufferedReader(fr);
     
      numeroLineas=0;
      String sCadena =null;
      while  ((sCadena=bf.readLine())!=null)

             {numeroLineas++;}

    return numeroLineas;
  
     }


// fin clase
}




