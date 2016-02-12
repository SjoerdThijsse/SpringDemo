package nl.naturalis.springdemo.DatabaseControllers;

import java.sql.*;

/**
 * Created by sjoerd.thijsse on 11/02/2016.
 */
public class MySQLConnector {

    private Connection connection = null;

    private final static String DB_URL = "jdbc:mysql://localhost:3306/springdemo";
    private final static String USERNAME  = "sjoerd";
    private final static String PASSWORD  = "sjoerd";

    private static MySQLConnector instance = null;

    protected final static int  MYSQL_DUPLICATE_CODE = 1062;

    private MySQLConnector() {
        connection = connect();
    }

    public static MySQLConnector getInstance() {
        if (instance == null) {
            instance = new MySQLConnector();
        }
        return instance;
    }

    private Connection connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
