package gaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entrada.Teclado;

public class ConsultarVideojuegoPorCodigo {
	
	/**
	 * Consulta el videojuego de la base de datos identificado mediante un c�digo.
	 * Escribe en consola el videojuego seleccionado de la base de datos, si la consulta devuelve un resultado.
	 * Escribe en consola un mensaje de videojuego no encontrado, si la consulta no devuelve ning�n resultado.
	 */
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			int codigo = Teclado.leerEntero("C�digo: ");
			conexion = SQLiteUtil.abrirConexion();
			String sql = "SELECT * FROM videojuego " +
			             "WHERE codigo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigo);
			ResultSet resultados = sentencia.executeQuery();
			Videojuego videojuego = null;
			if (resultados.next()) {
				int codigoDesarrollador = resultados.getInt("codigo_desarrollador");
				String titulo = resultados.getString("titulo");
				int anioLanzamiento = resultados.getInt("anio_lanzamiento");
				String genero = resultados.getString("genero");
				double precio = resultados.getDouble("precio");
				Desarrollador desarrollador = new Desarrollador(codigoDesarrollador);
				videojuego = new Videojuego(codigo, desarrollador, titulo, anioLanzamiento, genero, precio);
			}
			if (videojuego == null) {
				System.out.println("No se ha encontrado ning�n videojuego con el c�digo en la base de datos.");
			}
			else {
				System.out.println(videojuego.toString());
			}
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
