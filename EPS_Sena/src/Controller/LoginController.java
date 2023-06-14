/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Usuario;
import Vistas.Login;
import Vistas.PerfilAdmin;
import Vistas.PerfilMedico;
import Vistas.PerfilPaciente;
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
            boolean consult = user.GetUsuarioById(Integer.parseInt(Usuario));
            if(consult){
                String sql = "SELECT * FROM usuarios WHERE TipoDocumento='"+TipoDocumento+"' AND Identificacion="+Usuario+" AND Contraseña='"+Contraseña+"'";
                String response = user.GetAllUsuario(sql);
                if(response != null){
                    if(response.equals("1")){
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                        PerfilAdmin admin = new PerfilAdmin();
                        admin.setVisible(true);
                        respon = true;
                    }else if(response.equals("2")){
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                        PerfilMedico medico = new PerfilMedico();
                        medico.setVisible(true);
                        respon = true;
                    }else if(response.equals("3")){
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema!!");
                        PerfilPaciente paciente = new PerfilPaciente();
                        paciente.setVisible(true);
                        respon = true;
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
