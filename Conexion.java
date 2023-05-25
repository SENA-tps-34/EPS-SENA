import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;




    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  Conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/gestionmedica";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static void main(String[] args) {


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

    


