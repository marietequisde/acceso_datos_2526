package binario_directo.principal;

import java.io.IOException;
import java.util.List;

import binario_directo.acceso.AccesoProducto;
import binario_directo.modelo.Producto;
import entrada.Teclado;

public class ConsultaInventario {

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
                    leerProductos();
                    break;
                case 2:
                    leerProducto(Teclado.leerEntero("Código: "));
                    break;
                case 3:
                    System.out.println("No implementado.");
                    break;
                case 4:
                    System.out.println("No implementado.");
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

    private static void leerProductos() {
        try {
            List<Producto> leidos = AccesoProducto.leerProductos();
            if (leidos.isEmpty()) {
                System.out.println("Productos no encontrados en el fichero.");
            }
            for (Producto producto : leidos) {
                System.out.println(producto.toString());
            }
            System.out.println("Se han consultado " + leidos.size() + " productos.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerProducto(int codigo) {
        try {
            Producto leido = AccesoProducto.leerProducto(codigo);
            if (leido != null) {
                System.out.println(leido.toString());
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
        System.out.println("(1) Consultar todos los productos del fichero.");
        System.out.println("(2) Consultar un producto del fichero por código.");
        System.out.println("(3) Consultar los productos del fichero que están valorados entre dos precios.");
        System.out.println("(4) Consultar los productos del fichero que están disponibles.");
        System.out.println(
                "(5) Consultar el nombre, la categoría y la fecha de modificación de los productos del fichero que han sido modificados entre dos fechas.");
        System.out
                .println("(6) Consultar el número y el precio máximo de los productos de cada categoría del fichero.");
        System.out.println();
    }

}
