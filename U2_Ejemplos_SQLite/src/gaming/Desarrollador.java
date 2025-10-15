package gaming;

public class Desarrollador {

	private int codigo;
	private String nombre;
	private int anioFundacion;
	private String sedeCentral;
	private String sitioWeb;

	public Desarrollador(int codigo, String nombre, 
	                     int anioFundacion, String sedeCentral, String sitioWeb) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.anioFundacion = anioFundacion;
		this.sedeCentral = sedeCentral;
		this.sitioWeb = sitioWeb;
	}

	public Desarrollador(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return 
			"Desarrollador {Código = " + codigo + 
			", Nombre = " + nombre + 
			", AñoFundación = " + anioFundacion + 
			", SedeCentral = " + sedeCentral + 
			", SitioWeb = " + sitioWeb + "}";
	}

	public int getCodigo() {
		return codigo;
	}

}
