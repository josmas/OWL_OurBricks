package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        OurBricksList results = (new OurBricksCurator()).curateList((new Gson()).fromJson(ourBricksGETConnection(remoteURL), OurBricksList.class));
        return results;
    }

    public File getBrickFile(URL remoteURL, String modelName) throws MalformedURLException, IOException {

        File result = new File(System.getProperty("java.io.tmpdir")
                + System.getProperty("file.separator") + modelName
                + System.getProperty("file.separator") + "ourbricks.zip");
        result.mkdirs();
        result.delete();
        
        URL url = remoteURL;
        url.openConnection();
        InputStream reader = url.openStream();

        FileOutputStream writer = new FileOutputStream(result);
        byte[] buffer = new byte[153600];
        int totalBytesRead = 0;
        int bytesRead = 0;


        while ((bytesRead = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, bytesRead);
            buffer = new byte[153600];
            totalBytesRead += bytesRead;
        }

        System.out.println("Done. " + (new Integer(totalBytesRead).toString()) + " bytes read.\n");
        writer.close();
        reader.close();

        return result;

    }

}


