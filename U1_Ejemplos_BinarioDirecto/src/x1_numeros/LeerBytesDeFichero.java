package x1_numeros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class LeerBytesDeFichero {
	
	/**
	 * Lee desde el principio del fichero binario el vector de notas como datos.
	 * Escribe en consola el vector de notas leído.
	 * Escribe en consola el número de notas leídas del fichero binario.
	 */
	public static void main(String[] args) {
		RandomAccessFile flujoEntrada = null;
		try {
			File fichero = new File("data/notas.dat");
			flujoEntrada = new RandomAccessFile(fichero, "r");
			flujoEntrada.seek(0);
			int numeroNotas = flujoEntrada.readInt();
			double[] vectorNotas = new double[numeroNotas];
			int posicion = 0;
			while (flujoEntrada.getFilePointer() < flujoEntrada.length()) {
				 vectorNotas[posicion] = flujoEntrada.readDouble();
				 posicion++;
			}
			System.out.println("Se han leído " + vectorNotas.length + " notas del fichero binario:");
			System.out.println(Arrays.toString(vectorNotas));
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
