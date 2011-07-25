package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.net.URL;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksGateway;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksURLGateway;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jos
 */
public class OurBricksURLGatewayTest {
    private OurBricksGateway mockedGateway;
    OurBricksURLGateway gateway;
    private String getURL = "http://ourbricks.com/api/search?q=kata*&limit=1";
    URL mockedURL;
    
    @Before
    public void setUp() {
        mockedGateway = mock(OurBricksGateway.class);
        gateway = new OurBricksURLGateway();
//        mockedURL = mock(URL.class); // CANNOT mock a final class
    }

    @Test
    public void testrestGETConnection() throws Exception {

//        String response = gateway.ourBricksGETConnection(new URL(getURL));
//        System.out.println("The response is: " + response);

        when(mockedGateway.ourBricksGETConnection(new URL(getURL)))
                .thenReturn("{\"mocking\" : \"On\"}");

        mockedGateway.ourBricksGETConnection(new URL(getURL));

        verify(mockedGateway).ourBricksGETConnection(new URL(getURL));
//        //I don't understand very well this; if I stub a return, then asserting
//        //does not make much sense, so I guess here we want to verify that the
//        //call was done? Have to read more about mocks. Same for POST
    }

    @Test
    public void testExceptionGETConnection(){
        try{
            gateway.ourBricksGETConnection(new URL("malformedURL"));
            fail("Exception expected");
        }
        catch (Exception e){
            //ignore
        }
    }

}