/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ourbricks.client;

import javax.swing.JPanel;

/**
 *
 * @author jos
 */
public class TestJPanelExecutable extends javax.swing.JFrame {

    JPanel panel = new OurBricksJPanel();

    public TestJPanelExecutable() {
        this.setSize(1000, 400);
        this.add(panel);
        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestJPanelExecutable().setVisible(true);
            }
        });
    }

}
