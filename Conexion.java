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

    /**
     * Recupera los datos de la tabla "PACIENTES" de la base de datos y los muestra en la consola.
     */
    public static void paciente() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement req = connection.prepareStatement(URL);
            ResultSet response = req.executeQuery("SELECT * FROM PACIENTES");
            while (response.next()) {
                // Obtén los datos de cada fila de la tabla
                int data = response.getRow();
                System.out.println(data);
                System.out.println(response.getString(1));
                System.out.println(response.getString(2));
                System.out.println(response.getString(3));
                System.out.println(response.getString(4));
            }
          
            

            System.out.println("no hay mas datos");

            // Cierra la conexión cuando hayas terminado
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void citas() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement req = connection.prepareStatement(URL);
            ResultSet response = req.executeQuery("SELECT * FROM CITAS");
            while (response.next()) {
                // Obtén los datos de cada fila de la tabla
                int data = response.getRow();
                System.out.println(data);
                System.out.println(response.getString(1));
                System.out.println(response.getString(2));
                System.out.println(response.getString(3));
                System.out.println(response.getString(4));
                System.out.println(response.getString(5));
                System.out.println(response.getString(6));
                System.out.println(response.getString(7));
                System.out.println(response.getString(8));
            }

            System.out.println("no hay mas datos");

            // Cierra la conexión cuando hayas terminado
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void consultorios() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement req = connection.prepareStatement(URL);
            ResultSet response = req.executeQuery("SELECT * FROM CONSULTORIOS");
            while (response.next()) {
                // Obtén los datos de cada fila de la tabla
                int data = response.getRow();
                System.out.println(data);
                System.out.println(response.getString(1));
                System.out.println(response.getString(2));

            }

            System.out.println("no hay mas datos");

            // Cierra la conexión cuando hayas terminado
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void medicos() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement req = connection.prepareStatement(URL);
            ResultSet response = req.executeQuery("SELECT * FROM MEDICOS");
            while (response.next()) {
                // Obtén los datos de cada fila de la tabla
                int data = response.getRow();
                System.out.println(data);
                System.out.println(response.getString(1));
                System.out.println(response.getString(2));
                System.out.println(response.getString(3));

            }

            System.out.println("no hay mas datos");

            // Cierra la conexión cuando hayas terminado
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public static void tratamientos() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement req = connection.prepareStatement(URL);
            ResultSet response = req.executeQuery("SELECT * FROM TRATAMIENTOS");
            while (response.next()) {
                // Obtén los datos de cada fila de la tabla
                int data = response.getRow();
                System.out.println(data);
                System.out.println(response.getString(1));
                System.out.println(response.getString(2));
                System.out.println(response.getString(3));
                System.out.println(response.getString(4));
                System.out.println(response.getString(5));
                System.out.println(response.getString(6));
                System.out.println(response.getString(7));

            }

            System.out.println("no hay mas datos");

            // Cierra la conexión cuando hayas terminado
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Llama al método "paciente" para mostrar los datos de la tabla "PACIENTES"
        paciente();
        citas();
        consultorios();
        medicos();
        tratamientos();

    }
}
