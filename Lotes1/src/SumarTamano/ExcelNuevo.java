package SumarTamano;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelNuevo {
	

	
	public static void escribirExccel() throws IOException{
	
	// Se crea el libro
		
		XSSFWorkbook libro = new XSSFWorkbook();

    // Se crea una hoja dentro del libro

		XSSFSheet hoja = libro.createSheet();
		
		
		
	// Introducir la en numero de la fila en el que se quiere escribir

		XSSFRow fila = hoja.createRow(9);
		XSSFRow fila1 = hoja.createRow(8);
		XSSFRow fila2= hoja.createRow(10);
		XSSFRow fila3 = hoja.createRow(11);
    // Se crea una celda dentro de la fila
		
	//introducir el numero de celda en el que se quiere escribir	

		XSSFCell celda = fila.createCell((short) 7);
		XSSFCell celda1 = fila.createCell((short) 8);
		XSSFCell celda2 = fila.createCell((short) 9);
		XSSFCell celda3 = fila.createCell((short) 10);
		XSSFCell celda4 = fila.createCell((short) 11);
		

		celda1.setCellValue(CalcularTamano.calcularPesoVariosPdf(Main.RUTA));
		
		

    // Se salva el libro.

    try {

        FileOutputStream elFichero = new FileOutputStream(Main.RUTA2);

        libro.write(elFichero);

        elFichero.close();

    } catch (Exception e) {

        e.printStackTrace();

    }


}}
