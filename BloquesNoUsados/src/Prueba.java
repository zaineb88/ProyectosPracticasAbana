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

public class Prueba {
	
	 static int index=0;
	
	public static void main(String[] args) throws IOException
	{
		 
	
		//String ax = JOptionPane.showInputDialog("Ingrese la ruta del archivo: ");
		//JOptionPane.showMessageDialog(null, "La ruta  ingresad es: "+ax);
		//String ax = JOptionPane.showInputDialog("Ingrese la ruta del nuevo archivo: ");
				//JOptionPane.showMessageDialog(null, "La ruta  ingresad es: "+ax);
		
		
		ArrayList<String> linea=leerFichero("C:/Users/ABANA55/Desktop/Id_Bloques_No_Usados_1943.txt");
		
	   imprimir(linea);

		

	}
	
	
	/////////////////////// METODO DE PARA LEER FICHERO
	
	public static ArrayList<String>  leerFichero (String archivo) throws IOException
	 {			   FileReader f = new FileReader(archivo);
		         BufferedReader b = new BufferedReader(f);
		         FileReader f2 = new FileReader(archivo);
		     
	
		          ArrayList<String> lista_linea = new ArrayList<String>();
		
		String linea=null;
		String sublinea2=null;
		String sublinea=null;
		String linea2=null;
		int con=0;
		int size=contarLineas(archivo);
		//linea2=b2.readLine();
		
		
	for(int i=0;i< size;i++)
	  {
		//if(i==0){linea2=b2.readLine();}
		linea=b.readLine();
        BufferedReader b2=new BufferedReader(f2);
        
	  if(linea.length()==91){
		
		sublinea=linea.substring(65,70);
		
	     
		for(int j=i;j<size;j++)
		{ linea2=b2.readLine();
		
			
		 if(linea2.length()==91)
		 { 
		      sublinea2=linea2.substring(65,70);
		         System.out.println(sublinea2+"    "+sublinea);
	        	if(sublinea.equals(sublinea2))
	        	{ con++;
	        	if(con>=2){
	        		 lista_linea.add(linea2);
		        	  System.out.println(linea2);
		        	  
	        	    }
	        	
	        	}
			}
		
		
	     }
		linea2=linea;
	b2.close();
	f2.close();
	  
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




