package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jos
 */
public class OurBricksFAKEGateway implements OurBricksGateway {

    /**
     * A FAKE request to avoid contacting the external service. A simple string
     * reply is expected
     * @param remoteURL the URL to be accessed.
     * @return a string with the data (expected stringified JSON).
     * @throws MalformedURLException
     * @throws IOException
     */
    private String ourBricksGETConnection(URL remoteURL) throws MalformedURLException, IOException {
        
        return OurBricksListTest.JSONListResponse;
    }

    /**
     * Transformation of the data gathered from the external service (or fake in
     * this case) into an OurBricksList using the GSON library
     * @param remoteURL the URL to be accessed.
     * @return An OurBricksList with handles to next/previous search if available
     * and a List of OurBrick models.
     * @throws MalformedURLException
     * @throws IOException
     */
    public OurBricksList getBricksList(URL remoteURL) throws MalformedURLException, IOException{
        return (new Gson()).fromJson(ourBricksGETConnection(remoteURL), OurBricksList.class);
    }

}
