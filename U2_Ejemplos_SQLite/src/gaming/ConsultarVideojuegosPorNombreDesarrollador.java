package gaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entrada.Teclado;

public class ConsultarVideojuegosPorNombreDesarrollador {

	/**
	 * Escribe en consola una lista de videojuegos.
	 */
	public static void escribirListaVideojuegos(List<Videojuego> listaVideojuegos) {
		for (Videojuego videojuego : listaVideojuegos) {
			System.out.println(videojuego.toString());
		}
		System.out.println("Se han consultado " + listaVideojuegos.size() + " videojuegos de la base de datos.");
	}
		
	/**
	 * Consulta los videojuegos de la base de datos con un nombre de desarrollador.
	 * Escribe en consola una lista con los videojuegos seleccionados de la base de datos.
	 */
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			String nombreDesarrollador = Teclado.leerCadena("Nombre de Desarrollador: ");
			conexion = SQLiteUtil.abrirConexion();
			String sql = "SELECT vi.* FROM videojuego vi " +
			             "JOIN desarrollador de ON de.codigo = vi.codigo_desarrollador " +
			             "WHERE de.nombre LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, nombreDesarrollador);
			ResultSet resultados = sentencia.executeQuery();
			List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
			while (resultados.next()) {
				int codigo = resultados.getInt("codigo");
				int codigoDesarrollador = resultados.getInt("codigo_desarrollador");
				String titulo = resultados.getString("titulo");
				int anioLanzamiento = resultados.getInt("anio_lanzamiento");
				String genero = resultados.getString("genero");
				double precio = resultados.getDouble("precio");
				Desarrollador desarrollador = new Desarrollador(codigoDesarrollador);
				Videojuego videojuego = new Videojuego(codigo, desarrollador, titulo, anioLanzamiento, genero, precio);
				listaVideojuegos.add(videojuego);
			}
			if (listaVideojuegos.isEmpty()) {
				System.out.println("No se ha encontrado ningún videojuego con el nombre de desarrollador en la base de datos.");
			}
			else {
				escribirListaVideojuegos(listaVideojuegos);
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
