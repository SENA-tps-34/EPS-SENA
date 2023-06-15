package Controller;

import Modelo.Usuario;
import java.sql.Date;
import javax.swing.JOptionPane;

public class AdminPacienteController {

    public void ValidarAddUsuarioPaciente(String TipoDocumento, String Documento, String Nombre, Date Fecha, String Contraseña, String Sexo, int rol) {
        try {
            Usuario user = new Usuario();
            user.TipoDocumento = TipoDocumento;
            user.Documento = Integer.parseInt(Documento);
            user.Nombre = Nombre;
            user.Fecha_Nacimiento = Fecha;
            user.Contraseña = Contraseña;
            user.Sexo = Sexo;
            user.rol = rol;
            boolean response = user.AddUsuario();
            if (response) {
                JOptionPane.showMessageDialog(null, "Paciente insertado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al insertar el Paciente");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
