package com.ruftech.course_work;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase {


    private User user;
    private final String URL = "jdbc:mysql://localhost:3306/airlines";
    public Connection connection;
    public Statement statement;

    public DataBase(User user) {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, user.getLogin(), user.getPassword());
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
            AlertUtils.showErrorAlert("Error", "Login Error", throwables.getMessage());
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
            AlertUtils.showErrorAlert("Error", "Login Error", throwables.getMessage());
        }
    }
}
