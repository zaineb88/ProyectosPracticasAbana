package paquete1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.CancelledKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;

public class Control_XML {

	/**
	 * Dada la ruta del fichero xml, crea un objeto de DATOS_XML
	 * 
	 * @param ruta
	 * @return
	 */
	public static Datos_XML crear_dato_XML(String ruta) {
		// Se crea un SAXBuilder para poder parsear el archivo
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
			// TODO Auto-generated catch block
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

					if (contador > 1)
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
	 */
	public static ArrayList<Datos_XML> rellenar_lista_xml(String ruta) {
		ArrayList<Datos_XML> lista_datos = new ArrayList<>();
		String ruta_completa = "";
		File file = new File(ruta);

		Datos_XML dato = null;

		if (!file.exists())
			System.out.println("ruta incorrecta");
		else {
			File[] lista_ficheros = file.listFiles();

			for (int i = 0; i < lista_ficheros.length; i++) {

				ruta_completa = ruta + "\\" + lista_ficheros[i].getName();

				dato = new Datos_XML();
				dato = crear_dato_XML(ruta_completa);

				if (dato != null)
					lista_datos.add(dato);

			}
		}

		return lista_datos;
	}

	/**
	 * Dado un String y una lista completa de ficheros xml, compara los nombres
	 * del string con los de los ficheros xml y obtiene una lista para guardar
	 * en la base de datos
	 * 
	 * @param lista_filtrada
	 * @param lista_completa
	 * @return
	 */
	public static ArrayList<Datos_XML> rellenar_lista_filtrada(String lista_filtrada,
			ArrayList<Datos_XML> lista_completa) {
		ArrayList<Datos_XML> lista_datos = new ArrayList<>();
		int contador = 0;
		String nombre_aux = "";

		for (Datos_XML dato : lista_completa) {
			nombre_aux = dato.getSublote();
			nombre_aux = nombre_aux.replaceAll(".xml", "");

			if (lista_filtrada.contains(nombre_aux)) {
				lista_datos.add(dato);
			}
		}

		return lista_datos;
	}

	/**
	 * Dada una lista completa de xml y una lista de sus nombres, filtra los
	 * datos para sacar un string con los nombres de los ficheros que tenemos
	 * que guardar en la base de datos
	 * 
	 * @param lista_titulos
	 * @param nombres_fichero
	 * @return
	 */
	public static StringBuilder titulos_filtrados(ArrayList<Datos_XML> lista_titulos, String nombres_fichero) {
		StringBuilder lista_filtrada = new StringBuilder();

		boolean contiene = false;

		String nombre_lote = "";
		lista_filtrada.append("");

		for (Datos_XML datos : lista_titulos) {
			ArrayList<String> lista_auxiliar = new ArrayList<>();

			if (!datos.isUnico()) {

				for (String añadido : datos.getEjemplar()) {
					lista_auxiliar.add(añadido);
				}

				int contador = 0;
				while (!contiene && contador < lista_auxiliar.size()) {

					nombre_lote = lista_auxiliar.get(contador);
					nombre_lote = nombre_lote.replace("/", "_");

					/*
					 * Comparamos si el String contiene el nombre del sublote o
					 * sus ejemplares, de ser asi se añade al string y sale del
					 * while
					 */
					if (lista_filtrada.toString().contains(nombre_lote)
							|| lista_filtrada.toString().contains(datos.getSublote())) {
						contiene = true;
					} else {
						contiene = false;
					}
					contador++;

					/*
					 * Aparte de comprobar si el nombre estaba en el string
					 * comprobamos tambien que concuerde con los nombres de los
					 * ficheros para evitar guardar datos que no se encuentran
					 * en la carpeta
					 */
					if (!contiene && nombres_fichero.contains(nombre_lote)) {
						lista_filtrada.append(nombre_lote);
						lista_filtrada.append(";;");
						contador = 0;
					}
				}
			} else {
				lista_filtrada.append(datos.getSublote());
				lista_filtrada.append(";;");
			}

			lista_auxiliar = null;
			contiene = false;
		}

		return lista_filtrada;
	}

	/**
	 * Convierte un array de String en un string y le quita la extension .xml
	 * 
	 * @param lista
	 * @return
	 */
	public static String nombres_ficheros(String[] lista) {
		String cadena = "";

		for (String dato : lista) {
			dato = dato.replaceAll(".xml", "");
			cadena = cadena + dato;
		}

		return cadena;
	}

	/**
	 * Compara el nombre del dato1 con los ejemplares que contiene dato2, en
	 * caso de haber una coincidencia, devuelve true
	 * 
	 * @param dato1
	 * @param dato2
	 * @return
	 */
	public static boolean comparar_datos_XML(Datos_XML dato1, Datos_XML dato2) {
		boolean comparar = false;
		String ejemplares_aux2 = "";

		for (String ejemplar2 : dato2.getEjemplar()) {
			ejemplares_aux2 = ejemplares_aux2 + ejemplar2;
		}

		if (ejemplares_aux2.contains(dato1.getSublote())) {
			comparar = true;
		}

		return comparar;
	}

	public static void crear_excel_informativo(ArrayList<Datos_XML> lista_informacion, String nombre_Sublote) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Hoja excel");
		String cadena = "";

		String[] headers = new String[] { "Sublote", "Único", "Varios", "Ejemplares" };

		HSSFRow headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; ++i) {
			String header = headers[i];
			HSSFCell cell = headerRow.createCell(i);

			cell.setCellValue(header);
		}
		int i = 0;
		for (Datos_XML datos : lista_informacion) {
			HSSFRow dataRow = sheet.createRow(i += 1);

			// sublote ficheros tamaño simples metc titulos paginas
			dataRow.createCell(0).setCellValue(nombre_Sublote);

			if (datos.isUnico()) {
				dataRow.createCell(1).setCellValue("SI");
				dataRow.createCell(2).setCellValue("NO");
			} else {
				dataRow.createCell(1).setCellValue("NO");
				dataRow.createCell(2).setCellValue("SI");
			}

			for (String ejemplar : datos.getEjemplar()) {
				cadena = cadena + ejemplar + ";;";
			}

			if (cadena != "")
				cadena = cadena.substring(0, cadena.length() - 2);

			else {
				cadena = datos.getSublote();
				cadena = cadena.replaceAll(".xml", "");
			}
			dataRow.createCell(3).setCellValue(cadena);

			cadena = "";

		}

		FileOutputStream file;
		try {
			file = new FileOutputStream("C://FicherosXML.xls");
			workbook.write(file);
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 899
}
