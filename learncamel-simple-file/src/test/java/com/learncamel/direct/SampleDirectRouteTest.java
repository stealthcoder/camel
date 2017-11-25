package com.learncamel.direct;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by ted on 22/11/17.
 */
public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {

        /**
         * Producer Template
         */
        super.template.sendBody("direct:sampleInput","Hello");

        Thread.sleep(5000);


        File file = new File("sampleOutput");

        assertTrue(file.isDirectory());
    }
}
