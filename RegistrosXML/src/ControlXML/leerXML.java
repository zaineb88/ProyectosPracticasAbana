package ControlXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.marc4j.MarcReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;
import org.xml.sax.SAXException;
import org.w3.*;


public class leerXML {
	static org.w3c.dom.Document xml;
	
	
	public static Datos_XML crear_dato_XML(String ruta) throws IOException {
		
		InputStream in;
		MarcReader reader = null;
		int contador = 0;
		Datos_XML dato = new Datos_XML();
		File file = new File(ruta);

		dato.setSublote(file.getName());

		try {
			in = new FileInputStream(ruta);
			reader = new MarcXmlReader(in);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		while (reader.hasNext()) {
			Record record = reader.next();

			List dataFields = record.getVariableFields("899");
			Iterator i = dataFields.iterator();

			while (i.hasNext()) {
				DataField dataField = (DataField) i.next();
				contador++;
				List subfields = dataField.getSubfields();
				Iterator i2 = subfields.iterator();

				if (i2.hasNext()) {
					Subfield subfield = (Subfield) i2.next();
					char code = subfield.getCode();
					String data = subfield.getData();

					data.replace('/', '_');

					if (contador >= 1)
						dato.getEjemplar().add(data);
					
				}
				
			}
		}

		if (contador > 1) {
			dato.setUnico(false);
		} else {
			dato.setUnico(true);
		}

		return dato;
	}

	/**
	 * Rellena una lista de Datos_XML a partir de una ruta de un directorio,
	 * utiliza el metodo crear_dato_XML para crear la lista
	 * 
	 * @param ruta
	 * @return
	 * @throws IOException 
	 */
	public static ArrayList<Datos_XML> rellenar_lista_xml(String ruta,String ruta2) throws IOException {
		ArrayList<Datos_XML> lista_datos = new ArrayList<>();
		String ruta_completa = "";
		File file = new File(ruta);

		Datos_XML dato = null;

		if (!file.exists())
			System.out.println("ruta incorrecta");
		else {
			File[] lista_ficheros = file.listFiles();

			for (int i = 0; i <lista_ficheros.length; i++) {

				ruta_completa = ruta + "\\" + lista_ficheros[i].getName();
				System.out.println( lista_ficheros[i].getName());
				dato = new Datos_XML();
				dato = crear_dato_XML(ruta_completa);

				if (dato != null)
					lista_datos.add(dato);

			}
		}

		return lista_datos;
	}




	
	public static String obtenerNcontrol (String ruta,String id) throws ParserConfigurationException, SAXException, IOException{
			
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		 xml =  dBuilder.parse(new File (ruta+"\\"+id));
	
       String Ncontrol=xml.getElementsByTagName("marc:leader").item(0).getTextContent();
		return Ncontrol; 
	}
	
	
	public static boolean compararId(String ruta) throws ParserConfigurationException, SAXException, IOException
	{
      String id=null;
      String id2=null;
      String idComparar=null;
      boolean res = false;
	File file = new File(ruta);
	File[] lista_ficheros = file.listFiles();
	
	
	for(int j=0;j<lista_ficheros.length;j++){
	     id=lista_ficheros[j].getName();
		 idComparar=obtenerNcontrol(ruta, id);
		 System.out.println("id principal  "+idComparar);
	for (int i = j+1; i <lista_ficheros.length; i++) {
           
		id=lista_ficheros[i].getName();
		 id2=obtenerNcontrol(ruta, id);
		 System.out.println("id comparacion  "+id2);
		 	 if(idComparar.equals(id2)){System.out.println(" son iguales");
		 	 
		 	 res=true;
		 	 }
		 	 else{System.out.println("no son iguales");
		 	 res = false;
		 	 }
		}		


	}
	
	
	return res;
	}

}
