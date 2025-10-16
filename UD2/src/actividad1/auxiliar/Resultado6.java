package actividad1.auxiliar;

public class Resultado6 {
    private String titulo;
    private int anioPublicacion;
    private double precio;

    public Resultado6(String titulo, int anioPublicacion, double precio) {
        super();
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Resultado6 [titulo=" + titulo + ", anioPublicacion=" + anioPublicacion + ", precio=" + precio + "]";
    }

}
