package x3_peliculas_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import entrada.Teclado;

public class EscribirPeliculaEnFichero1 {

	/**
	 * Lee por teclado los datos de una película.
	 * Al crear un flujo de salida de objetos hacia el fichero binario, 
	 * escribe una cabecera de datos en el fichero.
	 * Escribe al final del fichero binario la película como objeto serializable.
	 */
	public static void main(String[] args) {
		ObjectOutputStream flujoSalida = null;
		try {
			int codigo = Teclado.leerEntero("Código: ");
			String titulo = Teclado.leerCadena("Título: ");
			String director = Teclado.leerCadena("Director: ");
			int agnoEstreno = Teclado.leerEntero("Año de Estreno: ");
			double puntuacion = Teclado.leerReal("Puntuación: ");
			Pelicula pelicula = new Pelicula(codigo, titulo, director, agnoEstreno, puntuacion);
			File fichero = new File("data/peliculas.dat");
			flujoSalida = new ObjectOutputStream(new FileOutputStream(fichero, true));
			flujoSalida.writeObject(pelicula);
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
