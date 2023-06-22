/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Core.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADSI
 */
public class Medicamentos {
    static Conexion conn = new Conexion();
    static Connection connect = conn.conectart();
    
    public int Id;
    public String Nombre;
    public String Descripcion;
    
    public boolean AddMedicamento(){
        boolean respon = false;
        try{
            String sql = "INSERT INTO medicamentos(Id,Nombre,Descripcion) VALUES (?,?,?)";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, Id);
            stmt.setString(2, Nombre);
            stmt.setString(3, Descripcion);
            int response =stmt.executeUpdate();
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
    
    public boolean UpdateMedicamento(){
        boolean respon = false;
        try{
            String sql = "UPDATE medicamentos SET Nombre=?, Descripcion=? WHERE Id=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, Nombre);
            stmt.setString(2, Descripcion);
            stmt.setInt(3, Id);
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
    
    public boolean DeleteMedicamento(){
        boolean respon = false;
        try{
            String sql = "DELETE FROM medicamentos WHERE Id = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, Id);
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
    
    public ResultSet GetAllMedicamentos(String sql){
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
    
    public ResultSet GetMedicamentoById(int id){
        ResultSet response = null;
        try{
            String sql = "SELECT * FROM medicamentos WHERE Id=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            response = stmt.executeQuery();
            return response;
        }catch(SQLException e){
            e.printStackTrace();    
        }
        return response;
    }
}
