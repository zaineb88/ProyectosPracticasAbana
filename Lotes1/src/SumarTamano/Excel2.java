package SumarTamano;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2 {

	
	public static void main(String[] args) throws IOException {
		
		
		//writeXLSXFile(6,6);
	}
    public static void writeXLSXFile(int row, int col,double sum) throws IOException {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\ABANA53\\Desktop\\Modelo.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

          //Retrieve the row and check for null
            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            //Update the value of cell
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
           // double sum=Sumar.suma(Main.RUTA);
            cell.setCellValue(sum);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\ABANA53\\Desktop\\Modelo.xlsx"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/////////////////////////////////////
    
    
    
    public static void writeXLSXFile2(int row, int col, int res) throws IOException {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\ABANA53\\Desktop\\Modelo.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

          //Retrieve the row and check for null
            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            //Update the value of cell
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
           
            cell.setCellValue(res);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\ABANA53\\Desktop\\Modelo.xlsx"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //////////////////////////////////////
    
    public static void writeXLSXFile3(int row, int col, String res) throws IOException {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\ABANA53\\Desktop\\Modelo.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

          //Retrieve the row and check for null
            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
           
            cell.setCellValue(res);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\ABANA53\\Desktop\\Modelo.xlsx"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
