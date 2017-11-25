package com.learncamel.eip.recipientlist;

import org.apache.camel.Exchange;

/**
 * Created by ted on 25/11/17.
 */
public class RecipientEIPProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        String employeeType = exchange.getIn().getHeader("type", String.class);
        if(employeeType.equals("senior")){
            exchange.getIn().setHeader("type","file:xmlsenior");
        } else {
            exchange.getIn().setHeader("type","file:xmljunior");
        }

    }
}
