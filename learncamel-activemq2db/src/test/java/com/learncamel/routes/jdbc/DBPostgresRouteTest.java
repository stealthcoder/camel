package com.learncamel.routes.jdbc;

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
public class DBPostgresRouteTest extends CamelTestSupport {

    /**
     * Setup datasource and register in our CamelContext using SimpleRegistry
     * so it can be referred to in our routes.
     * @return
     */
    @Override
    public CamelContext createCamelContext() {

        String url = "jdbc:postgresql://localhost:32772/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource", dataSource);

        CamelContext context = new DefaultCamelContext(registry);


        return context;

    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new DBPostgresRoute();
    }

    @Test
    public void insertData() {

        String input = "first db input4";
        ArrayList<String> response = template.requestBody("direct:dbInput", input, ArrayList.class);

        System.out.println("responseList : " + response);
        assertNotEquals(0,response.size());

    }

    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("admin");
        ds.setUrl(connectURI);
        return ds;
    }
}


