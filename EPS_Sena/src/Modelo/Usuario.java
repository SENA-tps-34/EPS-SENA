
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
    public int Consultorio;
    public int rol;
        
    public Usuario() {
    }
    
    public Usuario(String TipoDocumento, int Documento, String Nombre, int Consultorio){
        this.TipoDocumento=TipoDocumento;
        this.Documento=Documento;
        this.Nombre=Nombre;
        this.Consultorio=Consultorio;
    }
    
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
            stmt.setInt(7, Consultorio);
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
  
    public boolean UpdateUsuario(){
        boolean respon = false;
        try{
            String sql = "UPDATE usuarios SET TipoDocumento=?, Nombre=?, Fecha_Nacimiento=?, Sexo=?, Contraseña=?, "
                    + "Consultorio_Medico=?, IdRoles=? WHERE Identificacion=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, TipoDocumento);
            stmt.setString(2, Nombre);
            stmt.setDate(3, Fecha_Nacimiento);
            stmt.setString(4, Sexo);
            stmt.setString(5, Contraseña);
            stmt.setInt(6, Consultorio);
            stmt.setInt(7, rol);
            stmt.setInt(8, Documento);
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
    
    public boolean DeleteUsuario(){
        boolean respon = false;
        try{
            String sql = "DELETE FROM usuarios WHERE Identificacion = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, Documento);
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
            response = stmt.executeQuery(sql);
            return response;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return response;
    }
     
    public ResultSet GetUsuarioById(int id){
        ResultSet response = null;
        try{
            String sql = "SELECT * FROM usuarios WHERE Identificacion=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            response = stmt.executeQuery();
            return response;
        }catch(SQLException e){
            e.printStackTrace();    
        }
        return response;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public int getDocumento() {
        return Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public int getConsultorio() {
        return Consultorio;
    }

    public int getRol() {
        return rol;
    }

    
    
}
