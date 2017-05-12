package LimpiarMets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MetodosSecundarios {
	
	
	/////////////////////////// METODO DE CONTAR LINEAS DEL FICHERO DE METS
	
	  public static int  contarLineas (String archivo) throws IOException
	   {  
		   
		  int numeroLineas=0;
	      String Cadena =null;
		 
	      FileReader fr=new FileReader(archivo);
	      BufferedReader bf=new BufferedReader(fr);
	      
	      
	      while  ((Cadena=bf.readLine())!=null)

	                {numeroLineas++;}

	                  System.out.println("Este fichero tiene :"+numeroLineas +" lineas.");
	    
	           return numeroLineas;
	  
	    }
	  
	  //////////////////////// METODO PARA PEDIR NOMBRE PARA EL ARCHIVO NUEVO
	  
	  
		public static String nombraArchivo ()
		{
			String nombreArchivo = JOptionPane.showInputDialog("Nombre el archivo de Mets repetidos, por favor termine con la extension .txt ");
		
			return nombreArchivo;
			
		}
		
		///////////////////// METODO PARA INTRODUCIR LA RUTA DEL ARCHIVO A MODIFICAR  
		
		public static String introducirRuta ()
		{
		
			String rutaArchivo = JOptionPane.showInputDialog("Ingrese la ruta del archivo: ");
			JOptionPane.showMessageDialog(null, "La ruta  ingresad es: "+ rutaArchivo);
		
			return rutaArchivo;
				
			
		}

}
