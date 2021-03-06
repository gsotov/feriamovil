/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventanas;
import javax.swing.table.DefaultTableModel;
import BD.Conectar;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel
 */
public class MenuTrabajador extends javax.swing.JFrame {
        DefaultTableModel model;
        Connection conn;
        Statement sent;
    /**
     * Creates new form MenuTrabajador
     */
    public MenuTrabajador() {
        initComponents();
        conn = Conectar.getConnection();
        this.setLocationRelativeTo(null);
        Desabilitar();
        PedidoEntregado();
        PedidoPendiente();
    }
    void Limpiar(){
        txtCoPedido.setText("");
        txtConTrabajador.setText("");
        txtUsuTrabajador.setText("");
        //Agregar las jTable
    }
    void Habilitar(){
        txtCoPedido.setEditable(true);
        btnEntregado.setEnabled(true);
        btnIngresarTrabajador.setEnabled(true);
        btnNoEntregado.setEnabled(true);
        btnPedEntregado.setEnabled(true);
        btnPedPendiente.setEnabled(true);
        TaEntre.setEnabled(true);
        PedPendiente.setEnabled(true);
        
        
    }
    void Desabilitar(){
        txtCoPedido.setEditable(false);
        btnEntregado.setEnabled(false);
        btnIngresarTrabajador.setEnabled(true);
        btnNoEntregado.setEnabled(false);
        btnPedEntregado.setEnabled(false);
        btnPedPendiente.setEnabled(false);
        TaEntre.setEnabled(false);
        PedPendiente.setEnabled(false);

    }
    void DesabilitarUsuario(){
        txtUsuTrabajador.setEnabled(false);
        txtConTrabajador.setEnabled(false);
    }
    void PedidoEntregado(){
        String [] titulos = {"Pedidos Entregados"};
        String sql = "Select * from Pedido_entregado";
        model = new DefaultTableModel(null, titulos);
        
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        
        try {
            conn = Conectar.getConnection();
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            String [] fila = new String [1];
            
            while (rs.next()){
                fila[0] = rs.getString("codigo");
                model.addRow(fila);
            }
            TaEntre.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void PedidoPendiente(){
        String [] titulos = {"Pedidos Pendientes"};
        String sql = "Select * from pedido_pendiente";
        model = new DefaultTableModel(null, titulos);
        
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        
        try {
            conn = Conectar.getConnection();
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            
            String [] fila = new String [1];
            
            while (rs.next()){
                fila[0] = rs.getString("codigo");
                model.addRow(fila);
            }
            PedPendiente.setModel(model);
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

        jPanel12 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        btnIngresarTrabajador = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        btnPedPendiente = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaEntre = new javax.swing.JTable();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtCoPedido = new javax.swing.JTextField();
        btnEntregado = new javax.swing.JButton();
        btnNoEntregado = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        btnPedEntregado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PedPendiente = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        txtUsuTrabajador = new javax.swing.JTextField();
        txtConTrabajador = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel49.setText("Trabajadores");

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Contraseña Trabajador: ");

        btnIngresarTrabajador.setText("Ingresar");
        btnIngresarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarTrabajadorActionPerformed(evt);
            }
        });

        btnPedPendiente.setText("Pedidos Pendiente");
        btnPedPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedPendienteActionPerformed(evt);
            }
        });

        TaEntre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TaEntre);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Codigo Pedido");

        btnEntregado.setText("Entregado");
        btnEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregadoActionPerformed(evt);
            }
        });

        btnNoEntregado.setText("No Entregado");
        btnNoEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoEntregadoActionPerformed(evt);
            }
        });

        btnPedEntregado.setText("Pedidos Entregados");
        btnPedEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedEntregadoActionPerformed(evt);
            }
        });

        PedPendiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(PedPendiente);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Usuario Trabajador: ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jSeparator13)
                .addGap(754, 754, 754))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                        .addComponent(jSeparator14)
                        .addComponent(jSeparator12)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(btnPedPendiente)
                            .addGap(32, 32, 32)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(btnPedEntregado)
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(txtUsuTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel51)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(18, 18, 18)
                                .addComponent(txtConTrabajador)))
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresarTrabajador))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addComponent(txtCoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEntregado)
                        .addGap(27, 27, 27)
                        .addComponent(btnNoEntregado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtUsuTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(txtConTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnIngresarTrabajador)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntregado)
                    .addComponent(btnNoEntregado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btnPedEntregado))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnPedPendiente)))
                .addGap(33, 33, 33))
        );

        jButton3.setText("Cerrar Sesion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator11)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarTrabajadorActionPerformed

        try {
            conn = Conectar.getConnection();
            String usuario = this.txtUsuTrabajador.getText();
            String contraseña = this.txtConTrabajador.getText();
            String sql="Select count(*) as cuentaTrabajador from usuario_trabajador where usuario='" + usuario + "' and contraseña='" + contraseña + "'";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            int cuentaTrabajador = Integer.parseInt(rs.getString("cuentaTrabajador"));
            System.out.println(sql);
            if(cuentaTrabajador >0){
                JOptionPane.showMessageDialog(null,"Bienvenido a la Feria Movil, Que tengas un buen dia");
                Limpiar();
                Habilitar();
                DesabilitarUsuario();

            }else{
                JOptionPane.showMessageDialog(null, "USUARIO NO VALIDO");
                Desabilitar();
                Limpiar();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
        }

    }//GEN-LAST:event_btnIngresarTrabajadorActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregadoActionPerformed
        // TODO add your handling code here:
        Conectar cc = new Conectar();
        conn = Conectar.getConnection();
        
        
        String codigo;
        String sql = "";
        
        codigo = txtCoPedido.getText();
        
        sql = "INSERT INTO pedido_entregado (codigo) VALUES (?)";
        
        
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, codigo);
            System.out.println(sql);
            
            int n = ps.executeUpdate();
            
            if(n>0){
                JOptionPane.showMessageDialog(null,"Entregado");
                Limpiar();
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"NO SE GUARDO EN LOS PEDIDOS");
            Limpiar();
        }
        
    }//GEN-LAST:event_btnEntregadoActionPerformed

    private void btnPedEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedEntregadoActionPerformed
        // TODO add your handling code here:
        
        PedidoEntregado();
        
    }//GEN-LAST:event_btnPedEntregadoActionPerformed

    private void btnNoEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoEntregadoActionPerformed
        // TODO add your handling code here:
        Conectar cc = new Conectar();
        conn = Conectar.getConnection();
        
        
        String codigo;
        String sql = "";
        
        codigo = txtCoPedido.getText();
        
        sql = "INSERT INTO pedido_pendiente (codigo) VALUES (?)";
        
        
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, codigo);
            System.out.println(sql);
            
            int n = ps.executeUpdate();
            
            if(n>0){
                JOptionPane.showMessageDialog(null,"Pedido Pendiente");
                Limpiar();
                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"NO SE GUARDO EN LOS PEDIDOS PENDIENTES");
            Limpiar();
        }
    }//GEN-LAST:event_btnNoEntregadoActionPerformed

    private void btnPedPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedPendienteActionPerformed
        // TODO add your handling code here:
        PedidoPendiente();
    }//GEN-LAST:event_btnPedPendienteActionPerformed

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
            java.util.logging.Logger.getLogger(MenuTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PedPendiente;
    private javax.swing.JTable TaEntre;
    private javax.swing.JButton btnEntregado;
    private javax.swing.JButton btnIngresarTrabajador;
    private javax.swing.JButton btnNoEntregado;
    private javax.swing.JButton btnPedEntregado;
    private javax.swing.JButton btnPedPendiente;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JTextField txtCoPedido;
    private javax.swing.JPasswordField txtConTrabajador;
    private javax.swing.JTextField txtUsuTrabajador;
    // End of variables declaration//GEN-END:variables
}
