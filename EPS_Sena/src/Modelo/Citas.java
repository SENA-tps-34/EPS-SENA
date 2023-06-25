/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Core.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cristian
 */
public class Citas {
    static Conexion conn = new Conexion();
    static Connection connect = conn.conectart();
    
    public int Numero;
    public Date Fecha;
    public String Hora;
    public String Estado;
    public String Observacion;
    public int Paciente;
    public int Medico;
    public String medico;
    public int Consultorio;
    
    public Citas() {
    }
    
    public Citas(int Numero, String Observacion, Date Fecha, String Hora, String Estado,String Medico, int Consultorio){
        this.Numero = Numero;
        this.Observacion = Observacion;
        this.Fecha= Fecha;
        this.Hora=Hora;
        this.Estado=Estado;
        this.medico=Medico;
        this.Consultorio=Consultorio;
    }

    public boolean AddCitas(){
        boolean respon = false;
        try{
            String sql = "INSERT INTO citas(Observacion,Fecha,Hora,Estado,Medico) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, Observacion);
            stmt.setDate(2, Fecha);
            stmt.setString(3, Hora);
            stmt.setString(4, Estado);
            stmt.setInt(5, Medico);
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
    
    public boolean UpdateCitaEstado(){
        boolean respon = false;
        try{
            String sql = "UPDATE citas SET Estado=? WHERE Numero=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, Estado);
            stmt.setInt(2, Numero);
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
    
    public ResultSet GetAllCitas(String sql){
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
    
    public ResultSet GetCitasById(int id){
        ResultSet response = null;
        try{
            String sql = "SELECT * FROM citas WHERE Numero=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            response = stmt.executeQuery();
            return response;
        }catch(SQLException e){
            e.printStackTrace();    
        }
        return response;
    }
    
    
    public int getNumero() {
        return Numero;
    }

    public Date getFecha() {
        return Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public String getEstado() {
        return Estado;
    }

    public String getObservacion() {
        return Observacion;
    }

    public int getPaciente() {
        return Paciente;
    }

    public int getMedico() {
        return Medico;
    }

    public String getmedico() {
        return medico;
    }

    public int getConsultorio() {
        return Consultorio;
    }
    
}
