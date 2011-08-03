/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import static org.junit.Assert.*;
import java.io.File;
import org.jdesktop.wonderland.modules.ourbricks.client.OurBricksDataProvider;
import org.junit.Test;

/**
 *
 * @author jos
 */
public class OurBricksDataProviderTest {

    //TODO this test touches external resources (file system) Separate as an Integration test!
    @Test
    public void testfileToImport() throws Exception{

        String modelName = "scene2";
        File brickZipFile = OurBricksDataProvider.fileToImport("http://localhost/drupal/ourbricks.zip", modelName);
        assertNotNull(brickZipFile);
        assertTrue(brickZipFile.getName().equals("scenenew2.dae"));
    }

}