package x2_libros_datos;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerLibrosDeFichero {
	
	/**
	 * Lee el fichero binario por datos.
	 * Escribe en consola cada libro como datos le�dos del fichero binario.
	 * Escribe en consola el n�mero de libros le�dos del fichero binario.
	 */
	public static void main(String[] args) {
		DataInputStream flujoEntrada = null;
		try {
			File fichero = new File("data/libros.dat");
			flujoEntrada = new DataInputStream(new FileInputStream(fichero));
			int contador = 0;
			try {
				while (true) {
					int codigo = flujoEntrada.readInt();
					String titulo = flujoEntrada.readUTF();
					String escritor = flujoEntrada.readUTF();
					int agnoPublicacion = flujoEntrada.readInt();
					double precio = flujoEntrada.readDouble();
					System.out.printf("C�digo = %d, T�tulo = %s, Escritor = %s, A�oPublicaci�n = %d, Precio = %.2f\n",
					                  codigo, titulo, escritor, agnoPublicacion, precio);
					contador++;
				}
			}
			catch (EOFException eofe) {
				System.out.println("Se ha alcanzado el final del fichero binario.");
			}
			System.out.println("Se han le�do " + contador + " libros del fichero binario.");
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
