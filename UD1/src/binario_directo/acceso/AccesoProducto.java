package binario_directo.acceso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import binario_directo.modelo.Categoria;
import binario_directo.modelo.Producto;
import util.MiRandomAccessFile;
import util.modelo.Fecha;

public class AccesoProducto {
    private static String FICHERO = "data/productos.dat";

    public static void escribirProducto(Producto producto) throws IOException {

        MiRandomAccessFile flujoSalida = null;
        try {
            flujoSalida = obtenerMiFlujo(FICHERO, "rw");
            long tamagnoFichero = flujoSalida.length();
            int codigo = (int) (tamagnoFichero / Producto.TAMAGNO_REGISTRO + 1);
            producto.setCodigo(codigo);
            flujoSalida.seek(tamagnoFichero);

            escribirProducto(producto, flujoSalida);

        } finally {
            if (flujoSalida != null) {
                flujoSalida.close();
            }
        }
    }

    public static boolean actualizarProducto(int codigo, Fecha fechaModificacion, int cantidad, double precio)
            throws IOException {

        Producto producto = leerProducto(codigo);
        if (producto == null) {
            return false;
        }
        producto.setFecha(fechaModificacion);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);

        actualizarProducto(producto);
        return true;
    }

    public static int descuentoCategoria(Categoria categoria, double descuento) throws IOException {
        MiRandomAccessFile flujoEntrada = null;
        int numActualizados = 0;
        try {
            flujoEntrada = obtenerMiFlujo(FICHERO, "rw");
            flujoEntrada.seek(0);
            while (flujoEntrada.getFilePointer() < flujoEntrada.length()) {
                Producto productoLeido = leerProducto(flujoEntrada);

                if (productoLeido.getCodigo() > 0 && productoLeido.getCategoria().equals(categoria)) {
                    productoLeido.setPrecio(productoLeido.getPrecio() * descuento);
                    actualizarProducto(productoLeido);
                    numActualizados++;
                }
            }
        } finally {
            if (flujoEntrada != null) {
                flujoEntrada.close();
            }
        }

        return numActualizados;
    }

    public static boolean eliminarProducto(int codigo) throws IOException {
        MiRandomAccessFile flujoSalida = null;
        try {
            Producto producto = leerProducto(codigo);
            if (producto == null) {
                return false;
            }
            flujoSalida = obtenerMiFlujo(FICHERO, "rw");
            flujoSalida.seek(obtenerPosicionProducto(codigo));
            flujoSalida.writeInt(0);

        } finally {
            if (flujoSalida != null) {
                flujoSalida.close();
            }
        }
        return true;
    }

    public static List<Producto> leerProductos() throws IOException {
        MiRandomAccessFile flujoEntrada = null;
        List<Producto> productos = new ArrayList<>();

        try {
            flujoEntrada = obtenerMiFlujo(FICHERO, "r");
            flujoEntrada.seek(0);
            while (flujoEntrada.getFilePointer() < flujoEntrada.length()) {
                Producto productoLeido = leerProducto(flujoEntrada);
                if (productoLeido.getCodigo() > 0) {
                    productos.add(productoLeido);
                }
            }
        } finally {
            if (flujoEntrada != null) {
                flujoEntrada.close();
            }
        }

        return productos;
    }

    public static List<Producto> leerProductos(double minPrecio, double maxPrecio) throws IOException {
        MiRandomAccessFile flujoEntrada = null;
        List<Producto> productos = new ArrayList<>();

        try {
            flujoEntrada = obtenerMiFlujo(FICHERO, "r");
            flujoEntrada.seek(0);
            while (flujoEntrada.getFilePointer() < flujoEntrada.length()) {
                Producto productoLeido = leerProducto(flujoEntrada);
                if (productoLeido.getCodigo() > 0 && productoLeido.getPrecio() >= minPrecio
                        && productoLeido.getPrecio() <= maxPrecio) {
                    productos.add(productoLeido);
                }
            }
        } finally {
            if (flujoEntrada != null) {
                flujoEntrada.close();
            }
        }

        return productos;
    }
    
    public static List<Producto> leerProductosDisponibles() throws IOException {
        MiRandomAccessFile flujoEntrada = null;
        List<Producto> productos = new ArrayList<>();

        try {
            flujoEntrada = obtenerMiFlujo(FICHERO, "r");
            flujoEntrada.seek(0);
            while (flujoEntrada.getFilePointer() < flujoEntrada.length()) {
                Producto productoLeido = leerProducto(flujoEntrada);
                if (productoLeido.getCodigo() > 0 && productoLeido.getCantidad() > 0) {
                    productos.add(productoLeido);
                }
            }
        } finally {
            if (flujoEntrada != null) {
                flujoEntrada.close();
            }
        }

        return productos;
    }

    public static Producto leerProducto(int codigo) throws IOException {
        MiRandomAccessFile flujoEntrada = null;
        Producto producto = null;

        try {
            flujoEntrada = obtenerMiFlujo(FICHERO, "r");
            int posicion = obtenerPosicionProducto(codigo);
            if (posicion < 0 || posicion >= flujoEntrada.length()) {
                return null;
            }
            flujoEntrada.seek(posicion);
            producto = leerProducto(flujoEntrada);

        } finally {
            if (flujoEntrada != null) {
                flujoEntrada.close();
            }
        }

        if (producto.getCodigo() > 0) {
            return producto;
        }
        return null;
    }

    private static int obtenerPosicionProducto(int codigo) {
        return (codigo - 1) * Producto.TAMAGNO_REGISTRO;
    }

    private static Producto leerProducto(MiRandomAccessFile flujoEntrada) throws IOException {
        int codigo = flujoEntrada.readInt();

        char[] vectorCaracteres = new char[Producto.LONGITUD_NOMBRE];
        for (int posicion = 0; posicion < vectorCaracteres.length; posicion++) {
            vectorCaracteres[posicion] = flujoEntrada.readChar();
        }

        String nombre = new String(vectorCaracteres);
        int categoria = flujoEntrada.readInt();
        Fecha fecha = flujoEntrada.readFecha();
        int cantidad = flujoEntrada.readInt();
        double precio = flujoEntrada.readDouble();

        return new Producto(codigo, nombre, Categoria.values()[categoria], fecha, cantidad, precio);
    }

    private static void actualizarProducto(Producto producto) throws IOException {

        MiRandomAccessFile flujoSalida = null;
        try {
            flujoSalida = obtenerMiFlujo(FICHERO, "rw");
            flujoSalida.seek(obtenerPosicionProducto(producto.getCodigo()));

            escribirProducto(producto, flujoSalida);

        } finally {
            if (flujoSalida != null) {
                flujoSalida.close();
            }
        }
    }

    private static MiRandomAccessFile obtenerMiFlujo(String path, String modo) throws FileNotFoundException {
        return new MiRandomAccessFile(new File(FICHERO), modo);
    }

    private static void escribirProducto(Producto producto, MiRandomAccessFile flujoSalida) throws IOException {
        producto.normalizarLargoStrings();

        flujoSalida.writeInt(producto.getCodigo());
        flujoSalida.writeChars(producto.getNombre());
        flujoSalida.writeInt(producto.getCategoria().ordinal());
        flujoSalida.writeFecha(producto.getFecha());
        flujoSalida.writeInt(producto.getCantidad());
        flujoSalida.writeDouble(producto.getPrecio());
    }
}
