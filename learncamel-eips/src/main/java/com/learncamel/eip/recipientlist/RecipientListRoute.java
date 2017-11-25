package com.learncamel.eip.recipientlist;

import org.apache.camel.builder.RouteBuilder;

/**
 *  How do we route a message to a list of dynamically specified recipients?
 *  Analogy are the recipient lists implemented in most e-mail systems
 *
 * http://www.enterpriseintegrationpatterns.com/patterns/messaging/RecipientList.html
 *
 *  Created by ted on 25/11/17.
 *
 */
public class RecipientListRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:xmlinput?noop=true")
                .setHeader("type", xpath("/employee/@type"))
                .process(new RecipientEIPProcessor())
                .recipientList(header("type"));//type -> file:<targetDir>
    }
}
