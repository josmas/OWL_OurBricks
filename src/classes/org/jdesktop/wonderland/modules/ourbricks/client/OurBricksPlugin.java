/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ourbricks.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import org.jdesktop.wonderland.client.BaseClientPlugin;
import org.jdesktop.wonderland.client.jme.JmeClientMain;
import org.jdesktop.wonderland.client.login.ServerSessionManager;
import org.jdesktop.wonderland.common.annotation.Plugin;

/**
 *
 * @author jos
 */
@Plugin
public class OurBricksPlugin extends BaseClientPlugin {

    private JMenuItem ourBricksHUDMI = null;
    private OurBricksHUD ourBricksHUD;
    private boolean ourBricksHUDEnabled = false;

    /**
     * Creates a new Menu Item for the HUD that will allow to show/hide it.
     * @param loginInfo
     */
    @Override
    public void initialize(ServerSessionManager loginInfo) {
        ourBricksHUDMI = new JCheckBoxMenuItem("OurBricks");
        ourBricksHUDMI.setSelected(false);
        ourBricksHUDMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ourBricksHUDEnabled = !ourBricksHUDEnabled;
                ourBricksHUDMI.setSelected(ourBricksHUDEnabled);
                if (ourBricksHUD == null ) {
                    ourBricksHUD = new OurBricksHUD();
                }
                else
                    ourBricksHUD.setHudComponentVisible(ourBricksHUDEnabled);
            }
        });

        super.initialize(loginInfo);
    }

    /**
     * Adds the Menu Item created in initialize to the Window Menu in the
     * Wonderland Client
     */
    @Override
    public void activate() {
        JmeClientMain.getFrame().addToWindowMenu(ourBricksHUDMI);
    }

     /**
     * Removes the Menu Item created in initialize to the Window Menu in the
     * Wonderland Client
     */
    @Override
    public void deactivate() {
        JmeClientMain.getFrame().removeFromWindowMenu(ourBricksHUDMI);
    }

}
