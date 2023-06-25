package Vistas;

import Class.RenderTable;
import Controller.CitasController;
import Modelo.Citas;
import Vistas.PerfilPaciente;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Paciente_Citas extends javax.swing.JFrame {

    public Paciente_Citas() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(getIconImage());
        showCitas();
    }
// icono JFrame 

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("IMG/Logosena.png"));
        return retValue;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCitas = new javax.swing.JTable();
        jButtonSolicitarCita = new javax.swing.JButton();
        btnRefreshTable = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(218, 234, 247));
        jPanel2.setPreferredSize(new java.awt.Dimension(416, 227));

        jPanel3.setBackground(new java.awt.Color(45, 65, 115));
        jPanel3.setPreferredSize(new java.awt.Dimension(158, 97));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 234, 247));
        jLabel2.setText("EPS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 65, 115));
        jLabel1.setText("SENA");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/UserBlanco.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel3.setText("Paciente ");

        btnvolver.setBackground(new java.awt.Color(218, 234, 247));
        btnvolver.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnvolver.setText("atras");
        btnvolver.setToolTipText("");
        btnvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 695, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnvolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnvolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(45, 65, 115));
        jLabel5.setText("Citas medicas ");

        jTableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Cita", "Fecha", "Hora", "Medico", "Consultorio", "Estado", "Accion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCitas);

        jButtonSolicitarCita.setBackground(new java.awt.Color(45, 65, 115));
        jButtonSolicitarCita.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonSolicitarCita.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSolicitarCita.setText("Solicitar cita");
        jButtonSolicitarCita.setMaximumSize(new java.awt.Dimension(146, 28));
        jButtonSolicitarCita.setMinimumSize(new java.awt.Dimension(146, 28));
        jButtonSolicitarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolicitarCitaActionPerformed(evt);
            }
        });

        btnRefreshTable.setBackground(new java.awt.Color(45, 65, 115));
        btnRefreshTable.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        btnRefreshTable.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshTable.setText("refresh");
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonSolicitarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefreshTable))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSolicitarCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshTable))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        new PerfilPaciente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void jButtonSolicitarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolicitarCitaActionPerformed
        new Paciente_SolicitarCita().setVisible(true);
    }//GEN-LAST:event_jButtonSolicitarCitaActionPerformed

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableCitas.getModel();
        int num = model.getRowCount();
        if (num == 0) {
            showCitas();
        } else if (num > 0) {
            model.setRowCount(0);
            showCitas();
        }
    }//GEN-LAST:event_btnRefreshTableActionPerformed

    private void jTableCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCitasMouseClicked
        int column = jTableCitas.getColumnModel().getColumnIndexAtX(evt.getX());
        int rows = evt.getY() / jTableCitas.getRowHeight();
        if (rows < jTableCitas.getRowCount() && rows >= 0 && column < jTableCitas.getColumnCount() && column >= 0) {
            Object value = jTableCitas.getValueAt(rows, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton button = (JButton) value;
                if (button.getName().equals("Cancelar")) {
                    String estado = "Cancelada";
                    int data = jTableCitas.getSelectedRow();
                    int Id = (int)jTableCitas.getValueAt(data,0);
                    CitasController cit = new CitasController();
                    cit.ValidarUpdateCitaEstado(Id, estado);
                }
            }
        }
    }//GEN-LAST:event_jTableCitasMouseClicked

    public void showCitas() {
        ArrayList<Citas> list = listarCitas();
        JButton BtnCancelar = new JButton("Cancelar");
        BtnCancelar.setName("Cancelar");
        try {
            DefaultTableModel model = new DefaultTableModel();
            model = (DefaultTableModel) jTableCitas.getModel();
            Object[] citas = new Object[8];
            for (int i = 0; i < list.size(); i++) {
                citas[0] = list.get(i).getNumero();
                citas[1] = list.get(i).getObservacion();
                citas[2] = list.get(i).getFecha();
                citas[3] = list.get(i).getHora();
                citas[4] = list.get(i).getmedico();
                citas[5] = list.get(i).getConsultorio();
                citas[6] = list.get(i).getEstado();
                citas[7] = BtnCancelar;
                model.addRow(citas);
            }
            jTableCitas.setDefaultRenderer(Object.class, new RenderTable());
            jTableCitas.setModel(model);
            jTableCitas.setRowHeight(40);
            TableColumn columnCancelar = jTableCitas.getColumn("Accion");
            columnCancelar.setPreferredWidth(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Citas> listarCitas() {
        ArrayList<Citas> CitasList = new ArrayList<>();
        try {
            CitasController med = new CitasController();
            ResultSet response = med.ListarCitas();
            Citas citas;
            while (response.next()) {
                citas = new Citas(response.getInt("Numero"), response.getString("Observacion"), response.getDate("Fecha"),
                        response.getString("Hora"), response.getString("Estado"), response.getString("Medico")
                 ,response.getInt("Consultorio_Medico"));
                CitasList.add(citas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CitasList;
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
            java.util.logging.Logger.getLogger(Paciente_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paciente_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paciente_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paciente_Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paciente_Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnRefreshTable;
    private javax.swing.JButton btnvolver;
    private javax.swing.JButton jButtonSolicitarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableCitas;
    // End of variables declaration//GEN-END:variables
}
