package com.learncamel.direct;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 22/11/17.
 */
public class SampleMockRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
