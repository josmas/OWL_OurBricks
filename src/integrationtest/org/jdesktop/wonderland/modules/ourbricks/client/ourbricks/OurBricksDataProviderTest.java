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

    @Test
    public void testfileToImport() throws Exception{

        String modelName = "scene2";
        File brickZipFile = OurBricksDataProvider.fileToImport("http://vu.ourbricks.com/65affc69f210a6acaab21378eca21b08/processed/ourbricks.zip", modelName);
        assertNotNull(brickZipFile);
        assertEquals("export.dae", brickZipFile.getName());
    }

}