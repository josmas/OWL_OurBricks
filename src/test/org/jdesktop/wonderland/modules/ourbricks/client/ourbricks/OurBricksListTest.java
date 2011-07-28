package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jos
 */
public class OurBricksListTest {

    static final String JSONListResponse =

            " { " +
                " \"prev_start\": null, " +
                " \"items\": [ " +
                OurBricksTest.JSONresponse +
                " , " +
                OurBricksTest.JSONresponse +
                " ], " +
                " \"next_start\": 1 " +
            " } ";
    Gson gsonObject;
    OurBricksList brickList;

    @Before
    public void setUp() {
        gsonObject = new Gson();
        brickList = gsonObject.fromJson(JSONListResponse, OurBricksList.class);
    }

    @After
    public void tearDown() {
    }


    @Test
    public void OurBricksListCreationTest(){
        OurBricksList bricksList = new OurBricksList();
        assertNotNull(bricksList);
        assertNotNull(gsonObject);

        assertNull(brickList.getPrev_start());
        assertTrue(1 == brickList.getNext_start().intValue());
        OurBrick brick = brickList.getItems().get(0);
        assertTrue((brick.getTitle()).equals("kataspace main scene"));
        brick = brickList.getItems().get(1);
        assertTrue((brick.getLicense_code()).equals("ccby"));

    }

    @Test
    public void OurBricksListIteration() throws MalformedURLException, IOException{

        int i = 0;
        for (final OurBrick brick : brickList.getItems()) {
            i++;
        }
        assertTrue( i == 2);
        assertTrue( brickList.getItems().size() == 2 );
    }

}