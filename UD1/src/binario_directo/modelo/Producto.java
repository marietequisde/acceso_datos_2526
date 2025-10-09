package binario_directo.modelo;

import util.constantes.Tamanyo;
import util.modelo.Fecha;

public class Producto {

    public static final int LONGITUD_NOMBRE = 15;
    public static final int TAMAGNO_REGISTRO = Tamanyo.INT + LONGITUD_NOMBRE * Tamanyo.CARACTER_STRING + Tamanyo.ENUM
            + Fecha.TAMAGNO_REGISTRO + Tamanyo.INT + Tamanyo.DOUBLE;

    private int codigo;
    private String nombre;
    private Categoria categoria;
    private Fecha fecha;
    private int cantidad;
    private double precio;

    public Producto(int codigo, String nombre, Categoria categoria, Fecha fecha, int cantidad, double precio) {
        super();
        this.codigo = codigo;
        this.nombre = nombre.trim();
        this.categoria = categoria;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, Categoria categoria, Fecha fecha, int cantidad, double precio) {
        super();
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void normalizarLargoStrings() {
        StringBuffer buffer = new StringBuffer(this.nombre);
        buffer.setLength(LONGITUD_NOMBRE);
        this.nombre = buffer.toString();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", fecha=" + fecha
                + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }

}
