package modelo;

public class Desarrollador {

    private int codigo;
    private String nombre;
    private String sedeCentral;
    private int anioFundacion;

    public Desarrollador(int codigo, String nombre, String sedeCentral, int anioFundacion) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.sedeCentral = sedeCentral;
        this.anioFundacion = anioFundacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSedeCentral() {
        return sedeCentral;
    }

    public void setSedeCentral(String sedeCentral) {
        this.sedeCentral = sedeCentral;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    @Override
    public String toString() {
        return "Desarrollador [codigo=" + codigo + ", nombre=" + nombre + ", sedeCentral=" + sedeCentral
                + ", anioFundacion=" + anioFundacion + "]";
    }

}
