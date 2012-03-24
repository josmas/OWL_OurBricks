package org.jdesktop.wonderland.modules.ourbricks.client;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBrick;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksList;

/**
 *
 * @author jos
 */
class OurBricksLoadWorker extends SwingWorker<List<OurBrick>, OurBrick> {

    OurBricksJPanel panel;
    DefaultListModel listModel;
    OurBricksList bricksList;

    public OurBricksLoadWorker(OurBricksList bricksList, DefaultListModel listModel, OurBricksJPanel panel) {
        this.bricksList = bricksList;
        this.listModel = listModel;
        this.panel = panel;
    }

    @Override
    protected List<OurBrick> doInBackground() throws Exception {


        List<OurBrick> results = new ArrayList<OurBrick>();
        OurBrick data = null;


        for (OurBrick brick : bricksList.getItems()) {
            ImageIcon icon = null;
            try {
                icon = new ImageIcon(new java.net.URL(brick.getThumbnail_link()));
            } catch (MalformedURLException ex) {
                Logger.getLogger(OurBricksLoadWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            brick.setIcon(icon);
            publish(brick);
            results.add(brick);
        }
        return results;
    }

    @Override
    protected void process(List<OurBrick> list) {
        for (OurBrick brick : list) {
            if (isCancelled()) {
                break;
            }
            listModel.addElement(brick);
        }
    }

    @Override
    protected void done() {
        // Set values in panel if feedback needed
    }
}