package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jos
 */
public class OurBricksCuratorTest {

    @Before
    public void setUp() {
    }
    
    @Test
    public void should_return_empty_list() {
        OurBricksList curatedList;
        OurBricksList fakeList = (new Gson()).fromJson(OurBricksTest.JSONResponse, OurBricksList.class);
        OurBricksCurator curator = new OurBricksCurator();
        curatedList = curator.curateList(fakeList);
        assertNotNull(fakeList.getItems().get(0));
        assertNull(fakeList.getItems().get(0).getPrice());
        assertEquals(true, curatedList.isEmpty());
    }

    @Test
    public void should_return_a_list_with_one_model() {
        OurBricksList curatedList;
        OurBricksList fakeListTwo = (new Gson()).fromJson(OurBricksTest.JSONResponseTwo, OurBricksList.class);
        OurBricksCurator curator = new OurBricksCurator();
        curatedList = curator.curateList(fakeListTwo);
        assertNotNull(fakeListTwo.getItems().get(0));
        assertNull(fakeListTwo.getItems().get(0).getPrice());
        assertEquals(1, curatedList.size());
    }
}
