
package proyectoeps;


    import com.mysql.cj.protocol.Resultset ;
    import com.mysql.cj.protocol.ResultsetRow ;
    import java.sql.Connection ;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement ;
    import java.sql.ResultSet ;
    import java.sql.SQLException ;
    import java.sql.Statement ;

    class Conexion {

        public static final String URL = "jdbc:mysql://localhost:3306/gestionmedica";
        public static final String USERNAME = "root";
        public static final String PASSWORD = "";

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

        public static void paciente() {

            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                PreparedStatement req = connection.prepareStatement(URL);
                ResultSet response = req.executeQuery("SELECT * FROM PACIENTES");
                while (response.next()) {

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

        public static void main(String[] args) {
            paciente();
        }

    }


