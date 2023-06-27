/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.SessionManager;
import Modelo.Citas;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class CitasController {

    static Citas cit = new Citas();

    public ResultSet ListarCitasPaciente() {
        ResultSet response = null;
        SessionManager sessionManager = SessionManager.getInstance();
        String user = sessionManager.getUserId();
        try {
            String sql = "SELECT Numero,Observacion,Us.Nombre as Paciente,Fecha,Hora,u.Nombre as Medico, u.Consultorio_Medico, Estado FROM `citas` c\n"
                    + "JOIN usuarios u ON u.Identificacion = c.Medico\n"
                    + "JOIN usuarios Us ON Us.Identificacion = c.Paciente\n"
                    + "WHERE Paciente=" + user + " ORDER BY Estado='Pendiente' DESC";
            response = cit.GetAllCitas(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public ResultSet ListarCitasMedico() {
        ResultSet response = null;
        SessionManager sessionManager = SessionManager.getInstance();
        String user = sessionManager.getUserId();
        try {
            String sql = "SELECT Numero,Observacion,Us.Nombre as Paciente,Fecha,Hora,u.Nombre as Medico, u.Consultorio_Medico, Estado FROM `citas` c\n"
                    + "JOIN usuarios u ON u.Identificacion = c.Medico\n"
                    + "JOIN usuarios Us ON Us.Identificacion = c.Paciente\n"
                    + "WHERE Medico=" + user + " ORDER BY Estado='Pendiente' DESC";
            response = cit.GetAllCitas(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public ResultSet ListarHorasMedico(int user, String fecha) {
        ResultSet response = null;
        try {
            String sql = "SELECT Hora FROM `citas` WHERE Estado='Pendiente' AND Medico=" + user+ " AND Fecha = '"+fecha+"'";
            response = cit.GetAllCitas(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public void ValidarAddCitas(String Observacion, Date Fecha, String Hora,
            String Estado, int Medico, int Paciente) {
        try {
            cit.Observacion = Observacion;
            cit.Fecha = Fecha;
            cit.Hora = Hora;
            cit.Estado = Estado;
            cit.Medico = Medico;
            cit.Paciente = Paciente;
            boolean respon = cit.AddCitas();
            if (respon) {
                JOptionPane.showMessageDialog(null, "Cita insertada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al insertar al Cita");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ValidarUpdateCitaEstado(int Numero, String Estado) {
        try {
            cit.Numero = Numero;
            cit.Estado = Estado;
            boolean respon = cit.UpdateCitaEstado();
            if (respon) {
                JOptionPane.showMessageDialog(null, "Cita actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al insertar al Cita");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
