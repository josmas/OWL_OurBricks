package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
     * Retrieves a file from the external URL
     * @param remoteURL the URL where the file resides
     * @return a File in a temporary location
     * @throws MalformedURLException
     * @throws IOException
     */
    public File getBrickFile(URL remoteURL, String modelName) throws MalformedURLException, IOException;

}
