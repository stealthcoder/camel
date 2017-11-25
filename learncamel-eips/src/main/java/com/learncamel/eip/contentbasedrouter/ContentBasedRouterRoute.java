package com.learncamel.eip.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 25/11/17.
 */
public class ContentBasedRouterRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:input?noop=true")//noop - Dont perform any operation after moving the content.
        .to("log:?level=INFO@showBody=true&showHeaders=true")
                .choice()
                .when(header("CamelFileNamedConsumed").endsWith(".html"))
                    .to("file:html")
                .when(header("CamelFileNamedConsumed").endsWith(".txt"))
                    .to("file:text")
                .when(header("CamelFileNamedConsumed").endsWith(".json"))
                    .to("file:json")
                .otherwise()
                    .to("file:other")
                .end()
                .to("file:all");
    }
}
