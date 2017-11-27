package com.learncamel.routes.jms;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by ted on 25/11/17.
 */
public class JmsReadRouteTest extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new JmsReadRoute();

    }
    @Test
    public void readMessageFromActiveMQ() throws InterruptedException {

        String expected ="123 test";
        String response = consumer.receiveBody("direct:readQueue", String.class);
        System.out.println("The response is : " + response);
        assertEquals(expected,response);
    }
}
