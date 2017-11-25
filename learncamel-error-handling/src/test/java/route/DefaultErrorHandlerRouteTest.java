package route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import route.defaulterrorhandler.DefaultErrorHandlerRoute;

/**
 * Created by ted on 24/11/17.
 */
public class DefaultErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck() throws InterruptedException {

        String expectedOutput = "123*dilip*12JAN17";
        String input=null;

        String output = template.requestBody("direct:exception", input, String.class);

        assertEquals(expectedOutput,output);


//        MockEndpoint mockEndpoint = getMockEndpoint("mock:errorqueue");
//        mockEndpoint.expectedBodiesReceived(expectedOutput);
//
//        template.sendBody("direct:exception",input);
//
//        assertMockEndpointsSatisfied();


    }

}
