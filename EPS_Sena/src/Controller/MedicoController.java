/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Usuario;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADSI
 */
public class MedicoController {

    static Usuario user = new Usuario();

    public ResultSet ListarMedicos() {
        ResultSet response = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE IdRoles=2";
            response = user.GetAllUsuario(sql);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void ValidarAddUsuarioMedico(String TipoDocumento, String Documento,
            String Nombre, String Contraseña, String Consultorio, int rol) {
        try {
            ResultSet consult = user.GetUsuarioById(Integer.parseInt(Documento));
            if (!consult.next()) {
                String sql = "SELECT * FROM usuarios WHERE Consultorio_Medico=" + Consultorio;
                ResultSet response = user.GetAllUsuario(sql);
                if (!response.next()) {
                    user.TipoDocumento = TipoDocumento;
                    user.Documento = Integer.parseInt(Documento);
                    user.Nombre = Nombre;
                    user.Contraseña = Contraseña;
                    user.Consultorio = Integer.parseInt(Consultorio);
                    user.rol = rol;
                    boolean respon = user.AddUsuario();
                    if (respon) {
                        JOptionPane.showMessageDialog(null, "Medico creado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al insertar al Medico");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El consultorio esta ocupado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El numero de documento ya existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ValidarUpdateUsuarioMedico(String TipoDocumento, String Documento,
            String Nombre, String Contraseña, String Consultorio, int rol) {
        try {
            ResultSet consult = user.GetUsuarioById(Integer.parseInt(Documento));
            if (consult.next()) {
                String sql = "SELECT * FROM usuarios WHERE Consultorio_Medico=" + Consultorio;
                ResultSet response = user.GetAllUsuario(sql);
                if (!response.next()) {
                    if (Contraseña.isEmpty()) {
                        user.TipoDocumento = TipoDocumento;
                        user.Documento = Integer.parseInt(Documento);
                        user.Nombre = Nombre;
                        user.Consultorio = Integer.parseInt(Consultorio);
                        user.rol = rol;
                        boolean respon = user.UpdateUsuario();
                        if (respon) {
                            JOptionPane.showMessageDialog(null, "Medico actualizado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Medico");
                        }
                    } else {
                        user.TipoDocumento = TipoDocumento;
                        user.Documento = Integer.parseInt(Documento);
                        user.Nombre = Nombre;
                        user.Contraseña = Contraseña;
                        user.Consultorio = Integer.parseInt(Consultorio);
                        user.rol = rol;
                        boolean respon = user.UpdateUsuario();
                        if (respon) {
                            JOptionPane.showMessageDialog(null, "Medico actualizado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Medico");
                        }
                    }
                } else {
                    String data = response.getString("Identificacion");
                    if (Documento.equals(data)) {
                        if (Contraseña.isEmpty()) {
                            user.TipoDocumento = TipoDocumento;
                            user.Documento = Integer.parseInt(Documento);
                            user.Nombre = Nombre;
                            user.Consultorio = Integer.parseInt(Consultorio);
                            user.rol = rol;
                            boolean respon = user.UpdateUsuario();
                            if (respon) {
                                JOptionPane.showMessageDialog(null, "Medico actualizado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Medico revisar modelo");
                            }
                        } else {
                            user.TipoDocumento = TipoDocumento;
                            user.Documento = Integer.parseInt(Documento);
                            user.Nombre = Nombre;
                            user.Contraseña = Contraseña;
                            user.Consultorio = Integer.parseInt(Consultorio);
                            user.rol = rol;
                            boolean respon = user.UpdateUsuario();
                            if (respon) {
                                JOptionPane.showMessageDialog(null, "Medico actualizado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al Medico");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El consultorio ya esta ocupado");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "El numero de documento no fue encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ValidarDeleteUsuarioMedico(int Documento) {
        try {
            user.Documento = Documento;
            boolean respon = user.DeleteUsuario();
            if (respon) {
                JOptionPane.showMessageDialog(null, "Medico eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al Medico");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
