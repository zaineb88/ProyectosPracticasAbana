
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LimpiarFicheroReplay {
	
	/**
	 * 
	 * clase que se encarga de coger un fichero, hacer una copia, para
	 * ver los metadatos que se han repetido y crear un nuevo fichero limpio
	 * con solo los metadatos repetidos
	 * 
	 * C:/Users/ABANA55/Desktop/Id_Bloques_No_Usados_1943 - copia.txt
	 */
	//CONSTANTE PARA DAR LA RUTA DONDE GUARDAR EL ARCHIVO RESULTANTE DE METS
	static final String RUTAMETSREPETIDOS = "C:/Users/ABANA55/Desktop/Mets repetidos";
	static final String RUTACOPIAARCHIVO ="C:/Users/ABANA55/Desktop/copias de archivo";
	static int index=0;
	
	public static void main(String[] args) throws IOException
	{
		 
		String copia =introducirRuta(); 
		ArrayList<String> linea=leerFichero(copia,copiaArchivo(copia));
		imprimir(linea);
	
		
	}
	
	/////////////////METODO PARA COPIAR UN ARCHIVO
	
	public static String copiaArchivo (String copia) throws IOException 
	{	
		String archivoCopiado= null;
		String linea = null;
		archivoCopiado = copia;
		String ruta=RUTACOPIAARCHIVO;
		
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
	
	///////////////////// METODO PARA INTRODUCIR LA RUTA DEL ARCHIVO A MODIFICAR  
	
	public static String introducirRuta ()
	{
	
		String rutaArchivo = JOptionPane.showInputDialog("Ingrese la ruta del archivo: ");
		JOptionPane.showMessageDialog(null, "La ruta  ingresad es: "+ rutaArchivo);
	
		return rutaArchivo;
			
		
	}
	
	/////////////////////////METODO PARA DARLE NOMBRE AL ARCHIVO
	
	public static String nombraArchivo ()
	{
		String nombreArchivo = JOptionPane.showInputDialog("Nombre el archivo de Mets repetidos, por favor termine con la extension .txt ");
	
		return nombreArchivo;
		
	}
	
	/////////////////////// METODO DE PARA LEER FICHERO
	
	public static ArrayList<String>  leerFichero (String archivo,String archivo2) throws IOException
	 {
		
		String linea=null;
		String sublinea2=null;
		String sublinea=null;
		String linea2=null;;
		int size=contarLineas(archivo);
		
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
	
	 File ff = new File(RUTAMETSREPETIDOS,nombraArchivo());
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

//////////	METODO PARA CONTAR LINEAS DE UN FICHERO

   public static int  contarLineas (String archivo) throws IOException
   {  
	   
	  int numeroLineas=0;
      String Cadena =null;
	 
      FileReader fr=new FileReader(archivo);
      BufferedReader bf=new BufferedReader(fr);
      
      
      while  ((Cadena=bf.readLine())!=null)

                {numeroLineas++;}

                  System.out.println(numeroLineas);
    
           return numeroLineas;
  
    }
}
//fin clase



