package org.jdesktop.wonderland.modules.ourbricks.client.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.login.LoginManager;

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
     * A GET REST request is sent to the external service. An JSON reply is expected.
     * @param remoteRestURL the URL and data to be accessed.
     * @return String wrapping the JSON information read from the remote server.
     */
    public String ourBricksGETConnection(URL remoteURL) throws MalformedURLException, IOException {
        
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

}
