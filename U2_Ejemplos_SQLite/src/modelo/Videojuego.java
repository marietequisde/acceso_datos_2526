package modelo;

public class Videojuego {
    private int codigo;
    private String titulo;
    private int anioLanzamiento;
    private double precio;
    private Desarrollador desarrollador;

    public Videojuego(int codigo, String titulo, int anioLanzamiento, double precio, Desarrollador desarrollador) {
        super();
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.precio = precio;
        this.desarrollador = desarrollador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    @Override
    public String toString() {
        return "Videojuego [codigo=" + codigo + ", titulo=" + titulo + ", anioLanzamiento=" + anioLanzamiento
                + ", precio=" + precio + ", desarrollador=" + desarrollador.getCodigo() + "]";
    }

}
