/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ourbricks.client;

import javax.swing.JPanel;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksURLGateway;

/**
 *
 * @author jos
 */
public class OurBricksStandAlone extends javax.swing.JFrame {

    JPanel panel = new OurBricksJPanel(new OurBricksURLGateway());

    public OurBricksStandAlone() {
        this.setSize(1000, 400);
        this.add(panel);
        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OurBricksStandAlone().setVisible(true);
            }
        });
    }

}
