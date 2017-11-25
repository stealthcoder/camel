package com.learncamel.routes.jms;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 25/11/17.
 */
public class JmsReadRoute extends RouteBuilder {

    public void configure() throws Exception {
        //connecting to activemq on a queue using actual queue (testQueue)
        from("activemq:queue:testQueue")
                .to("log:?level=INFO&showBody=true")
                .to("direct:readQueue");
    }
}
