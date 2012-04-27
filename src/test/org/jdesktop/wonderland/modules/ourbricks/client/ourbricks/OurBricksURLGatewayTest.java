package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.net.URL;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jos
 */
public class OurBricksURLGatewayTest {
    OurBricksURLGateway gateway;
    private String getURL = "http://ourbricks.com/api/search?q=kata*&limit=1";
    URL mockedURL;
    
    @Before
    public void setUp() {
        gateway = new OurBricksURLGateway();
    }

    @Test
    public void testgetBrickList() throws Exception {
        OurBricksList result = gateway.getBricksList(new URL(getURL));
        assertNotNull(result);
        System.out.println(result.getItems().get(0).getTitle());
    }

    @Test
    public void testExceptionGETConnection(){
        try{
            gateway.getBricksList(new URL("malformedURL"));
            fail("Exception expected");
        }
        catch (Exception e){
            //ignore
        }
    }
}