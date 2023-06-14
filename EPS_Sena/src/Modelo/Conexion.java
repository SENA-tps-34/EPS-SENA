package Modelo;


import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ResultsetRow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // URL de la base de datos
    public static final String URL = "jdbc:mysql://localhost:3306/gestionmedica";

    // Nombre de usuario y contraseña para acceder a la base de datos
    public static final String USERNAME = "root";
    public static final String PASSWORD = "laura";

    /**
     * Establece una conexión con la base de datos.
     * @return La conexión establecida
     */
    public static Connection conectart() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}