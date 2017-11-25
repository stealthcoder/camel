package com.learncamel.eip.contentbasedrouter;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by ted on 25/11/17.
 */
public class ContentBasedRouterTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new ContentBasedRouterRoute();
    }

    @Test
    public void contentBasedRouterTest() throws InterruptedException {

        Thread.sleep(5000);

        File file = new File("html");
        assertTrue(file.isDirectory());

        File file2 = new File("text");
        assertTrue(file2.isDirectory());

        File file3 = new File("json");
        assertTrue(file3.isDirectory());

        File file4 = new File("other");
        assertTrue(file4.isDirectory());

        File fileAll = new File("all");
        assertTrue(fileAll.isDirectory());
    }

}
