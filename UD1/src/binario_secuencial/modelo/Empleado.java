package binario_secuencial.modelo;

import java.io.Serializable;

import util.modelo.Fecha;

public class Empleado implements Serializable {

    private int codigo;
    private String nombre;
    private String apellido;
    private Fecha fechaAlta;
    private String departamento;
    private double salario;

    public Empleado(int codigo, String nombre, String apellido, Fecha fechaAlta, String departamento, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Fecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaAlta="
                + fechaAlta + ", departamento=" + departamento + ", salario=" + salario + "]";
    }

}
