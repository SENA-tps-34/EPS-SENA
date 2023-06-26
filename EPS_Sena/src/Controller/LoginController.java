/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.SessionManager;
import Modelo.Usuario;
import Vistas.PerfilAdmin;
import Vistas.PerfilMedico;
import Vistas.PerfilPaciente;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADSI
 */
public class LoginController {
    
    static Usuario user = new Usuario();
    
    public boolean ValidarLogin(String TipoDocumento,String Usuario,String Contraseña){
        boolean respon = false;
        try{
            ResultSet consult = user.GetUsuarioById(Integer.parseInt(Usuario));
            if(consult.next()){
                String sql = "SELECT * FROM usuarios WHERE TipoDocumento='"+TipoDocumento+"' AND Identificacion="+Usuario+" AND Contraseña='"+Contraseña+"'";
                ResultSet response = user.GetAllUsuario(sql);
                if(response.next()){
                    SessionManager.getInstance().setUserId(Usuario);
                    String TipoUsuario = response.getString("IdRoles");
                    switch (TipoUsuario) {
                        case "1":
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                            PerfilAdmin admin = new PerfilAdmin();
                            admin.setVisible(true);
                            respon = true;
                            break;
                        case "2":
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                            PerfilMedico medico = new PerfilMedico();
                            medico.setVisible(true);
                            respon = true;
                            break;
                        case "3":
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                            PerfilPaciente paciente = new PerfilPaciente();
                            paciente.setVisible(true);
                            respon = true;
                            break;
                        default:
                            break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Credenciales invalidas");
                }
            }else{
                JOptionPane.showMessageDialog(null, "El usuario digitado no existe");
            }
        }catch(Exception e){
            e.printStackTrace();
            respon = true;
        }
        return respon;
    }
}
