package x2_videojuegos_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import entrada.Teclado;

public class EscribirVideojuegoEnFichero {

	/**
	 * Escribe un videojuego en el flujo de datos asociado a un fichero binario.
	 */
	private static void escribirVideojuego(Videojuego videojuego, RandomAccessFile flujoSalida) 
	throws IOException {
		flujoSalida.writeInt(videojuego.getCodigo());
		flujoSalida.writeChars(videojuego.getTitulo());
		flujoSalida.writeChars(videojuego.getDesarrollador());
		flujoSalida.writeInt(videojuego.getAgnoLanzamiento());
		flujoSalida.writeDouble(videojuego.getPrecio());
	}

	/**
	 * Lee por teclado los datos de un videojuego.
	 * Genera un código de forma autoincremental para el videojuego.
	 * Escribe al final del fichero binario el videojuego como datos.
	 */
  	public static void main(String[] args) {
		RandomAccessFile flujoSalida = null;
		try {
			String titulo = Teclado.leerCadena("Título: ");
			String desarrollador = Teclado.leerCadena("Desarrollador: ");
			int agnoLanzamiento = Teclado.leerEntero("Año de Lanzamiento: ");
			double precio = Teclado.leerReal("Precio: ");
			File fichero = new File("data/videojuegos.dat");
			flujoSalida = new RandomAccessFile(fichero, "rw");
			long tamagnoFichero = flujoSalida.length();
			int codigo = (int) (tamagnoFichero / Videojuego.TAMAGNO_REGISTRO + 1);
			Videojuego videojuego = new Videojuego(codigo, titulo, desarrollador, agnoLanzamiento, precio);
			flujoSalida.seek(tamagnoFichero);
			escribirVideojuego(videojuego, flujoSalida);
			System.out.println("Se ha escrito un videojuego en el fichero binario.");
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
