/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.SessionManager;
import Modelo.Tratamiento;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class TratamientoController {

    static Tratamiento med = new Tratamiento();

    public ResultSet ListarTratamientoMedico() {
        ResultSet response = null;
        SessionManager sessionManager = SessionManager.getInstance();
        String user = sessionManager.getUserId();
        try {
            String sql = "SELECT t.Id,m.Nombre as medicamento,u.Nombre as paciente,Fecha_asignada,Fecha_inicio,Fecha_fin,Observaciones,us.Nombre as medico FROM `tratamientos` t\n"
                    + "JOIN usuarios u ON u.Identificacion = t.Paciente\n"
                    + "JOIN usuarios us ON us.Identificacion = t.Medico\n"
                    + "JOIN medicamentos m ON m.Id = t.Medicamento WHERE Medico= " + user;
            response = med.GetAllTratamiento(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public ResultSet ListarTratamientoPaciente() {
        ResultSet response = null;
        SessionManager sessionManager = SessionManager.getInstance();
        String user = sessionManager.getUserId();
        try {
            String sql = "SELECT t.Id,m.Nombre as medicamento,u.Nombre as paciente,Fecha_asignada,Fecha_inicio,Fecha_fin,Observaciones,us.Nombre as medico FROM `tratamientos` t\n"
                    + "JOIN usuarios u ON u.Identificacion = t.Paciente\n"
                    + "JOIN usuarios us ON us.Identificacion = t.Medico\n"
                    + "JOIN medicamentos m ON m.Id = t.Medicamento WHERE Paciente= " + user;
            response = med.GetAllTratamiento(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void ValidarAddTratamiento(int Medicamento, int Paciente, Date Fecha_Asignada,
            Date Fecha_Inicio, Date Fecha_Fin, String Observacion, int Medico) {
        try {
            med.Medicamento = Medicamento;
            med.Paciente = Paciente;
            med.Fecha_Asignada = Fecha_Asignada;
            med.Fecha_Inicio = Fecha_Inicio;
            med.Fecha_Fin = Fecha_Fin;
            med.Observacion = Observacion;
            med.Medico = Medico;
            boolean respon = med.AddTratamiento();
            if (respon) {
                JOptionPane.showMessageDialog(null, "Tratamiento insertado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al insertar al Tratamiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
