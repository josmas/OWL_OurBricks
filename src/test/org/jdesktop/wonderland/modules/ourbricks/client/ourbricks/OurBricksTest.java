package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import static org.junit.Assert.*;
import com.google.gson.Gson;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBrick;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jos
 */
public class OurBricksTest {

    public OurBricksTest() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void createGsonObject(){
        Gson gsonObject = new Gson();
        assertNotNull(gsonObject);

        String response = "" +
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

        OurBrick brick = gsonObject.fromJson(response, OurBrick.class);
        assertTrue((brick.getTitle()).equals("kataspace main scene"));
    }
}