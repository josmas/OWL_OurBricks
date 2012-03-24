package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jdesktop.wonderland.modules.ourbricks.client.OurBricksJPanel;

/**
 *
 * @author jos
 */
public class OurBricksFAKEGateway implements OurBricksGateway {

    //TODO there is repetition here and in the Test classes; think aobut how
    // avoid that
    private String JSONresponse = "" +
                " {   \"price\": null, " +
                " \"thumbnail_link\": \"http://vu.ourbricks.com/6e2dd650eaa7832d88f4e8b70e3db611/processed/ourbricksThumb.jpg\", " +
                " \"username\": \"danx0r\", " +
                " \"description\": \"testing navigation\", " +
                " \"download_link\": \"http://vu.ourbricks.com/6e2dd650eaa7832d88f4e8b70e3db611/processed/ourbricks.zip\", " +
                " \"title\": \"kataspace main scene\", " +
                " \"viewer_link\": \"http://ourbricks.com/viewer/6e2dd650eaa7832d88f4e8b70e3db611\", " +
                " \"author\": \"\", " +
                " \"license_code\": \"ccby\", " +
                " \"id\": \"6e2dd650eaa7832d88f4e8b70e3db611\" " +
                " } ";


    private String JSONListResponse =

            " { " +
                " \"prev_start\": null, " +
                " \"items\": [ " +
                JSONresponse +
                " , " +
                JSONresponse +
                " ], " +
                " \"next_start\": 1 " +
            " } ";

    /**
     * A FAKE request to avoid contacting the external service. A simple string
     * reply is expected
     * @param remoteURL the URL to be accessed.
     * @return a string with the data (expected stringified JSON).
     * @throws MalformedURLException
     * @throws IOException
     */
    private String ourBricksGETConnection(URL remoteURL) throws MalformedURLException, IOException {
        
        return JSONListResponse;
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

    public File getBrickFile(URL remoteURL, String modelName) throws MalformedURLException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void getBrickFile(URL remoteURL, String modelName, OurBricksJPanel panel) throws MalformedURLException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
