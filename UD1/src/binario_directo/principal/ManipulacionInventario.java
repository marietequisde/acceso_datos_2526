package binario_directo.principal;

import java.io.IOException;
import java.util.List;

import binario_directo.acceso.AccesoProducto;
import binario_directo.modelo.Categoria;
import binario_directo.modelo.Producto;
import entrada.Teclado;
import util.modelo.Fecha;

public class ManipulacionInventario {

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
                    escribirProducto("nombreTest", "Calzado", new Fecha("03/03/2003"), 13, 3.5);
                    break;
                case 2:
                    actualizarProducto(Teclado.leerEntero("Código: "), new Fecha("06/07/2008"), 10, 5.25);
                    break;
                case 3:
                    System.out.println("No implementado.");
                    break;
                case 4:
                    eliminarProducto(Teclado.leerEntero("Código: "));
                    break;
                case 5:
                    System.out.println("No implementado.");
                    break;
                case 6:
                    System.out.println("No implementado.");
                    break;
                default:
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 0);
    }

    private static void escribirProducto(String nombre, String categoria, Fecha fecha, int cantidad, double precio) {
        Producto newProducto = new Producto(nombre, Categoria.valueOf(categoria), fecha, cantidad, precio);
        try {
            AccesoProducto.escribirProducto(newProducto);
            System.out.println("Producto insertado en el fichero.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void actualizarProducto(int codigo, Fecha fechaModificacion, int cantidad, double precio) {
        try {
            if (AccesoProducto.actualizarProducto(codigo, fechaModificacion, cantidad, precio)) {
                System.out.println("Producto actualizado del fichero.");
            } else {
                System.out.println("Producto no encontrado con el código en el fichero.");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void eliminarProducto(int codigo) {
        try {
            if (AccesoProducto.eliminarProducto(codigo)) {
                System.out.println("Producto eliminado del fichero.");
            } else {
                System.out.println("Producto no encontrado con el código en el fichero.");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void escribirMenuOpciones() {
        System.out.println();
        System.out.println("(0) Salir.");
        System.out.println("(1) Insertar un producto en el fichero.");
        System.out.println(
                "(2) Actualizar la fecha de modificación, la cantidad y el precio de un producto del fichero por código.");
        System.out.println(
                "(3) Actualizar el precio de los productos del fichero que pertenecen a una categoría con un descuento.");
        System.out.println("(4) Eliminar un producto del fichero por código.");
        System.out.println(
                "(5) Eliminar los productos del fichero que no están disponibles y no han sido modificados en un número de días.");
        System.out.println();
    }

}
