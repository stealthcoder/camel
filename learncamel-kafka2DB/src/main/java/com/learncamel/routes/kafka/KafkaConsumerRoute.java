package com.learncamel.routes.kafka;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 28/11/17.
 */
public class KafkaConsumerRoute extends RouteBuilder {


    public void configure() throws Exception {

        //for camel-kafka versions prior 2.20.x
//        from("kafka:localhost:9092?topic=my-topic&groupId=group1&consumersCount=1&autoOffsetReset=latest")
//                .log("${body}")
//                .to("direct:readFromKafka");

        //for camel-kafka 2.20.x
        from("kafka:my-topic?brokers=localhost:9092&groupId=group1&consumersCount=1&autoOffsetReset=latest")
                .log("${body}")
                .to("direct:readFromKafka");



    }
}
