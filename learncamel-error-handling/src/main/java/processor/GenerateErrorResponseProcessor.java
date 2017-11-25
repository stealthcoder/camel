package processor;

import org.apache.camel.Exchange;

/**
 * Created by ted on 24/11/17.
 */
public class GenerateErrorResponseProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Actual Exception Message "  + e.getMessage());
        System.out.println("Actual Exception Class "  + e.getClass());

        String failedEndoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndoint);


        exchange.getIn().setBody("Exception happened in the route.");
    }
}
