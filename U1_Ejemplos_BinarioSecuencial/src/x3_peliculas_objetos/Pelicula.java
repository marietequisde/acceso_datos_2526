package x3_peliculas_objetos;

import java.io.Serializable;

public class Pelicula implements Serializable {
	
	// n�mero de versi�n de la clase
	// Verifica que el escritor y el lector del alumno serializado son compatibles.
	private static final long serialVersionUID = 1L;
	
	// atributos de cada pel�cula
	private int codigo;
	private String titulo;
	private String director;
	private int agnoEstreno;
	private double puntuacion;
	
	/**
	 * Crea una pel�cula a partir de un c�digo, un t�tulo, un director,
	 * un a�o de estreno y una puntuaci�n.
	 */
	public Pelicula(int codigo, String titulo, String director, 
	                int agnoEstreno, double puntuacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.agnoEstreno = agnoEstreno;
		this.puntuacion = puntuacion;
	}

	/**
	 * Devuelve una cadena con el estado de la pel�cula.
	 */
	@Override
	public String toString() {
		return 
			"Pel�cula {C�digo = " + codigo +
			", T�tulo = " + titulo +
			", Director = " + director +
			", A�oEstreno = " + agnoEstreno +
			", Puntuaci�n = " + String.format("%.1f", puntuacion) +
			"}";
	}
		
}
