package SumarTamano;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CalcularTamano {
	
	public static double calcularPeso(String fichero) {
		double peso_pdf = 0;
		long peso_pdf_bytes = 0;
			
		File f = new File(fichero);
		
		if(f.exists())
		{
		
			peso_pdf_bytes = f.length();
		
			peso_pdf = peso_pdf_bytes/1048576.0;
			
			peso_pdf = Math.round( peso_pdf * 100.0 ) / 100.0;
		}
		else
		{
			System.out.println("NO SE HA ENCONTRADO NINGUN FICHERO");
		}
		

		return peso_pdf;
	}
	
	
	public static double calcularPesoVariosPdf (String ruta) throws IOException{
		 
		
		// String ruta="C:\\Users\\ABANA53\\Desktop\\Informe\\LOTE_0\\6245\\";
	 
	 
	 
	 
	 int n=calcularLineas.obtenerNumeroFicheros(ruta);
	// System.out.println(n);
	 
	 
	double t= CalcularTamano.calcularPeso(ruta);
	//System.out.println(t);
	 
	double sum=Sumar.suma(ruta);
	
	System.out.println("La suma del tamaño del los lotes es :"+sum);
	
	
	return sum;
	
}

}
