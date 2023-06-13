package Modelo;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Consultas extends Conexion {
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
                System.out.println(response.getString(5));
                System.out.println(response.getString(6));
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
                System.out.println(response.getString(4));

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
