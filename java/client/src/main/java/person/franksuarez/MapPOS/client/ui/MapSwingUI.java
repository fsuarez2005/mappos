/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package person.franksuarez.MapPOS.client.ui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

/**
 *
 * @author franksuarez
 */
public class MapSwingUI extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(MapSwingUI.class.getName());

    private Point previousMousePoint;

    private void displayMouseEvent(String evtDesc, java.awt.event.MouseEvent evt) {
        StringBuilder sb = new StringBuilder();
        sb.append("[EVENT]: Mouse: Description: ").append(evtDesc).append(": Location: ").append(evt.getPoint());
        System.out.println(sb.toString());
    }

    
    boolean mousePressed;

    /**
     * Creates new form MapSwingUI
     */
    public MapSwingUI() {
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

        btnMove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        btnMove.setText("Move Me");
        btnMove.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(btnMove, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnMove, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        int dx = 0;
        int dy = 0;
        int multiplier = 5;

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                // dx = 0;
                dy = -1;
            }
            case KeyEvent.VK_DOWN -> {
                // dx = 0
                dy = 1;
            }
            case KeyEvent.VK_LEFT -> {
                dx = -1;
                // dy = 0
            }
            case KeyEvent.VK_RIGHT -> {
                dx = 1;
                // dy = 0
            }
            default -> {
            }
        }

        Point btnMoveLocation = btnMove.getLocation();
        btnMoveLocation.translate(dx * multiplier, dy * multiplier);
        btnMove.setLocation(btnMoveLocation);
    }//GEN-LAST:event_formKeyPressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
        //displayMouseEvent("mouseDragged", evt);

        // get last point // get current point // check for change
        double dx = evt.getX() - previousMousePoint.getX();
        double dy = evt.getY() - previousMousePoint.getY();
        
        
        
        // adjust widget by this change
        Point btnMoveLocation = btnMove.getLocation();
        btnMoveLocation.translate((int) dx, (int) dy);
        btnMove.setLocation(btnMoveLocation);
        
        
        
        // set current point to previous point
        previousMousePoint = new Point(evt.getX(), evt.getY());
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
        //displayMouseEvent("mouseMove", evt);
        previousMousePoint = new Point(evt.getX(), evt.getY());
    }//GEN-LAST:event_formMouseMoved

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
            java.util.logging.Logger.getLogger(MapSwingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapSwingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapSwingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapSwingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapSwingUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMove;
    // End of variables declaration//GEN-END:variables
}
