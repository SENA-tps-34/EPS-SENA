package Vistas;

import Class.RenderTable;
import Controller.PacienteController;
import Modelo.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Medico_AIDPaciente extends javax.swing.JFrame {

 
    public Medico_AIDPaciente() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(getIconImage());
        showPacientes();
    }
// icono JFrame 
    @Override
    public Image getIconImage(){
    Image retValue = Toolkit.getDefaultToolkit().getImage (ClassLoader.getSystemResource("IMG/Logosena.png"));
    return retValue;
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        btnRefreshTable = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 65, 115));
        jLabel3.setText(" Informacion de pacientes ");

        jPanel3.setBackground(new java.awt.Color(218, 234, 247));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 65, 115));
        jLabel1.setText("SENA");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/UserBlanco.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel5.setText("Medico");

        jPanel5.setBackground(new java.awt.Color(45, 65, 115));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 234, 247));
        jLabel2.setText("EPS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnvolver.setBackground(new java.awt.Color(218, 234, 247));
        btnvolver.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnvolver.setText("atras ");
        btnvolver.setToolTipText("");
        btnvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 653, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnvolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4)
                .addGap(17, 17, 17))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnvolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "T_documento", "Identificacion", "Nombre", "F_nacimiento", "Sexo", "Modificar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTablePacientes.setUpdateSelectionOnSort(false);
        jTablePacientes.setVerifyInputWhenFocusTarget(false);
        jTablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        btnRefreshTable.setBackground(new java.awt.Color(45, 65, 115));
        btnRefreshTable.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        btnRefreshTable.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshTable.setText("refresh");
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRefreshTable)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        new PerfilMedico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void jTablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacientesMouseClicked
        int column = jTablePacientes.getColumnModel().getColumnIndexAtX(evt.getX());
        int rows = evt.getY()/jTablePacientes.getRowHeight();

        if(rows < jTablePacientes.getRowCount() && rows >= 0 && column < jTablePacientes.getColumnCount() && column >= 0){
            Object value = jTablePacientes.getValueAt(rows, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button = (JButton)value;
                if(button.getName().equals("modificar")){
                    int data = jTablePacientes.getSelectedRow();
                    String TipoDocumento = (String)jTablePacientes.getValueAt(data, 0);
                    int Documento = (int)jTablePacientes.getValueAt(data, 1);
                    String Nombre = (String)jTablePacientes.getValueAt(data, 2);
                    Date Fecha = (Date)jTablePacientes.getValueAt(data, 3);
                    String Sexo = (String)jTablePacientes.getValueAt(data, 4);
                    Admin_ModificarPaciente modificar = new Admin_ModificarPaciente();
                    modificar.listarPacientes(TipoDocumento, String.valueOf(Documento), Nombre, String.valueOf(Fecha), Sexo);
                    modificar.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jTablePacientesMouseClicked

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTablePacientes.getModel();
        int num = model.getRowCount();
        if (num == 0) {
            showPacientes();
        } else if (num > 0) {
            model.setRowCount(0);
            showPacientes();
        }
    }//GEN-LAST:event_btnRefreshTableActionPerformed

    public void showPacientes(){
        ArrayList<Usuario> list = listarPacientes();
        JButton BtnModificar = new JButton("Modificar");
        BtnModificar.setName("modificar");
        try{
            DefaultTableModel model = new DefaultTableModel();
            model = (DefaultTableModel) jTablePacientes.getModel();
            Object[] usuarios = new Object[6];
            for(int i = 0; i < list.size(); i++){
                usuarios[0] = list.get(i).getTipoDocumento();
                usuarios[1] = list.get(i).getDocumento();
                usuarios[2] = list.get(i).getNombre();
                usuarios[3] = list.get(i).getFecha_Nacimiento();
                usuarios[4] = list.get(i).getSexo();
                usuarios[5] = BtnModificar;
                model.addRow(usuarios);
            }
            jTablePacientes.setDefaultRenderer(Object.class, new RenderTable());
            jTablePacientes.setModel(model);
            jTablePacientes.setRowHeight(40);
            TableColumn columnModificar = jTablePacientes.getColumn("Modificar");
            columnModificar.setPreferredWidth(50);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Usuario> listarPacientes(){
        ArrayList<Usuario> PacienteList = new ArrayList<>();
        try{
            PacienteController admin = new PacienteController();
            ResultSet response = admin.ListarPacientes();
            Usuario user;
            while(response.next()){
                user = new Usuario(response.getString("TipoDocumento"), response.getInt("Identificacion"),
                        response.getString("Nombre"), response.getInt("Consultorio_Medico"), 
                        response.getDate("Fecha_Nacimiento"),response.getString("Sexo"));
                PacienteList.add(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return PacienteList;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Medico_AIDPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medico_AIDPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medico_AIDPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medico_AIDPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medico_AIDPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnRefreshTable;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTablePacientes;
    // End of variables declaration//GEN-END:variables
}
