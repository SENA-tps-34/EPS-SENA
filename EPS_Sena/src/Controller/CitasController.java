/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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

    public ResultSet ListarCitas() {
        ResultSet response = null;
        try {
            String sql = "SELECT Numero,Observacion,Fecha,Hora,u.Nombre as Medico, u.Consultorio_Medico, estado FROM `citas` c\n"
                    + "JOIN usuarios u ON u.Identificacion = c.Medico";
            response = cit.GetAllCitas(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void ValidarAddCitas(String Observacion, Date Fecha, String Hora,
            String Estado, int Medico) {
        try {
            cit.Observacion = Observacion;
            cit.Fecha = Fecha;
            cit.Hora = Hora;
            cit.Estado = Estado;
            cit.Medico = Medico;
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
    public void ValidarUpdateCitaEstado(int Numero,String Estado) {
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
