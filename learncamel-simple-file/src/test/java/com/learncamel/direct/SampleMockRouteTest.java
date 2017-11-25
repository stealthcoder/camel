package com.learncamel.direct;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by ted on 22/11/17.
 */
public class SampleMockRouteTest extends CamelTestSupport {

    //automatically adds this route to the context
    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    /**
     * usecase: testing the message to a downstream systems that is not yet developed.
     * You can verify message/data format your component generates by mocking the data if correct
     * even if downstream systems are not yet done.
     * @throws InterruptedException
     */
    @Test
    public void sampleMockTest() throws InterruptedException {

        String expected ="Hello";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);

        String input = "Hello";
        template.sendBody("direct:sampleInput",input);

        assertMockEndpointsSatisfied();
    }
}
