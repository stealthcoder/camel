package com.learncamel.routes.jdbc;

import com.learncamel.routes.rest.RestRoute;
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
public class DBPostgresRouteTest extends CamelTestSupport{

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception{
        return new DBPostgresRoute();
    }

    @Override
    public CamelContext createCamelContext() {

        String url = "jdbc:postgresql://localhost:5432/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource",dataSource);

        CamelContext context = new DefaultCamelContext(registry);
        // plug in a seda component, as we don't really need an embedded broker
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
    public void insertData(){
        String inputJson = "{\"name\":\"United States of America\",\"topLevelDomain\":[\".us\"],\"alpha2Code\":\"US\",\"alpha3Code\":\"USA\",\"callingCodes\":[\"1\"],\"capital\":\"Washington, D.C.\",\"altSpellings\":[\"US\",\"USA\",\"United States of America\"],\"region\":\"Americas\",\"subregion\":\"Northern America\",\"population\":323947000,\"latlng\":[38.0,-97.0],\"demonym\":\"American\",\"area\":9629091.0,\"gini\":48.0,\"timezones\":[\"UTC-12:00\",\"UTC-11:00\",\"UTC-10:00\",\"UTC-09:00\",\"UTC-08:00\",\"UTC-07:00\",\"UTC-06:00\",\"UTC-05:00\",\"UTC-04:00\",\"UTC+10:00\",\"UTC+12:00\"],\"borders\":[\"CAN\",\"MEX\"],\"nativeName\":\"United States\",\"numericCode\":\"840\",\"currencies\":[{\"code\":\"USD\",\"name\":\"United States dollar\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"en\",\"iso639_2\":\"eng\",\"name\":\"English\",\"nativeName\":\"English\"}],\"translations\":{\"de\":\"Vereinigte Staaten von Amerika\",\"es\":\"Estados Unidos\",\"fr\":\"États-Unis\",\"ja\":\"アメリカ合衆国\",\"it\":\"Stati Uniti D'America\",\"br\":\"Estados Unidos\",\"pt\":\"Estados Unidos\"},\"flag\":\"https://restcountries.eu/data/usa.svg\",\"regionalBlocs\":[{\"acronym\":\"NAFTA\",\"name\":\"North American Free Trade Agreement\",\"otherAcronyms\":[],\"otherNames\":[\"Tratado de Libre Comercio de América del Norte\",\"Accord de Libre-échange Nord-Américain\"]}]}";
        //ProducerTemplate
        ArrayList responseList = template.requestBody("direct:dbInput", inputJson, ArrayList.class);

        System.out.println("responseList : " + responseList.size());

        assertNotEquals(0, responseList.size());
    }

}
