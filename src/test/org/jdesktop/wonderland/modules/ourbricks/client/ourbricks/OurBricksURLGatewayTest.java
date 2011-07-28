package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.net.URL;
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

        for (OurBrick brick : gateway.getBricksList(new URL ("http://ourbricks.com/api/search?q=truck")).getItems()) {
            System.out.println("The title is: " + brick.getTitle());
        }

//        when(mockedGateway.getBricksList(new URL(getURL)))
//                .thenReturn("{\"mocking\" : \"On\"}");

        mockedGateway.getBricksList(new URL(getURL));

        verify(mockedGateway).getBricksList(new URL(getURL));
//        //I don't understand very well this; if I stub a return, then asserting
//        //does not make much sense, so I guess here we want to verify that the
//        //call was done? Have to read more about mocks. Same for POST
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