package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 * @author jos
 */
public class OurBricksURLGateway implements OurBricksGateway {

    private static final Logger LOGGER =
            Logger.getLogger(OurBricksURLGateway.class.getName());
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(
            "org.jdesktop.wonderland.modules.ourbricks.client.Bundle");
    
    /**
     * A networked request is sent to the external service. An stringified JSON
     * reply is expected.
     * @param remoteRestURL the URL and data to be accessed.
     * @return String wrapping the JSON information read from the remote server.
     */
    private String ourBricksGETConnection(URL remoteURL) throws MalformedURLException, IOException {
        
        StringBuilder JSONReply = new StringBuilder("");
        URLConnection connection = remoteURL.openConnection();
        BufferedReader JSONReplyReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        String inputLine;
        while ((inputLine = JSONReplyReader.readLine()) != null) {
            JSONReply.append(inputLine);
        }
        
        JSONReplyReader.close();

        return JSONReply.toString();
    }
    
    
    /**
     * Transformation of the data gathered from the external service into an
     * OurBricksList using the GSON library
     * @param remoteURL the URL to be accessed.
     * @return An OurBricksList with handles to next/previous search if available
     * and a List of OurBrick models.
     * @throws MalformedURLException
     * @throws IOException
     */
    public OurBricksList getBricksList(URL remoteURL) throws MalformedURLException, IOException {
        return (new Gson()).fromJson(ourBricksGETConnection(remoteURL), OurBricksList.class);
    }

}
