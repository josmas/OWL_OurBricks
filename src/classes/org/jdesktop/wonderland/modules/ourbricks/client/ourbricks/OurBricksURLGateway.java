package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import org.jdesktop.wonderland.modules.ourbricks.client.OurBricksJPanel;

/**
 *
 * @author jos
 */
public class OurBricksURLGateway implements OurBricksGateway {

    private File downloadedFile = null;

    public File getDownloadedFile() {
        return downloadedFile;
    }

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

    //TODO this is not responsibility of the data provider <-- delegate
    public void getBrickFile(final URL remoteURL, final String modelName, final OurBricksJPanel ourBricksJPanel) {

        if (ourBricksJPanel != null) {
            ourBricksJPanel.getImportButton().setEnabled(false);
        }
        SwingWorker worker = new SwingWorker<File, Void>() {

            @Override
            protected File doInBackground() throws MalformedURLException, IOException {
                File result = new File(System.getProperty("java.io.tmpdir")
                        + System.getProperty("file.separator") + modelName
                        + System.getProperty("file.separator") + "ourbricks.zip");
                result.mkdirs();
                result.delete();
                System.out.println("GONNA download the file to: " + result);

                URL url = remoteURL;
                URLConnection con = url.openConnection();
                int lenghtOfFile = con.getContentLength();
                InputStream reader = url.openStream();

                FileOutputStream writer = new FileOutputStream(result);
                byte[] buffer = new byte[153600];
                int totalBytesRead = 0;
                int bytesRead = 0;

                while ((bytesRead = reader.read(buffer)) > 0) {
                    writer.write(buffer, 0, bytesRead);
                    buffer = new byte[153600];
                    totalBytesRead += bytesRead;
                    setProgress((int) (totalBytesRead * 100 / lenghtOfFile));
                }

                writer.close();
                reader.close();
                return result;
            }

            @Override
            protected void done() {
                if (ourBricksJPanel != null) {
                    ourBricksJPanel.getImportBar().setValue(0);
                }
                try {
                    downloadedFile = get();
                    //TODO what to do with this result? can add to a list and make available in Panel
                    System.out.println(downloadedFile.toString() + " has been downloaded");
                } catch (InterruptedException ie) { //Ignore interruptions
                } catch (ExecutionException ee) {
                    String why = null;
                    Throwable cause = ee.getCause();
                    if (cause != null) {
                        why = cause.getMessage();
                    } else {
                        why = ee.getMessage();
                    }
                    Logger.getLogger(OurBricksURLGateway.class.getName()).log(Level.SEVERE, why, ee);
                }
            }
        };

        PropertyChangeListener listener =
                new PropertyChangeListener() {

                    public void propertyChange(PropertyChangeEvent event) {
                        if ("progress".equals(event.getPropertyName())) {
                            if (ourBricksJPanel != null) {
                                ourBricksJPanel.getImportBar().setValue((Integer) event.getNewValue());
                            }
                        }
                    }
                };
        worker.addPropertyChangeListener(listener);
        worker.execute();

    }
}