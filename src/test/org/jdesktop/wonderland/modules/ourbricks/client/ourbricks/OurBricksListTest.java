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
    
    Gson gsonObject;
    OurBricksList brickList;

    @Before
    public void setUp() {
        gsonObject = new Gson();
        brickList = gsonObject.fromJson(OurBricksTest.JSONResponseTwo, OurBricksList.class);
    }

    @After
    public void tearDown() {
    }


    @Test
    public void OurBricksListCreationTest(){
        OurBricksList bricksList = new OurBricksList();
        assertNotNull(bricksList);
        assertNotNull(gsonObject);

        assertEquals(2, brickList.size());
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