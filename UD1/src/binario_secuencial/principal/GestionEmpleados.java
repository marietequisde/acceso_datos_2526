package binario_secuencial.principal;

import java.util.List;

import binario_secuencial.acceso.AccesoEmpleado;
import binario_secuencial.modelo.Empleado;
import entrada.Teclado;
import util.Consola;
import util.modelo.Fecha;

public class GestionEmpleados {

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
                    List<Empleado> empleados = AccesoEmpleado.leerEmpleados();
                    System.out.println("numEmpleados: " + empleados.size());
                    for (Empleado empleado : empleados) {
                        System.out.println(empleado.toString());
                    }
                    break;
                case 2:
                    System.out.println(AccesoEmpleado.leerEmpleado(Teclado.leerEntero("idEmpleado: ")));
                    break;
                case 3:
                    AccesoEmpleado.escribirEmpleado(new Empleado(Teclado.leerEntero("idEmpleado: "), "nombretest",
                            "apellidotest", new Fecha(25, 9, 2025), "departamentotest", 999));
                    System.out.println("Empleado insertado en el fichero.");
                    break;

                case 4:
                    if (AccesoEmpleado.actualizarEmpleado(Teclado.leerEntero("codigo: "),
                            Teclado.leerCadena("nombre: "), Teclado.leerCadena("apellido: "),
                            Consola.leerFecha("fecha: "))) {
                        System.out.println("Empleado actualizado del fichero.");
                    } else {
                        System.out.println("Empleado no encontrado con el código en el fichero.");
                    }
                    break;

                case 5:
                    if (AccesoEmpleado.eliminarEmpleado(Teclado.leerEntero("codigo: "))) {
                        System.out.println("Empleado eliminado del fichero.");
                    } else {
                        System.out.println("Empleado no encontrado con el código en el fichero.");
                    }
                    break;
                default:
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 0);

    }

    public static void escribirMenuOpciones() {
        System.out.println();
        System.out.println("(0) Salir del programa.");
        System.out.println("(1) Consultar todos los empleados del fichero.");
        System.out.println("(2) Consultar un empleado del fichero por código.");
        System.out.println("(3) Insertar un empleado en el fichero.");
        System.out.println(
                "(4) Actualizar el nombre, el apellido y la fecha de alta de un empleado del fichero por código.");
        System.out.println("(5) Eliminar un empleado del fichero por código.");
        System.out.println();
    }

}
