package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jos
 */
public class OurBricksFAKEGateway implements OurBricksGateway {

     /**
     * A GET REST request is sent to the external service. An JSON reply is expected.
     * @param remoteRestURL the URL and data to be accessed.
     * @return String wrapping the JSON information read from the remote server.
     */
    public String ourBricksGETConnection(URL remoteURL) throws MalformedURLException, IOException {
        
        return OurBricksListTest.JSONListResponse;
    }

}
