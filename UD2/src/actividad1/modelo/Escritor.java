package actividad1.modelo;

import java.sql.Date;

public class Escritor {
    private int codigo;
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;
    private Date fechaFallecimiento;

    public Escritor(int codigo, String nombre, String nacionalidad, Date fechaNacimiento, Date fechaFallecimiento) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    @Override
    public String toString() {
        return "Escritor [codigo=" + codigo + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
                + ", fechaNacimiento=" + fechaNacimiento + ", fechaFallecimiento=" + fechaFallecimiento + "]";
    }

}
