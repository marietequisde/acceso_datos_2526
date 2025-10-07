package x2_videojuegos_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import entrada.Teclado;

public class BuscarVideojuegoEnFichero {

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
	 * Lee por teclado un código.
	 * Busca un videojuego en el fichero binario por código.
	 * Si la búsqueda no devuelve ningún videojuego con el código, 
	 * escribe en consola un mensaje de videojuego no encontrado o un mensaje de videojuego ya eliminado.
	 * Si la búsqueda devuelve un videojuego con el código,
	 * escribe en consola el videojuego.
	 */
  	public static void main(String[] args) {
		RandomAccessFile flujoEntrada = null;
		try {
			int codigo = Teclado.leerEntero("Código: ");
			File fichero = new File("data/videojuegos.dat");
			flujoEntrada = new RandomAccessFile(fichero, "r");
			int posicion = (codigo - 1) * Videojuego.TAMAGNO_REGISTRO;
			if (posicion < 0 || posicion >= flujoEntrada.length()) {
				System.out.println("No se ha encontrado ningún videojuego con código " + codigo + " en el fichero binario.");
			}
			else {
				flujoEntrada.seek(posicion);
				Videojuego videojuego = leerVideojuego(flujoEntrada);
				if (videojuego.getCodigo() > 0) {
					System.out.println(videojuego.toString());
				}
				else {
					System.out.println("El videojuego ha sido eliminado del fichero binario.");
				}
			}
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
