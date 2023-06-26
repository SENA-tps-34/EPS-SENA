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
public class Tratamiento {
    
    static Conexion conn = new Conexion();
    static Connection connect = conn.conectart();
    
    public int Id;
    public int Medicamento;
    public String medicamento;
    public int Paciente;
    public String paciente;
    public Date Fecha_Asignada;
    public Date Fecha_Inicio;
    public Date Fecha_Fin;
    public String Observacion;
    public int Medico;
    public String medico;
    
        
    public Tratamiento() {
    }
    
    public Tratamiento(String Medicamento, String Paciente, Date Fecha_Asignada, Date Fecha_Inicio, Date Fecha_Fin, String Observacion, String Medico){
        this.medicamento = Medicamento;
        this.paciente= Paciente;
        this.Fecha_Asignada=Fecha_Asignada;
        this.Fecha_Inicio=Fecha_Inicio;
        this.Fecha_Fin=Fecha_Fin;
        this.Observacion=Observacion;
        this.medico=Medico;
    }
    
    public boolean AddTratamiento(){
        boolean respon = false;
        try{
            String sql = "INSERT INTO tratamientos(Medicamento,Paciente,Fecha_asignada,Fecha_inicio,Fecha_fin,Observaciones,Medico) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, Medicamento);
            stmt.setInt(2, Paciente);
            stmt.setDate(3, Fecha_Asignada);
            stmt.setDate(4, Fecha_Inicio);
            stmt.setDate(5, Fecha_Fin);
            stmt.setString(6, Observacion);
            stmt.setInt(7, Medico);
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
    
    public ResultSet GetAllTratamiento(String sql){
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
    
    public ResultSet GetTratamientoById(int id){
        ResultSet response = null;
        try{
            String sql = "SELECT * FROM tratamientos WHERE Id=?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            response = stmt.executeQuery();
            return response;
        }catch(SQLException e){
            e.printStackTrace();    
        }
        return response;
    }

    public int getId() {
        return Id;
    }

    public String getmedicamento() {
        return medicamento;
    }

    public String getpaciente() {
        return paciente;
    }

    public Date getFecha_Asignada() {
        return Fecha_Asignada;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return Fecha_Fin;
    }

    public String getObservacion() {
        return Observacion;
    }
    
    public String getmedico() {
        return medico;
    }
    
}
