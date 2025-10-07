package x3_peliculas_objetos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class LeerPeliculasDeFichero {
	
	/**
	 * Lee el fichero binario por objetos.
	 * Escribe en consola cada película como objeto serializable del fichero binario.
	 * Escribe en consola el número de películas leídas del fichero binario.
	 */
	public static void main(String[] args) {
		ObjectInputStream flujoEntrada = null;
		try {
			File fichero = new File("data/peliculas.dat");
			flujoEntrada = new ObjectInputStream(new FileInputStream(fichero));
			int contador = 0;
			try {
				while (true) {
					Pelicula pelicula = (Pelicula) flujoEntrada.readObject();
					System.out.println(pelicula.toString());
					contador++;
				}
			}
			catch (EOFException eofe) {
				System.out.println("Se ha alcanzado el final del fichero binario.");
			}
			catch (StreamCorruptedException sce) {
				System.out.println("Se ha encontrado información inconsistente en el fichero binario.");
			}
			System.out.println("Se han leído " + contador + " películas del fichero binario.");
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error al convertir objeto a una clase.");
			cnfe.printStackTrace();
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
