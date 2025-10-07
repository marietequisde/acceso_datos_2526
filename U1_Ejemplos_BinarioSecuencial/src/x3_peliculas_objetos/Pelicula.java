package x3_peliculas_objetos;

import java.io.Serializable;

public class Pelicula implements Serializable {
	
	// número de versión de la clase
	// Verifica que el escritor y el lector del alumno serializado son compatibles.
	private static final long serialVersionUID = 1L;
	
	// atributos de cada película
	private int codigo;
	private String titulo;
	private String director;
	private int agnoEstreno;
	private double puntuacion;
	
	/**
	 * Crea una película a partir de un código, un título, un director,
	 * un año de estreno y una puntuación.
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
	 * Devuelve una cadena con el estado de la película.
	 */
	@Override
	public String toString() {
		return 
			"Película {Código = " + codigo +
			", Título = " + titulo +
			", Director = " + director +
			", AñoEstreno = " + agnoEstreno +
			", Puntuación = " + String.format("%.1f", puntuacion) +
			"}";
	}
		
}
