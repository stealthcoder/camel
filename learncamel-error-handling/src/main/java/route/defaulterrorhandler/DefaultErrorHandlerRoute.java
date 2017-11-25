package route.defaulterrorhandler;

import bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ted on 24/11/17.
 */
public class DefaultErrorHandlerRoute extends RouteBuilder {

    public void configure() throws Exception {

//        errorHandler(defaultErrorHandler());

        //Error Logging
//        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retryAttemptedLogLevel(LoggingLevel.WARN));

        //Error Logging exponential back off (so as not flood the server with exception, while giving it chance to recover)
        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));



        from("direct:exception")
                .bean(new DataModifier(), "map")
                .to("log:?level=INFO&showBody=true")
                .to("mock:errorqueue");
    }
}
