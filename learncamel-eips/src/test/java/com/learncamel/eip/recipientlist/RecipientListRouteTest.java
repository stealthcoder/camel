package com.learncamel.eip.recipientlist;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by ted on 25/11/17.
 */
public class RecipientListRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() {

        return new RecipientListRoute();
    }

    @Test
    public void recipientListTest() throws InterruptedException {

        Thread.sleep(5000);

        File fileSenior = new File("xmlsenior");
        assertTrue(fileSenior.isDirectory());

        File fileJunior = new File("xmljunior");
        assertTrue(fileJunior.isDirectory());

    }
}