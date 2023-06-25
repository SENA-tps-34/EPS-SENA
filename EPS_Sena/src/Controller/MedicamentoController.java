/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Medicamentos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADSI
 */
public class MedicamentoController {

    static Medicamentos med = new Medicamentos();

    public ResultSet ListarMedicamento() {
        ResultSet response = null;
        try {
            String sql = "SELECT * FROM medicamentos";
            response = med.GetAllMedicamentos(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void ValidarAddMedicamento(String Id, String Nombre, String Descripcion) {
        try {
            ResultSet consult = med.GetMedicamentoById(Integer.parseInt(Id));
            if (!consult.next()) {
                med.Id = Integer.parseInt(Id);
                med.Nombre = Nombre;
                med.Descripcion = Descripcion;
                boolean respon = med.AddMedicamento();
                if (respon) {
                    JOptionPane.showMessageDialog(null, "Medicamento insertado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar al Medicamento");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El id del medicamento ya existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ValidarUpdateMedicamento(String Id, String Nombre, String Descripcion) {
        try {
            ResultSet consult = med.GetMedicamentoById(Integer.parseInt(Id));
            if (consult.next()) {
                med.Id = Integer.parseInt(Id);
                med.Nombre = Nombre;
                med.Descripcion = Descripcion;
                boolean respon = med.UpdateMedicamento();
                if (respon) {
                    JOptionPane.showMessageDialog(null, "Medicamento actualizado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Medicamento");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de id no fue encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ValidarDeleteMedicamento(int Id) {
        try {
            med.Id = Id;
            boolean respon = med.DeleteMedicamento();
            if (respon) {
                JOptionPane.showMessageDialog(null, "Medicamento eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al Medicamento");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
