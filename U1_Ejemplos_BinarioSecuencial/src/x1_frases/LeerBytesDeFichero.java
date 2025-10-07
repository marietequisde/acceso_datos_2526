package x1_frases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerBytesDeFichero {
	
	/**
	 * Lee el fichero binario byte a byte.
	 * Escribe en consola cada byte leído del fichero binario como carácter.
	 * Escribe en consola el número de bytes leídos del fichero binario.
	 */
	public static void main(String[] args) {
		FileInputStream flujoEntrada = null;
		try {
			File fichero = new File("data/frases.dat");
			flujoEntrada = new FileInputStream(fichero);
			int contador = 0;
			int codigo = flujoEntrada.read();
			while (codigo != -1) {
				System.out.print((char) codigo);
				contador++;
				codigo = flujoEntrada.read();
			}
			System.out.println("Se han leído " + contador + " bytes del fichero binario.");
		} 
		catch (FileNotFoundException fnfe) {
			System.out.println("Error al abrir el fichero binario.");
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero binario.");
			ioe.printStackTrace();
		}
		finally {
			try {
				if (flujoEntrada != null) {
					flujoEntrada.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero binario.");
				ioe.printStackTrace();
			}
		}   
	}
  
}
