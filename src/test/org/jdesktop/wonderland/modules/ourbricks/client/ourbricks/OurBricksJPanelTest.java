package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import org.junit.Test;

/**
 *
 * @author jos
 */
public class OurBricksJPanelTest {

    private JButton[] buttonArray = new JButton[5];
    private JButton jButton1 = new JButton("cosa");
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    private JButton jButton5 = new JButton();

    private void addButtonsToArray(){
        buttonArray[0] = jButton1; buttonArray[1] = jButton2; buttonArray[2] = jButton3;
        buttonArray[3] = jButton4; buttonArray[4] = jButton5;
    }

    @Test
    public void testArrayOfButtons() throws MalformedURLException, IOException {
        addButtonsToArray();

        for (int i = 0; i < buttonArray.length; i++) {
            final int ii = i;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JButton jButton = buttonArray[ii];
                    jButton.setText("cacola_" + ii);
                }
            });
        }

    }

}