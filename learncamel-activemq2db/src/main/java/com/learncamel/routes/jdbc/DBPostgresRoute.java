package com.learncamel.routes.jdbc;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 27/11/17.
 */
public class DBPostgresRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:dbInput")
                .to("log:?level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource");

    }
}
