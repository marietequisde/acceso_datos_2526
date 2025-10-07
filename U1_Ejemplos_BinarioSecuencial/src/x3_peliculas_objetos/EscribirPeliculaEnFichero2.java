package x3_peliculas_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import entrada.Teclado;

public class EscribirPeliculaEnFichero2 {

	/**
	 * Lee por teclado los datos de una película.
	 * Escribe al final del fichero binario la película como objeto serializable.
	 * Considera dos casos:
	 * - Si el fichero binario no existe, lo crea en el sistema de archivos, 
	 *   añade una cabecera de datos e inserta la película al principio del fichero.
	 * - Si el fichero binario existe, no añade otra cabecera de datos e
	 *   inserta la película al final del fichero.
	 */
	public static void main(String[] args) {
		ObjectOutputStream flujoSalida1 = null;
		MyObjectOutputStream flujoSalida2 = null;
		try {
			int codigo = Teclado.leerEntero("Código: ");
			String titulo = Teclado.leerCadena("Título: ");
			String director = Teclado.leerCadena("Director: ");
			int agnoEstreno = Teclado.leerEntero("Año de Estreno: ");
			double puntuacion = Teclado.leerReal("Puntuación: ");
			Pelicula pelicula = new Pelicula(codigo, titulo, director, agnoEstreno, puntuacion);
			File fichero = new File("data/peliculas.dat");
			// Insertar la película al final del fichero.
			if (fichero.exists()) {
				flujoSalida2 = new MyObjectOutputStream(new FileOutputStream(fichero, true));
				flujoSalida2.writeObject(pelicula);
			}
			// Crear el fichero e insertar la película al principio del fichero.
			else {
				flujoSalida1 = new ObjectOutputStream(new FileOutputStream(fichero));
				flujoSalida1.writeObject(pelicula);
			}
			System.out.println("Se ha escrito una película en el fichero binario.");
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
				if (flujoSalida1 != null) {
					flujoSalida1.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero binario.");
				ioe.printStackTrace();
			}
			try {
				if (flujoSalida2 != null) {
					flujoSalida2.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero binario.");
				ioe.printStackTrace();
			}
		}
	}

}
