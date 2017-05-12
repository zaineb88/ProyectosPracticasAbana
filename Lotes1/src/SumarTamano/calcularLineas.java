package SumarTamano;

import java.io.File;

public class calcularLineas {
	
	public static int obtenerNumeroFicheros (String ruta)
	{
		int numFicheros = 0;
		File directorio = new File(ruta);
		
		if(directorio.exists())
		{
			File[] lista_ficheros = directorio.listFiles();
			if (lista_ficheros != null)
			{
				for(int i = 0; i < lista_ficheros.length; i++)
				{
					if(lista_ficheros[i].isDirectory())
					{
						int num = obtenerNumeroFicheros(lista_ficheros[i].getAbsolutePath());
						numFicheros += num;
					}
					else if(lista_ficheros[i].isFile())
					{
						numFicheros++;
					}
				}
			}
		}
		else
		{
			System.out.println("ERROR: Ruta de directorio incorrecta");
		}
		
		return numFicheros;
	}

}
