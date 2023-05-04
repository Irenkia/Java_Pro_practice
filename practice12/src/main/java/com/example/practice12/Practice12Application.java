package com.example.practice12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Practice12Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //SpringApplication.run(Practice12Application.class, args);
        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, "postgres", "5432");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from users");
        while(rs.next())
        {
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("user_id"));
        }
    }

}
