package com.learncamel.file;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 22/11/17.
 */
public class CopyFilesRoute extends RouteBuilder {

    public void configure() throws Exception {
        from( "file:data/input?noop=true")
                .to("file:data/output");
    }

}
