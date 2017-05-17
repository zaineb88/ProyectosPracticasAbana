package ControlXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EscribirExcel {
	
	
	
    public static void writeXLSXFile2(int row, int col, int res,String ruta) throws IOException {
        try {
            FileInputStream file = new FileInputStream(ruta);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

          
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

            FileOutputStream outFile =new FileOutputStream(new File(ruta));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    
    public static void writeXLSXFile3(int row, int col, String res,String ruta) throws IOException {
        try {
            FileInputStream file = new FileInputStream(ruta);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

      
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

            FileOutputStream outFile =new FileOutputStream(new File(ruta));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void writeXLSXFile4(int row, int col, ArrayList<String> res,String ruta) throws IOException {
    	
    	int con= 0;
    	int conControl = 0;
    	
        try {
            FileInputStream file = new FileInputStream(ruta);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

      
            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }

            
            String idEjemplares=null;
            String id=null;
            String id2=null;
            int cell1=0;
            switch (res.size()) {
            
			case 1:
				cell.setCellValue(res.get(0));
		
				cell1=cell.getRowIndex();
				System.out.println("celllllll1"+cell1);	EscribirExcel.writeXLSXFile2(cell1, 6,cell1 , Main.RUTA2);
				EscribirExcel.writeXLSXFile2(con, 6, 1 , Main.RUTA2);
				break;

			case 2:
				cell.setCellValue(res.get(0)+ " , "+ res.get(1));
				EscribirExcel.writeXLSXFile2(con, 6, 1 , Main.RUTA2);

				
				
				break;
				
			case 3:
				cell.setCellValue(res.get(0)+ " , "+ res.get(1)+" , "+ res.get(2));
				EscribirExcel.writeXLSXFile2(con, 6, 1 , Main.RUTA2);
				break;
				
			case 4:
				cell.setCellValue(res.get(0)+ " , "+ res.get(1)+" , "+res.get(2)+ " , "+ res.get(3));
				EscribirExcel.writeXLSXFile2(con, 6, 1 , Main.RUTA2);
				break;
				
			case 5:
				cell.setCellValue(res.get(0)+ " , "+ res.get(1)+" , "+res.get(2)+ " , "+ res.get(3)+ " , "+res.get(4));
				EscribirExcel.writeXLSXFile2(con, 6, 1 , Main.RUTA2);
				break;
			case 6:
				cell.setCellValue(res.get(0)+ " , "+ res.get(1)+" , "+res.get(2)+ " , "+ res.get(3)+ " , "+res.get(4)+ " , "+res.get(5));
				EscribirExcel.writeXLSXFile2(con, 6, 1 , Main.RUTA2);
				break;
			}
            
            
            EscribirExcel.writeXLSXFile2(cell1, 6,cell1 , Main.RUTA2);
            file.close();

            
            
            
            
            
            FileOutputStream outFile =new FileOutputStream(new File(ruta));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    


}}