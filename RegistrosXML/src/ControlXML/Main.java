package ControlXML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ss.usermodel.Cell;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {


	
	
	
	static final String RUTA="C:\\Users\\ABANA53\\Desktop\\9785";
	static final String RUTA2="C:\\Users\\ABANA53\\Desktop\\Registro_9802.xlsx";
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
		
	//	boolean res=leerXML.compararId(RUTA);
		
		
		//System.out.println(res);
		
		ArrayList<Datos_XML> lista = new ArrayList<>();
		
		DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		//lista = leerXML.rellenar_lista_xml(RUTA);
		File f = new File(RUTA);
		
//		String[] cadena2 = f.list();
//		
//		String s = leerXML.nombres_ficheros(cadena2);
//		
	//	StringBuilder lista2 = leerXML.titulos_filtrados(lista,s);

	//	String cadena = lista2.toString();
	    int con=1;
	    int con2=1;
	    int conControl=0;
		String sublote=RUTA.substring(RUTA.length()-4, RUTA.length()) ;
	
		lista = leerXML.rellenar_lista_xml(RUTA, RUTA2);
		String ID=null;
		String unico = "SI";
		String no_unico = "NO";
		String ncontrol=null;
		int cell1=0;
		Cell cell = null;
	//	Mn.write(RUTA, gete );
				
		for(Datos_XML dato : lista){
			
			System.out.println(dato.getSublote()+"     "+dato.isUnico() +"    "+ dato.getEjemplar());
//			
//			res=leerXML.compararId(RUTA);
//			
//			System.out.println(res);
//			if(res==true){
//				EscribirExcel.writeXLSXFile2(con, 6, conControl , RUTA2);
//				}else{conControl++;}
////			
			for(String cad:dato.getEjemplar())
			{EscribirExcel.writeXLSXFile3(con, 4,cad.toString() +"   \n", RUTA2);}
			ID=dato.getSublote();
			
			EscribirExcel.writeXLSXFile3(con, 0, ID , RUTA2);
		EscribirExcel.writeXLSXFile3(con, 1, sublote , RUTA2);
			
			////////////////////////////
			ncontrol=leerXML.obtenerNcontrol(RUTA,ID);
			///////////////////////
	
			
			/////////////////
			
			EscribirExcel.writeXLSXFile3(con, 5, ncontrol, RUTA2);
			
			
			if(dato.isUnico()==true)
			{  EscribirExcel.writeXLSXFile3(con, 2, unico , RUTA2);
			    EscribirExcel.writeXLSXFile3(con, 3, "NO" , RUTA2);
			    EscribirExcel.writeXLSXFile3(con, 4, ID , RUTA2);
			    
			}
			else {  EscribirExcel.writeXLSXFile3(con, 2, no_unico , RUTA2);
			EscribirExcel.writeXLSXFile3(con, 3, "SI" , RUTA2);
		     EscribirExcel.writeXLSXFile4(con, 4,dato.getEjemplar() , RUTA2);
		  if(dato.getEjemplar().size()<2)
		  {EscribirExcel.writeXLSXFile2(con, 6,con2 , RUTA2);}
//	
//		    for(int i=0;i<dato.getEjemplar().size();i++){
//		     EscribirExcel.writeXLSXFile2(con, 6,con2 , RUTA2);
//		     
//		    }
		    
			}
	
		con++;
		}
		
		}
		
		
	


	}


