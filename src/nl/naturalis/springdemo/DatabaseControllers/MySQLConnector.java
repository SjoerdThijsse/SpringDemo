package nl.naturalis.springdemo.DatabaseControllers;

import java.sql.*;

/**
 * Created by sjoerd.thijsse on 11/02/2016.
 */
public class MySQLConnector {

    private static Connection connection = null;

    private final static String DB_URL = "";
    private final static String USERNAME  = "";
    private final static String PASSWORD  = "";

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
