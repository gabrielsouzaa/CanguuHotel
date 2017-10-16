/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canguuhotel.interfaces;

import canguuhotel.interfaces.QuartosCRUD;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import canguuhotel.util.ConexaoBanco;
import java.awt.BorderLayout;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class TelaInicial extends javax.swing.JFrame {

    
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        popularTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1_clientes = new javax.swing.JButton();
        jButton1_reservas = new javax.swing.JButton();
        jButton1_quartos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 36)); // NOI18N
        jLabel1.setText("CANGUU HOTEL");

        jButton1_clientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1_clientes.setText("CLIENTES");
        jButton1_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_clientesActionPerformed(evt);
            }
        });

        jButton1_reservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1_reservas.setText("RESERVAS");
        jButton1_reservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_reservasActionPerformed(evt);
            }
        });

        jButton1_quartos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1_quartos.setText("QUARTOS");
        jButton1_quartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_quartosActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Quarto", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1_quartos, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1_reservas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1_quartos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_clientesActionPerformed
        JFrame clienteCrud = new ClientesCRUD();
        clienteCrud.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1_clientesActionPerformed

    private void jButton1_reservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_reservasActionPerformed
        JFrame reservaCrud = new ReservasCRUD();
        reservaCrud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1_reservasActionPerformed

    private void jButton1_quartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_quartosActionPerformed
        JFrame quartoCrud = new QuartosCRUD();
        quartoCrud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1_quartosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
               
            }
        });
    }
    
    public void popularTabela(){
       try{
            String sql = "SELECT numero, disponivel FROM quartos";
            Connection con = (Connection) ConexaoBanco.getConexao();
            PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
            banco.execute(); // cria o vetor com os resultados obtidos da consulta
            ResultSet resultado = banco.executeQuery(sql); //Execulta a query
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            while(resultado.next()){
                //Verificação para trocar o valor "0" ou "1" que está vindo do banco para uma String.
                if(resultado.getString("disponivel").equals("1")){
                    model.addRow(new Object[] { 
                   //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultado.getString("numero"),
                    "Disponível",
                   }); 
                } else {
                    model.addRow(new Object[] { 
                   //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultado.getString("numero"),
                    "Indisponível",
                   });
                }
        } 
            banco.close();
            con.close();
        } catch (SQLException e){
           System.out.println("O erro foi " +e);
         }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_clientes;
    private javax.swing.JButton jButton1_quartos;
    private javax.swing.JButton jButton1_reservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
