
package Modelo;
import Core.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    
    static Conexion conn = new Conexion();
    static Connection connect = conn.conectart();
  
    public String GetAllUsuario(String sql){
        String tipoUsuario = null;
        try{
            PreparedStatement stmt = connect.prepareStatement(sql);
            ResultSet response = stmt.executeQuery();
            if(response.next()){
                tipoUsuario = response.getString("IdRoles");
            }else{
                tipoUsuario = null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tipoUsuario;
    }
     
    public boolean GetUsuarioById(int id){
        try{
            String sql = "SELECT * FROM usuarios WHERE Identificacion=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet response = stmt.executeQuery();
            if(response.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
