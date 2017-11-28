package com.learncamel.routes.jdbc;

import org.apache.camel.Exchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by ted on 27/11/17.
 */
public class InsertProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        String input = (String) exchange.getIn().getBody();
        System.out.println("Input to be persisted : " + input);

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(input);

        String name = (String) jsonObject.get("name");
        String capital = (String) jsonObject.get("capital");


        String insertQuery = "INSERT INTO country_capital values ( ".concat("'").concat(name).concat("'").concat(",").concat("'").concat(capital).concat("'").concat(" )");
        System.out.println("Insert Query is : " + insertQuery);

        exchange.getIn().setBody(insertQuery);


    }
}
