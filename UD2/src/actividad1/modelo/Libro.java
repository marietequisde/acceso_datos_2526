package actividad1.modelo;

public class Libro {
    private int codigo;
    private Escritor escritor;
    private String titulo;
    private int anioPublicacion;
    private int extension;
    private double precio;

    public Libro(int codigo, Escritor escritor, String titulo, int anioPublicacion, int extension, double precio) {
        super();
        this.codigo = codigo;
        this.escritor = escritor;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.extension = extension;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
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

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro [codigo=" + codigo + ", escritor=" + escritor.toString() + ", titulo=" + titulo
                + ", anioPublicacion=" + anioPublicacion + ", extension=" + extension + ", precio=" + precio + "]";
    }

}
