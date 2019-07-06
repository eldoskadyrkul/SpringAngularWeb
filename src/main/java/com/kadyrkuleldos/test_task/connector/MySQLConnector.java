package com.kadyrkuleldos.test_task.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnector {

    private static final Log LOGGER = LogFactory.getLog(MySQLConnector.class);
    private static final String DATABASE = "com.mysql.jdbc.Driver";
    private static final String DATABASE_DRIVER = "jdbc:mysql://localhost:3306/test_application";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    private static MySQLConnector mySQLConnector;

    // init connection object
    private Connection connection;

    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_DRIVER, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                LOGGER.error("exception in connection", e);
            }
        }
        return connection;
    }

    private MySQLConnector() {}

    public static MySQLConnector getInstance() {
        if (mySQLConnector == null) {
            mySQLConnector = new MySQLConnector();
        }
        return mySQLConnector;
    }

}
