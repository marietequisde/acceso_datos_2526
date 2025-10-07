package x2_videojuegos_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerVideojuegosDeFichero {

	/**
	 * Lee un videojuego del flujo de datos asociado a un fichero binario.
	 * Devuelve el videojuego leído del flujo de datos.
	 */
	private static Videojuego leerVideojuego(RandomAccessFile flujoEntrada)
	throws IOException {
		int codigo = flujoEntrada.readInt();
		char[] vectorCaracteres = new char[Videojuego.LONGITUD_TITULO];
		for (int posicion = 0 ; posicion < vectorCaracteres.length ; posicion++) {         
			vectorCaracteres[posicion] = flujoEntrada.readChar(); 
		}
		String titulo = new String(vectorCaracteres);
		vectorCaracteres = new char[Videojuego.LONGITUD_DESARROLLADOR];
		for (int posicion = 0 ; posicion < vectorCaracteres.length ; posicion++) {         
			vectorCaracteres[posicion] = flujoEntrada.readChar(); 
		}
		String desarrollador = new String(vectorCaracteres);
		int agnoLanzamiento = flujoEntrada.readInt();
		double precio = flujoEntrada.readDouble();
		Videojuego videojuego = new Videojuego(codigo, titulo, desarrollador, agnoLanzamiento, precio);
		return videojuego;
	}
	
	/**
	 * Lee el fichero binario por objetos.
	 * Escribe en consola cada videojuego como objeto de datos del fichero binario.
	 * Escribe en consola el número de videojuegos leídos del fichero binario.
	 */
  	public static void main(String[] args) {
		RandomAccessFile flujoEntrada = null;
		try {
			File fichero = new File("data/videojuegos.dat");
			flujoEntrada = new RandomAccessFile(fichero, "r");
			flujoEntrada.seek(0);			
			int contador = 0;
			while (flujoEntrada.getFilePointer() < flujoEntrada.length()) {
				Videojuego videojuego = leerVideojuego(flujoEntrada);
				if (videojuego.getCodigo() > 0) {
					System.out.println(videojuego.toString());
					contador++;
				}
			}
			System.out.println("Se han leído " + contador + " videojuegos del fichero binario.");
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
