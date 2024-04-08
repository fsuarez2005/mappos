/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package person.franksuarez.MapPOS.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.exception.InvalidFormat;
import person.franksuarez.MapPOS.model.UPCA;
import person.franksuarez.MapPOS.utility.Utility;

/**
 *
 * @author franksuarez
 */
public class UPCUtility extends javax.swing.JFrame {

    /**
     * Creates new form UPCUtility
     */
    public UPCUtility() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCheckUPC = new javax.swing.JButton();
        txtUPC = new javax.swing.JTextField();
        txtOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCheckUPC.setText("Check UPC");
        btnCheckUPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckUPCActionPerformed(evt);
            }
        });

        txtOutput.setText("Results");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUPC, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(btnCheckUPC)
                    .addComponent(txtOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCheckUPC)
                .addGap(18, 18, 18)
                .addComponent(txtOutput)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckUPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckUPCActionPerformed
        // todo
        String outputText = "";
        
        UPCA upc = new UPCA();
        
        try {
            upc.setData(txtUPC.getText());
        } catch (InvalidFormat ex) {
            Logger.getLogger(UPCUtility.class.getName()).log(Level.SEVERE, null, ex);
            outputText = "Invalid UPC Format";
            
        }
        txtOutput.setText(outputText);
    }//GEN-LAST:event_btnCheckUPCActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // using System Default Look and Feel. 
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UPCUtility().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckUPC;
    private javax.swing.JLabel txtOutput;
    private javax.swing.JTextField txtUPC;
    // End of variables declaration//GEN-END:variables
}
