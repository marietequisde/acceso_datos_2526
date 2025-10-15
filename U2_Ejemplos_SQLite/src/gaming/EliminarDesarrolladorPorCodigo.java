package gaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entrada.Teclado;

public class EliminarDesarrolladorPorCodigo {

	/**
	 * Lee por teclado el c�digo de un desarrollador a eliminar.
	 * Elimina el videojuego de la base de datos identificado mediante un c�digo.
	 * Escribe en consola el n�mero de videojuegos eliminados de la base de datos.
	 */
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			int codigo = Teclado.leerEntero("C�digo: ");
			conexion = SQLiteUtil.abrirConexion();
			String sql = "DELETE FROM desarrollador " +
			             "WHERE codigo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigo);
			int numeroVideojuegos = sentencia.executeUpdate();
			if (numeroVideojuegos > 0) {
				System.out.println("Se ha eliminado un desarrollador de la base de datos.");
			}
			else {
				System.out.println("No se ha encontrado ning�n desarrollador con el c�digo en la base de datos.");
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
