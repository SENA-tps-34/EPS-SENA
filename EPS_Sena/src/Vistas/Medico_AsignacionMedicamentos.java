/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controller.MedicamentoController;
import Controller.PacienteController;
import Controller.TratamientoController;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Modelo.Medicamentos;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author ADSI
 */
public class Medico_AsignacionMedicamentos extends javax.swing.JFrame {

    /**
     * Creates new form Medico_AsignacionMedicamentos
     */
    public Medico_AsignacionMedicamentos() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        llenarComboboxMedicamentos();
        llenarComboboxPacientes();
        Date fecha = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        jDateChooserFechaInicio.setMinSelectableDate(calendar.getTime());
        jDateChooserFechaFin.setMinSelectableDate(calendar.getTime());

        jDateChooserAsignada.setMinSelectableDate(calendar.getTime());
        jDateChooserAsignada.setMaxSelectableDate(calendar.getTime());

        jDateChooserAsignada.setDate(fecha);
    }
// icono JFrame 

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("IMG/Logosena.png"));
        return retValue;

    }

    public ArrayList<Medicamentos> listarMedicamentos() {
        ArrayList<Medicamentos> MedicoList = new ArrayList<>();
        try {
            MedicamentoController admin = new MedicamentoController();
            ResultSet response = admin.ListarMedicamento();
            Medicamentos med;
            while (response.next()) {
                med = new Medicamentos(response.getInt("Id"), response.getString("Nombre"),
                        response.getString("Descripcion"));
                MedicoList.add(med);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MedicoList;
    }

    public ArrayList<Usuario> listarPacientes() {
        ArrayList<Usuario> PacienteList = new ArrayList<>();
        try {
            PacienteController admin = new PacienteController();
            ResultSet response = admin.ListarPacientes();
            Usuario user;
            while (response.next()) {
                user = new Usuario(response.getString("TipoDocumento"), response.getInt("Identificacion"),
                        response.getString("Nombre"), response.getInt("Consultorio_Medico"), 
                        response.getDate("Fecha_Nacimiento"),response.getString("Sexo"));
                PacienteList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PacienteList;
    }

    public void llenarComboboxMedicamentos() {
        try {
            MedicamentoController admin = new MedicamentoController();
            ArrayList<Medicamentos> list = listarMedicamentos();
            for (int i = 0; i < list.size(); i++) {
                jComboBoxMedicamento.addItem(new Medicamentos(list.get(i).getId(), list.get(i).getNombre(), list.get(i).getDescripcion()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void llenarComboboxPacientes() {
        try {
            PacienteController admin = new PacienteController();
            ArrayList<Usuario> list = listarPacientes();
            for (int i = 0; i < list.size(); i++) {
                jComboBoxPacientes.addItem(new Usuario(list.get(i).getTipoDocumento(), list.get(i).getDocumento(),
                        list.get(i).getNombre(), list.get(i).getConsultorio(), list.get(i).getFecha_Nacimiento(), list.get(i).getSexo()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxMedicamento = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxPacientes = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserAsignada = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldObservacion = new javax.swing.JTextField();
        jButtonAsignar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(218, 234, 247));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel6.setText("Asignar Medicamentos");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(45, 65, 115));
        jLabel7.setText("SENA");

        jLabel10.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(45, 65, 115));
        jLabel10.setText("EPS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(42, 42, 42))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel1.setText("Nombre Medicamento");

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel11.setText("Paciente ");

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel12.setText("Fecha Asignacion");

        jDateChooserAsignada.setDateFormatString("yyyy-MM-dd");

        jDateChooserFechaInicio.setDateFormatString("yyyy-MM-dd");

        jDateChooserFechaFin.setDateFormatString("yyyy-MM-dd");

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel13.setText("Fecha Fin");

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel14.setText("Fecha Inicio");

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel15.setText("Observacion");

        jTextFieldObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObservacionActionPerformed(evt);
            }
        });

        jButtonAsignar.setBackground(new java.awt.Color(45, 65, 115));
        jButtonAsignar.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonAsignar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsignar.setText("Asignar");
        jButtonAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxMedicamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxPacientes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooserAsignada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13))
                                .addGap(118, 118, 118)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(jTextFieldObservacion)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jButtonAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jDateChooserAsignada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jDateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButtonAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObservacionActionPerformed

    private void jButtonAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarActionPerformed
        int medicamento, paciente;
        medicamento = jComboBoxMedicamento.getItemAt(jComboBoxMedicamento.getSelectedIndex()).getId();
        paciente = jComboBoxPacientes.getItemAt(jComboBoxMedicamento.getSelectedIndex()).getDocumento();
        String Fecha_Asignada = ((JTextField) jDateChooserAsignada.getDateEditor().getUiComponent()).getText();
        String Fecha_Inicio = ((JTextField) jDateChooserFechaInicio.getDateEditor().getUiComponent()).getText();
        String Fecha_Fin = ((JTextField) jDateChooserFechaFin.getDateEditor().getUiComponent()).getText();
        String Observacion = jTextFieldObservacion.getText();
        if (Fecha_Inicio.isEmpty() || Fecha_Fin.isEmpty() || Observacion.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Todos los campos son obligatorios");
        } else {
            if (((JTextField) jDateChooserFechaInicio.getDateEditor().getUiComponent()).getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fecha de inicio");
            } else {
                if (((JTextField) jDateChooserFechaFin.getDateEditor().getUiComponent()).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fecha de finalizacion");
                }else{
                    if(Observacion.isEmpty()){
                        JOptionPane.showMessageDialog(rootPane, "Debe colocar observacion");
                    }else{
                        this.dispose();
                        TratamientoController addtrata = new TratamientoController();
                        addtrata.ValidarAddTratamiento(medicamento, paciente,java.sql.Date.valueOf(Fecha_Asignada) ,java.sql.Date.valueOf(Fecha_Inicio),java.sql.Date.valueOf(Fecha_Fin),Observacion);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonAsignarActionPerformed

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
            java.util.logging.Logger.getLogger(Medico_AsignacionMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medico_AsignacionMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medico_AsignacionMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medico_AsignacionMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medico_AsignacionMedicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAsignar;
    private javax.swing.JComboBox<Medicamentos> jComboBoxMedicamento;
    private javax.swing.JComboBox<Usuario> jComboBoxPacientes;
    private com.toedter.calendar.JDateChooser jDateChooserAsignada;
    private com.toedter.calendar.JDateChooser jDateChooserFechaFin;
    private com.toedter.calendar.JDateChooser jDateChooserFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextFieldObservacion;
    // End of variables declaration//GEN-END:variables
}
