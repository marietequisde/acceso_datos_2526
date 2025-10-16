package actividad1.acceso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import actividad1.modelo.Escritor;
import actividad1.modelo.Libro;

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

    private static Escritor obtenerEscritor(ResultSet resultados) throws SQLException {
        int codigo = resultados.getInt("codigo");
        String nombre = resultados.getString("nombre");
        String nacionalidad = resultados.getString("nacionalidad");
        String fechaNacimiento = resultados.getString("fecha_nacimiento");
        String fechaFallecimiento = resultados.getString("fecha_fallecimiento");

        return new Escritor(codigo, nombre, nacionalidad, parsearFecha(fechaNacimiento),
                parsearFecha(fechaFallecimiento));
    }

    /*
     * private static Libro obtenerLibro(ResultSet resultados) throws SQLException {
     * int codigo = resultados.getInt("codigo"); Escritor escritor = con String
     * nacionalidad = resultados.getString("nacionalidad"); String fechaNacimiento =
     * resultados.getString("fecha_nacimiento"); String fechaFallecimiento =
     * resultados.getString("fecha_fallecimiento");
     * 
     * return new Escritor(codigo, nombre, nacionalidad,
     * parsearFecha(fechaNacimiento), parsearFecha(fechaFallecimiento)); }
     */

    private static Date parsearFecha(String cadenaFecha) {
        Date fecha = null;

        if (cadenaFecha != null) {
            fecha = Date.valueOf(cadenaFecha);
        }

        return fecha;
    }

}
