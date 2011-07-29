package org.jdesktop.wonderland.modules.ourbricks.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBrick;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksGateway;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksList;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksURLGateway;

public class OurBricksDataProvider {
    
    public static OurBricksList requestDataFromExternalService() throws MalformedURLException, IOException {
        OurBricksGateway gate;
        OurBricksList bricksList;
        //TODO Pass gateway and URL as parameters
//        gate = new OurBricksFAKEGateway();
//        bricksList = gate.getBricksList(null);
        gate = new OurBricksURLGateway();
        bricksList = gate.getBricksList(
                new URL("http://ourbricks.com/api/search?limit=5"));

        return bricksList;
    }
    
    static void setButtonData(OurBricksList bricksList, final JButton [] buttonArray, final JLabel [] labelArray) {
        int i = 0;
        for (final OurBrick brick : bricksList.getItems()) {
            final int finalI = i;

            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    JButton jButton = buttonArray[finalI];
                    JLabel jLabel = labelArray[finalI];
                    jLabel.setText(brick.getTitle());
                    jButton.setText(brick.getTitle());
                    jButton.setIcon(new javax.swing.JLabel() {

                        @Override
                        public javax.swing.Icon getIcon() {
                            try {
                                return new javax.swing.ImageIcon(
                                        new java.net.URL(brick.getThumbnail_link()));
                            } catch (java.net.MalformedURLException e) {
                            }
                            return null;
                        }
                    }.getIcon());
                }
            });
            i++;
        }
    }
}
