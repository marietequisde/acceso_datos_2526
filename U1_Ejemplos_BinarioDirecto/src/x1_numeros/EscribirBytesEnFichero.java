package x1_numeros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

import entrada.Teclado;

public class EscribirBytesEnFichero {
	
	/**
	 * Genera un vector de longitud dada por una capacidada y 
	 * con número reales aleatorios comprendidos entre un mínimo y un máximo.
	 * Devuelve el vector de números reales generado.
	 */
	public static double[] generarVectorAleatorio(int capacidad, double minimo, double maximo) {
		Random aleatorio = new Random();
		double[] vectorReales = new double[capacidad];
		for (int posicion = 0 ; posicion < vectorReales.length ; posicion++) {
			vectorReales[posicion] = aleatorio.nextDouble() * (maximo - minimo) + minimo;
		}
		return vectorReales;
	}
	
	/**
	 * Lee por teclado un número de notas.
	 * Genera de forma aleatoria un vector de la capacidad dada y con notas comprendidas entre 0,0 y 10,0.
	 * Escribe en consola el vector de notas generado.
	 * Escribe desde el principio del fichero binario el vector de notas como datos.
	 * Escribe en consola el número de notas escritas en el fichero binario.
	 */
	public static void main(String[] args) {
		RandomAccessFile flujoSalida = null;
		try {
			int numeroNotas = Teclado.leerNatural("Número de Notas: ");
			double[] vectorNotas = generarVectorAleatorio(numeroNotas, 0.0, 10.0);
			System.out.println(Arrays.toString(vectorNotas));
			File fichero = new File("data/notas.dat");
			flujoSalida = new RandomAccessFile(fichero, "rw");
			flujoSalida.seek(0);
			flujoSalida.writeInt(vectorNotas.length);
			for (int posicion = 0 ; posicion < vectorNotas.length ; posicion++) {
				flujoSalida.writeDouble(vectorNotas[posicion]);
			}
			System.out.println("Se han escrito " + vectorNotas.length + " notas en el fichero binario.");
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
