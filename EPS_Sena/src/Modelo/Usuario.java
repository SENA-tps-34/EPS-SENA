
package Modelo;
import Core.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Usuario {
    
    static Conexion conn = new Conexion();
    static Connection connect = conn.conectart();
    
    public String TipoDocumento;
    public int Documento;
    public String Nombre;
    public Date Fecha_Nacimiento;
    public String Sexo;
    public String Contraseña;
    public String Consultorio;
    public int rol;
    
    public boolean AddUsuario(){
        boolean respon = false;
        try{
            
            String sql = "INSERT INTO usuarios(TipoDocumento,Identificacion,Nombre,Fecha_Nacimiento,Sexo,Contraseña,Consultorio_Medico,IdRoles) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, TipoDocumento);
            stmt.setInt(2, Documento);
            stmt.setString(3, Nombre);
            stmt.setDate(4, Fecha_Nacimiento);
            stmt.setString(5, Sexo);
            stmt.setString(6, Contraseña);
            stmt.setString(7, Consultorio);
            stmt.setInt(8, rol);
            int response = stmt.executeUpdate();
            if(response > 0){
                respon = true;
            }else{
                respon = false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            respon = false;
        }
        return respon;
    }
  
    public ResultSet GetAllUsuario(String sql){
        ResultSet response = null;
        try{
            PreparedStatement stmt = connect.prepareStatement(sql);
            response = stmt.executeQuery();
            if(response.next()){
                return response;    
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return response;
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
