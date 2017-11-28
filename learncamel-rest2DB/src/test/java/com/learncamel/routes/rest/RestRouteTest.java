package com.learncamel.routes.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by ted on 27/11/17.
 */
public class RestRouteTest extends CamelTestSupport{

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception{
        return new RestRoute();
    }

    @Test
    public void restCall_us(){

        String response = template.requestBody("direct:restCall", "us", String.class);
        System.out.println("response : "+ response);
        assertNotNull(response);
    }
}
