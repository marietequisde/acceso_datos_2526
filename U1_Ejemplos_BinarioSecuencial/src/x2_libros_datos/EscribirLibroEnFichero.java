package x2_libros_datos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import entrada.Teclado;

public class EscribirLibroEnFichero {
	
	/**
	 * Lee por teclado los datos de un libro.
	 * Escribe al final del fichero binario los datos del libro.
	 */
	public static void main(String[] args) {   
		DataOutputStream flujoSalida = null;
		try {
			int codigo = Teclado.leerEntero("Código: ");
			String titulo = Teclado.leerCadena("Título: ");
			String escritor = Teclado.leerCadena("Escritor: ");
			int agnoPublicacion = Teclado.leerEntero("Año de Publicación: ");
			double precio = Teclado.leerReal("Precio: ");
			File fichero = new File("data/libros.dat");
			flujoSalida = new DataOutputStream(new FileOutputStream(fichero, true));
			flujoSalida.writeInt(codigo);
			flujoSalida.writeUTF(titulo);
			flujoSalida.writeUTF(escritor);
			flujoSalida.writeInt(agnoPublicacion);
			flujoSalida.writeDouble(precio);
			System.out.println("Se han escrito los datos de un libro en el fichero binario.");
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
