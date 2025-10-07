package x1_frases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import entrada.Teclado;

public class EscribirBytesEnFichero {
	
	/**
	 * Lee por teclado una frase.
	 * Escribe al final del fichero binario la frase y un salto de línea.
	 * Escribe en consola el número de bytes escritos en el fichero binario.
	 */
	public static void main(String[] args) {
		FileOutputStream flujoSalida = null;
		try {
			String frase = Teclado.leerCadena("Frase: ");
			File fichero = new File("data/frases.dat");
			flujoSalida = new FileOutputStream(fichero, true);
			for (int posicion = 0 ; posicion < frase.length() ; posicion++) {
				int codigo = frase.charAt(posicion);
				flujoSalida.write(codigo);
			}
			flujoSalida.write('\n');  // salto de línea
			System.out.println("Se han escrito " + (frase.length() + 1) + " bytes en el fichero binario.");
		} 
		catch (FileNotFoundException fnfe) {
			System.out.println("Error al crear o abrir el fichero binario.");
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al escribir en el fichero binario.");
			ioe.printStackTrace();
		}
		finally {
			try {
				if (flujoSalida != null) {
					flujoSalida.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero binario.");
				ioe.printStackTrace();
			}
		}
	}
  
}
