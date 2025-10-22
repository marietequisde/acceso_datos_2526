package actividad1.acceso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import actividad1.auxiliar.Resultado;
import actividad1.modelo.Escritor;
import util.Fechas;

public class AccesoLibreria {

    public static Escritor consultarEscritor(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Escritor escritor = null;
        try {
            conexion = SQLiteUtil.abrirConexion();
            String sql = "SELECT * FROM escritor " + "WHERE codigo = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, codigo);
            ResultSet resultados = sentencia.executeQuery();

            if (resultados.next()) {
                escritor = obtenerEscritor(resultados);
            }

        } finally {
            SQLiteUtil.cerrarConexion(conexion);
        }
        return escritor;
    }

    public static List<Escritor> consultarEscritores(Date fechaNacimientoIni, Date fechaNacimientoFin)
            throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        List<Escritor> escritores = new ArrayList<>();
        try {
            conexion = SQLiteUtil.abrirConexion();
            String sql = "SELECT * FROM escritor " + "WHERE fecha_nacimiento " + "BETWEEN ? AND ?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, fechaNacimientoIni.toString());
            sentencia.setString(2, fechaNacimientoFin.toString());
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {
                escritores.add(obtenerEscritor(resultados));
            }

            resultados.close();
            sentencia.close();

        } finally {
            SQLiteUtil.cerrarConexion(conexion);
        }
        return escritores;
    }

    public static List<Resultado> consultarTituloAnyoPrecioAsc(double precioMin, double precioMax)
            throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        List<Resultado> libros = new ArrayList<>();
        try {
            conexion = SQLiteUtil.abrirConexion();
            String sql = "SELECT titulo, anio_publicacion, precio FROM libro " + "WHERE precio "
                    + "BETWEEN ? AND ? ORDER BY precio ASC";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setDouble(1, precioMin);
            sentencia.setDouble(2, precioMax);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {
                libros.add(obtenerResultado6(resultados));
            }

            resultados.close();
            sentencia.close();

        } finally {
            SQLiteUtil.cerrarConexion(conexion);
        }
        return libros;
    }

    public static int insertarEscritor(Escritor escritor) throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        try {
            conexion = SQLiteUtil.abrirConexion();
            String sql = "INSERT INTO escritor (nombre, nacionalidad, fecha_nacimiento, fecha_fallecimiento) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, escritor.getNombre());
            sentencia.setString(2, escritor.getNacionalidad());
            sentencia.setString(3, escritor.getFechaNacimiento().toString());
            if (escritor.getFechaFallecimiento() != null) {
                sentencia.setString(4, escritor.getFechaFallecimiento().toString());
            } else {
                sentencia.setString(4, null);
            }

            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            int codigo = -1;
            if (resultado.next()) {
                codigo = resultado.getInt(1);
            }
            return codigo;
        }

        finally {
            SQLiteUtil.cerrarConexion(conexion);
        }
    }

    private static Escritor obtenerEscritor(ResultSet resultados) throws SQLException {
        int codigo = resultados.getInt("codigo");
        String nombre = resultados.getString("nombre");
        String nacionalidad = resultados.getString("nacionalidad");
        String fechaNacimiento = resultados.getString("fecha_nacimiento");
        String fechaFallecimiento = resultados.getString("fecha_fallecimiento");

        return new Escritor(codigo, nombre, nacionalidad, Fechas.parsearFecha(fechaNacimiento),
                Fechas.parsearFecha(fechaFallecimiento));
    }

    private static Resultado obtenerResultado6(ResultSet resultados) throws SQLException {
        String titulo = resultados.getString("titulo");
        int anio = resultados.getInt("anio_publicacion");
        double precio = resultados.getDouble("precio");
        Resultado resultado = new Resultado();
        resultado.ponerCampo("titulo", titulo);
        resultado.ponerCampo("anio", anio + "");
        resultado.ponerCampo("precio", precio + "");
        return resultado;
    }

}
