package com.learncamel.routes.exception;

import org.apache.camel.Exchange;

/**
 * Created by ted on 27/11/17.
 */
public class ExceptionProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Acutal Exceptipn Message "  + e.getMessage());
        System.out.println("Acutal Exceptipn Class "  + e.getClass());

        String failedEndpoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndpoint);

        exchange.getIn().setBody("Exception happened in the route.");
    }
}
