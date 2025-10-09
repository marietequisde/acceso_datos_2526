package principal;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConsultarVideojuegos {
    
    private static final String CONECTER_SQLITE = "org.sqlite.JDBC";
    private static final String URL_SQLITE_BD = "jdbc:sqlite:data/gaming.db";

    public static void main(String[] args) {
         Class.forName(CONECTER_SQLITE);
         Connection conexion = DriverManager.getConnection(URL_SQLITE_BD);

    }

}
