/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author ADSI
 */
public class ValidacionCampos {
    public static boolean solonumeros(String datos){
        return datos.matches("[0-9]*");
    }
    public static boolean sololetras(String datos){
        return datos.matches("[a-ñ-zA-Z]*");
    }
}
