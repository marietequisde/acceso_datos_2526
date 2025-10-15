package gaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entrada.Teclado;

public class ActualizarVideojuegosPorAnioLanzamiento {

	/**
	 * Lee por teclado un año de lanzamiento mínimo y un año de lanzamiento máximo.
	 * Actualiza el precio de los videojuegos de la base de datos estrenados entre dos años de lanzamiento con un descuento.
	 * Escribe en consola el número de videojuegos actualizados de la base de datos.
	 */
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			int anioLanzamientoMinimo = Teclado.leerEntero("Año de Lanzamiento Mínimo: ");
			int anioLanzamientoMaximo = Teclado.leerEntero("Año de Lanzamiento Máximo: ");
			double descuento = Teclado.leerReal("Descuento: ");
			conexion = SQLiteUtil.abrirConexion();
			String sql = "UPDATE videojuego " +
			             "SET precio = precio - (precio * ?) / 100 " +
			             "WHERE anio_lanzamiento BETWEEN ? AND ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setDouble(1, descuento);
			sentencia.setInt(2, anioLanzamientoMinimo);
			sentencia.setInt(3, anioLanzamientoMaximo);
			int numeroVideojuegos = sentencia.executeUpdate();
			if (numeroVideojuegos > 0) {
				System.out.println("Se han actualizado " + numeroVideojuegos + " videojuegos de la base de datos.");
			}
			else {
				System.out.println("No se ha encontrado ningún videojuego entre los dos años de lanzamiento en la base de datos.");
			}
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error al abrir una conexión con la base de datos SQLite.");
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
				System.out.println("Error al cerrar la conexión con la base de datos SQLite.");
				sqle.printStackTrace();
			}
		}
	}

}
