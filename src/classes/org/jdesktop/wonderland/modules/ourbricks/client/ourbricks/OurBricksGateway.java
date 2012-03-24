package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jdesktop.wonderland.modules.ourbricks.client.OurBricksJPanel;

/**
 *
 * @author jos
 */
public interface OurBricksGateway {

    /**
     * Get a list of OurBrick models and two handlers to a previous or next search
     * if available.
     * @param remoteURL the URL to be accessed.
     * @return the list of type OurBricksList
     * @throws MalformedURLException
     * @throws IOException
     */
    public OurBricksList getBricksList(URL remoteURL) throws MalformedURLException, IOException;

    /**
     * Retrieves a file from the external URL to a temporary location
     * @param remoteURL the URL where the file resides
     * @param modelName The name of the file to retrieve
     * @param panel The name of a panel that can receive state updates
     * @throws MalformedURLException
     * @throws IOException
     */
    public void getBrickFile(URL remoteURL, String modelName, OurBricksJPanel panel) throws MalformedURLException, IOException;

}
