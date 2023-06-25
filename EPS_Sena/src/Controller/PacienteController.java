package Controller;

import Modelo.Usuario;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PacienteController {

    static Usuario user = new Usuario();

    public ResultSet ListarPacientes() {
        ResultSet response = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE IdRoles=3";
            response = user.GetAllUsuario(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void ValidarAddUsuarioPaciente(String TipoDocumento, String Documento, String Nombre,
            Date Fecha, String Contraseña, String Sexo, int rol) {
        try {
            ResultSet consult = user.GetUsuarioById(Integer.parseInt(Documento));
            if (!consult.next()) {
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
            } else {
                JOptionPane.showMessageDialog(null, "El numero de documento ya existe");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void ValidarUpdateUsuarioPaciente(String TipoDocumento, String Documento, String Nombre,
            Date Fecha, String Contraseña, String Sexo, int rol) {
        try {
            ResultSet consult = user.GetUsuarioById(Integer.parseInt(Documento));
            if (consult.next()) {
                if (Contraseña.isEmpty()) {
                    user.TipoDocumento = TipoDocumento;
                    user.Documento = Integer.parseInt(Documento);
                    user.Nombre = Nombre;
                    user.Fecha_Nacimiento = Fecha;
                    user.Sexo = Sexo;
                    user.rol = rol;
                    boolean respon = user.UpdateUsuario();
                    if (respon) {
                        JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Paciente");
                    }
                } else {
                    user.TipoDocumento = TipoDocumento;
                    user.Documento = Integer.parseInt(Documento);
                    user.Nombre = Nombre;
                    user.Contraseña = Contraseña;
                    user.Fecha_Nacimiento = Fecha;
                    user.Sexo = Sexo;
                    user.rol = rol;
                    boolean respon = user.UpdateUsuario();
                    if (respon) {
                        JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Paciente");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de documento no fue encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ValidarDeleteUsuarioPaciente(int Documento) {
        try {
            user.Documento = Documento;
            boolean respon = user.DeleteUsuario();
            if (respon) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al Paciente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
