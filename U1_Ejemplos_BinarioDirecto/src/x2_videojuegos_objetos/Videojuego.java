package x2_videojuegos_objetos;

public class Videojuego {
	
	// atributos de clase
	public static final int LONGITUD_TITULO = 40;
	public static final int LONGITUD_DESARROLLADOR = 20;
	public static final int TAMAGNO_REGISTRO = LONGITUD_TITULO * 2 + LONGITUD_DESARROLLADOR * 2 + 16;
	
	// atributos de cada videojuego
	private int codigo;            // 4 bytes
	private String titulo;         // 40 caracteres de 2 bytes = 80 bytes
	private String desarrollador;  // 20 caracteres de 2 bytes = 40 bytes
	private int agnoLanzamiento;   // 4 bytes
	private double precio;         // 8 bytes
	
	/**
	 * Crea un videojuego a partir de un código, un título, un desarrollador,
	 * un año de lanzamiento y un precio.
	 */
	public Videojuego(int codigo, String titulo, String desarrollador, 
	                  int agnoLanzamiento, double precio) {
		this.codigo = codigo;
		StringBuffer buffer = new StringBuffer(titulo);
		buffer.setLength(LONGITUD_TITULO);
		this.titulo = buffer.toString();
		buffer = new StringBuffer(desarrollador);
		buffer.setLength(LONGITUD_DESARROLLADOR);
		this.desarrollador = buffer.toString();
		this.agnoLanzamiento = agnoLanzamiento;
		this.precio = precio;
	}
	
	/**
	 * Devuelve una cadena con el estado del videojuego.
	 */
	@Override
	public String toString() {
		return 
			"Videojuego {Código = " + codigo +
			", Título = " + titulo.trim() +
			", Desarrollador = " + desarrollador.trim() +
			", AñoLanzamiento = " + agnoLanzamiento +
			", Precio = " + String.format("%.2f", precio) + "}";
	}

	/**
	 * Devuelve el código del videojuego.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Devuelve el título del videojuego.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Devuelve el desarrollador del videojuego.
	 */
	public String getDesarrollador() {
		return desarrollador;
	}

	/**
	 * Devuelve el año de lanzamiento del videojuego.
	 */
	public int getAgnoLanzamiento() {
		return agnoLanzamiento;
	}

	/**
	 * Devuelve el precio del videojuego.
	 */
	public double getPrecio() {
		return precio;
	}

}
