package com.learncamel.routes.jms2jdbc;

import com.learncamel.routes.jms.JmsReadRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by ted on 27/11/17.
 */
public class Jms2DBRouteTest extends CamelTestSupport{

    @Override
    public RouteBuilder createRouteBuilder() throws Exception {
        return new Jms2DBRoute();

    }
    @Override
    public CamelContext createCamelContext() {

        String url = "jdbc:postgresql://localhost:32772/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource", dataSource);

        CamelContext context = new DefaultCamelContext(registry);

        return context;

    }
    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("admin");
        ds.setUrl(connectURI);
        return ds;
    }
    @Test
    public void jms2DBRouteTest(){
        ArrayList<String> responseList = (ArrayList<String>) consumer.receiveBody("direct:output");
        System.out.println("responseList : "+ responseList.size());
        assertNotEquals(0,responseList.size());
    }
}
