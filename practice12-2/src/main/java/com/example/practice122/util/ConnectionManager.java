package com.example.practice122.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    static final String URL = "jdbc:postgresql://localhost:5432/postgres2";
    static final String USER = "postgres";
    static final String PASSWORD = "5432";

    public static Connection createConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
