/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

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

    private String JSONresponse =

            " { " +
                " \"prev_start\": null, " +
                " \"items\": [ " +
                OurBricksTest.JSONresponse +
                " ], " +
                " \"next_start\": 1 " +
            " } ";

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void OurBricksListCreationTest(){
        OurBricksList bricksList = new OurBricksList();
        assertNotNull(bricksList);
        
        Gson gsonObject = new Gson();
        assertNotNull(gsonObject);

        OurBricksList brickList = gsonObject.fromJson(JSONresponse, OurBricksList.class);
        assertNull(brickList.getPrev_start());
        assertTrue(1 == brickList.getNext_start().intValue());
        OurBrick brick = brickList.getItems().get(0);
        assertTrue((brick.getTitle()).equals("kataspace main scene"));

    }

}