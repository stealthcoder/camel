package route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import route.onexception.OnExceptionHandlerRoute;

/**
 * Created by ted on 24/11/17.
 */
public class OnExceptionHandlerRouteTest extends CamelTestSupport{

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCheck(){

        String request=null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);

    }

    @Test
    public void exceptionCheck_nohandled(){

        String request=null;
        String expected = "Exception happened in the route.";
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);

        assertEquals(expected, response);
    }


    @Test
    public void exceptionCheck_ignored(){

        String request=null;
        String expected = null;
        final String response = template.requestBody("direct:exception", request, String.class);
        System.out.println("Response is  : " + response);

        assertEquals(expected, response);
    }

}
