package com.learncamel.launch;

import org.apache.camel.main.Main;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by ted on 27/11/17.
 */
public class AppLauncher {

    public static void main(String[] args) {
        Main main = new Main();

        String url = "jdbc:postgresql://localhost:5432/localDB";

        main.bind("myDataSource",setupDataSource(url));

    }

    private static DataSource setupDataSource(String connectionURI) {

        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("admin");
        ds.setUrl(connectURI);
        return ds;

    }
}
