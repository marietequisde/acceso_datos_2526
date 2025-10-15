package gaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarDesarrolladores {

	/**
	 * Escribe en consola una lista de desarrolladores.
	 */
	public static void escribirListaDesarrolladores(List<Desarrollador> listaDesarrolladores) {
		for (Desarrollador desarrollador : listaDesarrolladores) {
			System.out.println(desarrollador.toString());
		}
		System.out.println("Se han consultado " + listaDesarrolladores.size() + " desarrolladores de la base de datos.");
	}
	
	/**
	 * Consulta los desarrolladores de la base de datos, en orden por nombre ascendente.
	 * Escribe en consola una lista con los desarrolladores seleccionados de la base de datos.
	 */
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			conexion = SQLiteUtil.abrirConexion();
			String sql = "SELECT * FROM desarrollador " +
			             "ORDER BY nombre ASC";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultados = sentencia.executeQuery();
			List<Desarrollador> listaDesarrolladores = new ArrayList<Desarrollador>();
			while (resultados.next()) {
				int codigo = resultados.getInt("codigo");
				String nombre = resultados.getString("nombre");
				int anioFundacion = resultados.getInt("anio_fundacion");
				String sedeCentral = resultados.getString("sede_central");
				String sitioWeb = resultados.getString("sitio_web");
				Desarrollador desarrollador = new Desarrollador(codigo, nombre, anioFundacion, sedeCentral, sitioWeb);
				listaDesarrolladores.add(desarrollador);
			}
			if (listaDesarrolladores.isEmpty()) {
				System.out.println("No se ha encontrado ningún desarrollador en la base de datos.");
			}
			else {
				escribirListaDesarrolladores(listaDesarrolladores);
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
