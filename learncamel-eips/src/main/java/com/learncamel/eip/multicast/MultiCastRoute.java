package com.learncamel.eip.multicast;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 25/11/17.
 */
public class MultiCastRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:input?noop=true").multicast()
                .to("file:output1", "file:output2");
    }
}
