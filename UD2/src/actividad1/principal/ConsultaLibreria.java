package actividad1.principal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import actividad1.acceso.AccesoLibreria;
import actividad1.auxiliar.Resultado;
import actividad1.modelo.Escritor;
import entrada.Teclado;
import util.Consola;

public class ConsultaLibreria {

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
                    consultarEscritor(Teclado.leerEntero("Codigo: "));
                    break;

                case 3:
                    consultarEscritores(Consola.leerFecha("Fecha ini: "), Consola.leerFecha("Fecha fin: "));
                    break;

                case 6:
                    consultarTituloAnyoPrecioAsc(Teclado.leerReal("Precio min: "), Teclado.leerReal("Precio max: "));
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
        System.out.println("(1) Consultar un escritor de la base de datos por código.\r\n"
                + "(2) Consultar un libro de la base de datos por código.\r\n"
                + "(3) Consultar los escritores de la base de datos que han aparecido entre dos fechas de nacimiento.\r\n"
                + "(4) Consultar los libros de la base de datos que incluyen una palabra en el título.\r\n"
                + "(5) Consultar el nombre, la fecha de nacimiento y la fecha de fallecimiento de los escritores de la base de datos que tienen una nacionalidad, en orden por fecha de nacimiento descendente.\r\n"
                + "(6) Consultar el título, el año de publicación y el precio de los libros de la base de datos que están valorados entre dos precios, en orden por precio ascendente.\r\n"
                + "(7) Consultar el número y los nombres de los escritores de cada nacionalidad de la base de datos.\r\n"
                + "(8) Consultar el número y el precio medio de los libros de cada escritor de la base de datos.");
        System.out.println();
    }

    private static void consultarEscritor(int codigo) {
        try {
            Escritor escritor = AccesoLibreria.consultarEscritor(codigo);
            if (escritor != null) {
                System.out.println(escritor.toString());
            } else {
                System.out.println("Ecritor no encontrado con el código en la base de datos.");
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void consultarEscritores(Date fechaNacimientoIni, Date fechaNacimientoFin) {
        try {
            List<Escritor> leidos = AccesoLibreria.consultarEscritores(fechaNacimientoIni, fechaNacimientoFin);
            if (leidos.isEmpty()) {
                System.out.println("Escritores no encontrados en el fichero.");
            }
            for (Escritor escritor : leidos) {
                System.out.println(escritor.toString());
            }
            System.out.println("Se han consultado " + leidos.size() + " registros.");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void consultarTituloAnyoPrecioAsc(double precioMin, double precioMax) {
        try {
            List<Resultado> leidos = AccesoLibreria.consultarTituloAnyoPrecioAsc(precioMin, precioMax);
            if (leidos.isEmpty()) {
                System.out.println("Registros no encontrados en el fichero.");
            }
            for (Resultado resultado6 : leidos) {
                System.out.println(resultado6.toString());
            }
            System.out.println("Se han consultado " + leidos.size() + " registros.");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
