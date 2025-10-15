package gaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entrada.Teclado;

public class InsertarVideojuego {

	/**
	 * Lee por teclado el c�digo de desarrollador, el t�tulo, el a�o de lanzamiento, el g�nero y el precio de un videojuego a insertar.
	 * Inserta un videojuego con c�digo autoincremental en la base de datos.
	 * Escribe en consola un mensaje de videojuego insertado.
	 */
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			int codigoDesarrollador = Teclado.leerEntero("C�digo de Desarrollador: ");
			String titulo = Teclado.leerCadena("T�tulo: ");
			int anioLanzamiento = Teclado.leerEntero("A�o de Lanzamiento: ");
			String genero = Teclado.leerCadena("G�nero: ");
			double precio = Teclado.leerReal("Precio: ");
			conexion = SQLiteUtil.abrirConexion();
			String sql = "INSERT INTO videojuego (codigo_desarrollador, titulo, anio_lanzamiento, genero, precio) " +
			             "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigoDesarrollador);
			sentencia.setString(2, titulo);
			sentencia.setInt(3, anioLanzamiento);
			sentencia.setString(4, genero);
			sentencia.setDouble(5, precio);
			sentencia.executeUpdate();
			ResultSet resultado = sentencia.getGeneratedKeys();
			int codigo = 0;
			if (resultado.next()) {
				codigo = resultado.getInt(1);
			}
			System.out.println("Se ha insertado un videojuego con c�digo " + codigo + " en la base de datos.");
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error al abrir una conexi�n con la base de datos SQLite.");
			cnfe.printStackTrace();
		} 
		catch (SQLException sqle) {
			System.out.println("Error al acceder a la base de datos SQLite.");
			sqle.printStackTrace();
		}
		finally {
			try {
				SQLiteUtil.cerrarConexion(conexion);
			} 
			catch (SQLException sqle) {
				System.out.println("Error al cerrar la conexi�n con la base de datos SQLite.");
				sqle.printStackTrace();
			}
		}
	}

}
