package LimpiarMets;

import java.io.IOException;
import java.util.ArrayList;

public class Principal {
	
	
	
	/**
	 * 
	 * clase que se encarga de coger un fichero, hacer una copia, para
	 * ver los metadatos que se han repetido y crear un nuevo fichero limpio
	 * con solo los metadatos repetidos
	 * 
	 * ruta de prueba   C:/Users/ABANA55/Desktop/Id_Bloques_No_Usados_1943 - copia.txt
	 */
	
	
	
	//CONSTANTE PARA DAR LA RUTA DONDE GUARDAR EL ARCHIVO RESULTANTE DE METS
		static final String RUTAMETSREPETIDOS = "C:/Users/ABANA55/Desktop/Mets repetidos";
		static final String RUTACOPIAARCHIVO ="C:/Users/ABANA55/Desktop/copias de archivo";
		
		
		
	
	public static void main(String[] args) throws IOException {
		
		
	
		
		//////////// LLAMADA A LOS METODOS 
		
		String copia =MetodosSecundarios.introducirRuta(); 
		String copia2=LimpiarFichero.copiaArchivo(copia);
		
		ArrayList<String> linea= LimpiarFichero.leerFichero(copia,copia2);
	
		ArrayList<String> linea2=LimpiarFichero.leerFicheroFinal(linea);
		
	    LimpiarFichero.imprimir(linea2);
	}
}
