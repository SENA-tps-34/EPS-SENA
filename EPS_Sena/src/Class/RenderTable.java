/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author cristian
 */
public class RenderTable extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object objeto_render, boolean bin,
    boolean bin1, int i, int j){
        if(objeto_render instanceof JButton){
            return (JButton)objeto_render;
        }
        return super.getTableCellRendererComponent(table, objeto_render, bin1, bin1, i, j);
    }
}
