package com.learncamel.eip.multicast;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 25/11/17.
 */
public class MultiCastRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("file:input?noop=true").multicast().stopOnException()//if one route fails, others can proceed
                .parallelProcessing()
                .to("file:output1", "file:output2");//by default it move files sequentially so call parallelProcessing()
    }
}
