package com.learncamel.eip.wiretap;

import org.apache.camel.builder.RouteBuilder;

/**
 *  How do you inspect messages that travel on a point-to-point channel?
 * usecases
 * - debugging purposes
 * - testing, monitoring or troubleshooting,
 * it may be useful to be able to inspect all messages that travel across the channel.
 *
 * Created by ted on 25/11/17.
 */
public class WireTapRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:input?noop=true")
                .wireTap("file:debug")
                .to("file:all");
    }
}
