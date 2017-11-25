package route.onexception;

import bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.omg.CORBA.portable.ApplicationException;
import processor.GenerateErrorResponseProcessor;

import java.sql.SQLException;

/**
 * Created by ted on 24/11/17.
 */
public class OnExceptionHandlerRoute extends RouteBuilder {


    public void configure() throws Exception {
//
//        onException(RuntimeException.class, Exception.class).maximumRedeliveries(2).redeliveryDelay(5000).backOffMultiplier(2).log(LoggingLevel.INFO, "Exception in Bean caught here");
//
        onException(SQLException.class).log(LoggingLevel.ERROR, "Exception in Bean caught here");

        //handled(true) - overrides default error handling using custom handler
//        onException(RuntimeException.class).handled(true).maximumRedeliveries(2).process(new GenerateErrorResponseProcessor()).log(LoggingLevel.WARN, "Exception in Bean caught here");

        //onException(RuntimeException.class).log(LoggingLevel.WARN, "Exception in Bean caught here");

//        onException(ApplicationException.class).log(LoggingLevel.WARN, "Application Exception in Bean caught here");

        //Multiple Exceptions in same line
        //onException(ApplicationException.class).log(LoggingLevel.WARN, "Application Exception in Bean caught here");

        //  onException(SQLException.class).log(LoggingLevel.WARN, "Exception while connecting to DB");*/

        //With Re-delivery and redleivery delay
        // onException(RuntimeException.class,ApplicationException.class).maximumRedeliveries(2).redeliveryDelay(5000).log(LoggingLevel.WARN, "Exception in Processor caught here");

        //with Redelivery and Handled (e.g. Kafka)
        // onException(RuntimeException.class,ApplicationException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new GenerateErrorResponseProcessor()).log(LoggingLevel.WARN, "Exception in Processor caught here");
        // onException(RuntimeException.class,ApplicationException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new GenerateErrorResponseProcessor()).to("kafka:errortopic").log(LoggingLevel.WARN, "Exception in Processor caught here");

        //Ignoring Exception:
        //You cant use continued and handled in the same route.
        onException(RuntimeException.class,ApplicationException.class).continued(true).log(LoggingLevel.WARN, "Exception in Processor caught here");

        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }

}
