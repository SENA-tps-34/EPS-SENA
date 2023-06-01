
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ResultsetRow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    // URL de la base de datos
    public static final String URL = "jdbc:mysql://localhost:3306/gestionmedica";

    // Nombre de usuario y contraseña para acceder a la base de datos
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    /**
     * Establece una conexión con la base de datos.
     */
    public static void conectart() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // Aquí puedes realizar operaciones en la base de datos utilizando la conexión establecida
            // ...
            connection.close(); // Cierra la conexión cuando hayas terminado
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
