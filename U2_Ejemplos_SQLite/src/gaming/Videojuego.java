package gaming;

public class Videojuego {

	private int codigo;
	private Desarrollador desarrollador;
	private String titulo;
	private int anioLanzamiento;
	private String genero;
	private double precio;

	public Videojuego(int codigo, Desarrollador desarrollador, String titulo, 
	                  int anioLanzamiento, String genero, double precio) {
		this.codigo = codigo;
		this.desarrollador = desarrollador;
		this.titulo = titulo;
		this.anioLanzamiento = anioLanzamiento;
		this.genero = genero;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return 
			"Videojuego {C�digo = " + codigo + 
			", C�digoDesarrollador = " + desarrollador.getCodigo() + 
			", T�tulo = " + titulo + 
			", A�oLanzamiento = " + anioLanzamiento + 
			", G�nero = " + genero + 
			", Precio = " + String.format("%.2f", precio) + "}";
	}

}
