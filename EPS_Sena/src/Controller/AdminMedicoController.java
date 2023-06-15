/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Usuario;
import com.sun.tools.javac.util.Convert;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADSI
 */
public class AdminMedicoController {
    
    static Usuario user = new Usuario();
    
    public void ValidarAddUsuarioMedico(String TipoDocumento, String Documento, 
            String Nombre, String Contraseña, String Consultorio,int rol){
        try{
            
            user.TipoDocumento = TipoDocumento;
            user.Documento = Integer.parseInt(Documento);
            user.Nombre = Nombre;
            user.Contraseña = Contraseña;
            user.Consultorio = Consultorio;
            user.rol = rol;
            boolean response = user.AddUsuario();
            if(response){
                JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al insertar al usuario");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
