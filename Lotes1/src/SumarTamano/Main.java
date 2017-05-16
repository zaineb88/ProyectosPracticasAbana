package SumarTamano;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	
	//// ruta donde hay lote        C:\\Users\\ABANA53\\Desktop\\Informe\\LOTE_0\\6245\\  
	
	/// ruta donde quiero guardar excel          C:/Users/ABANA53/Desktop/prueba.xlsx/
	
	//static final String RUTA=dialogEntrada();
	
	static final String RUTA="C:\\Users\\ABANA53\\Desktop\\Informe\\LOTE_0\\6245\\";
	////////  esto vale en el case si quieres crear un excel nuevo
	
	static final String RUTA2=dialogSalida();
	

	
	
	
	
	public static void main(String[] args) throws IOException {
		
	
		  String lote=RUTA.substring(RUTA.length()-7,RUTA.length()-6);
		 Excel2.writeXLSXFile3(5,2,lote);
		 System.out.println("NUMERO LOTE :"+lote);
		 
		 
		 String bne=null;
		 bne=RUTA.substring(RUTA.length()-5,RUTA.length()-1);
		 Excel2.writeXLSXFile3(5,3,bne);
		 System.out.println("NUMERO LOTE BNE :"+bne);
		 
		 
		 int ficheros= calcularLineas.obtenerNumeroFicheros(RUTA);
		 Excel2.writeXLSXFile2(5,4,ficheros);
		 System.out.println("NUMERO DE FICHEROS  :"+ficheros);
		 
		 double sum=Sumar.suma(RUTA);
		 Excel2.writeXLSXFile(5,5,sum);    // para modificar  un excel existe antes  
		 System.out.println("TAMAÑO :"+sum);


		 
		 
		int simples= calcularLineas.lineasSimples(RUTA);
		 Excel2.writeXLSXFile2(5,6,simples);
		 System.out.println("SIMPLES SON :"+simples);
		 
		 
		 int mets= calcularLineas.lineasMets(RUTA);
		 Excel2.writeXLSXFile2(5,7,mets);
		 System.out.println("LOS METS SON :"+mets);
		 
		 
		 int paginas=calcularLineas.paginas(RUTA);
		 Excel2.writeXLSXFile2(5,9,paginas);
		 System.out.println("TOTAL PÁGINAS :"+paginas);
		 
		 
		 
		 System.out.println("HA COPIADO EL RESULTADO CORRECTAMENTE!");
		 
		// ExcelNuevo.escribirExccel();  // para crear y  escribir en un excel nuevo
		 

	}
	
	
	
	///////////////////// METODOS DEL DIALOGO
	
	
	public static String dialogEntrada(){
	String ruta =JOptionPane.showInputDialog("Entroduce la ruta del lote ");
	return ruta;

	}
	
	
	public static String dialogSalida(){
		String ruta =JOptionPane.showInputDialog("Entroduce la donde creas guardar la suma ");
		return ruta;

		}
	
	////////////////// METODOS SECUNDARIOS 
	


}


