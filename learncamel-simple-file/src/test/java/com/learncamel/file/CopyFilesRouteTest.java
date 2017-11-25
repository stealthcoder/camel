package com.learncamel.file;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by ted on 22/11/17.
 */
public class CopyFilesRouteTest extends CamelTestSupport {

    //automatically adds this route to the context
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException{

        //to allow processing completion
        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());

        assertEquals( 2, file.listFiles().length);

    }

}
