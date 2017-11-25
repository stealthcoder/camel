package com.learncamel.eip.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 25/11/17.
 */
public class ContentBasedRouterRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:input?noop=true")//noop - Dont perform any operation after moving the content.
        .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                .when(header("CamelFileNameConsumed").endsWith(".html"))
                    .to("file:html")
                .when(header("CamelFileNameConsumed").endsWith(".txt"))
                    .to("file:text")
                .when(header("CamelFileNameConsumed").endsWith(".json"))
                    .to("file:json")
                .otherwise()
                    .to("file:other").stop()//this content will not be copied to 'all' dir,
                // while the other 3 contents (no stop) will also be in all dir
                .end()
                .to("file:all");// not part of the above content-based route options
        // but an entirely different route to store all files
    }
}
