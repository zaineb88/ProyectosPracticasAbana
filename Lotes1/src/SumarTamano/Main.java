package SumarTamano;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Main {
	
	//// ruta donde hay lote          C:\\Users\\ABANA53\\Desktop\\Informe\\LOTE_0\\6245\\
	
	/// ruta donde quiero guardar excel          C:/Users/ABANA53/Desktop/prueba.xlsx/
	
	static final String RUTA=dialogEntrada();
	
	//static final String RUTA2=dialogSalida();
	

	public static void main(String[] args) throws IOException {
	
		  double sum=Sumar.suma(RUTA);
		
		// Excel.escribirExccel(RUTA);

	//	 Excel.escribirExccel(RUTA);
		
		  
		 Excel2.writeXLSXFile(5, 5);
		
	}
	
	
	
	public static String dialogEntrada(){
	String ruta =JOptionPane.showInputDialog("Entroduce la ruta del lote ");
	return ruta;

	}
	
	
	public static String dialogSalida(){
		String ruta =JOptionPane.showInputDialog("Entroduce la ruta del lote ");
		return ruta;

		}

}

