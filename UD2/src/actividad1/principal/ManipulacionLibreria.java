package actividad1.principal;

import java.sql.SQLException;

import actividad1.acceso.AccesoLibreria;
import actividad1.modelo.Escritor;
import entrada.Teclado;
import util.Fechas;

public class ManipulacionLibreria {
    public static void main(String[] args) {
        int opcion;
        do {
            escribirMenuOpciones();
            opcion = Teclado.leerEntero("opcion: ");

            try {
                switch (opcion) {
                case 0:

                    break;

                case 1:
                    insertarEscritor(new Escritor(Teclado.leerCadena("Nombre: "), Teclado.leerCadena("Nacionalidad: "),
                            Fechas.parsearFecha(Teclado.leerCadena("Fecha de nacimiento: ")),
                            Fechas.parsearFecha(Teclado.leerCadena("Fecha de fallecimiento (dejar en blanco si no): "))));
                    break;
                default:
                    System.out.println("No implementado");
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 0);

    }

    private static void escribirMenuOpciones() {
        System.out.println();
        System.out.println("(1) Insertar un escritor en la base de datos.\r\n"
                + "(2) Insertar un libro asociado a un escritor en la base de datos.\r\n"
                + "(3) Actualizar el nombre, la nacionalidad, la fecha de nacimiento y la fecha de fallecimiento de un escritor de la base de datos por código.\r\n"
                + "(4) Actualizar el precio de los libros de un escritor de la base de datos con un descuento.\r\n"
                + "(5) Eliminar los escritores de la base de datos que están vivos y han alcanzado al menos una edad.\r\n"
                + "(6) Eliminar los libros de la base de datos que tienen un tamaño entre dos extensiones.");
        System.out.println();
    }

    private static void insertarEscritor(Escritor escritor) {
        int codigo;
        try {
            codigo = AccesoLibreria.insertarEscritor(escritor);
            if (codigo >= 0) {
                System.out.println("Se ha insertado un escritor con código " + codigo + " en la base de datos.");
            } else {
                System.out.println("Error al insertar un escritor, código: " + codigo);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
