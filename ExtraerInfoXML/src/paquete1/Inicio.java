package paquete1;

import java.io.File;
import java.util.ArrayList;

public class Inicio {

	public static void main(String[] args) {
		
		//Control_XML.calcular_cantidad_899("C:\\Users\\abana62\\Desktop\\Registros_BD\\9785\\INVENT_46625.xml");
		
		ArrayList<Datos_XML> lista = new ArrayList<>();
		
		
		lista = Control_XML.rellenar_lista_xml("C:\\Users\\ABANA53\\Desktop\\Registros_BD");
		File f = new File("C:\\Users\\abana62\\Desktop\\Registros_BD\\9785");
		
		String[] cadena2 = f.list();
		
		String s = Control_XML.nombres_ficheros(cadena2);
		
		StringBuilder lista2 = Control_XML.titulos_filtrados(lista,s);
		
		/*
		for(Datos_XML dato : lista){
			System.out.println(dato.getSublote()+"     "+dato.isUnico());
		}*/
		String cadena = lista2.toString();
		cadena = cadena.replaceAll(".xml","");
		cadena = cadena.replace("/", "_");
		
		String [] lista_completa = cadena.split(";;");
		
		/*
		for(int i= 0 ; i<lista_completa.length;i++){
			System.out.println(lista_completa[i]);
		}*/
		
		lista = Control_XML.rellenar_lista_filtrada(cadena, lista);
		
		for(Datos_XML dato : lista){
			System.out.println(dato.getSublote()+"     "+dato.isUnico());
		}
		
		
		Control_XML.crear_excel_informativo(lista,f.getName());
	}
}
