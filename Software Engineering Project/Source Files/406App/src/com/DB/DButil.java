package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "password";
    private static final String H_CONN_STRING = "jdbc:hsqldb:Data/appData";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);

    }

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }

}
