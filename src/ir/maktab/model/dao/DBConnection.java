package ir.maktab.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String URL = "jdbc:postgresql://127.0.0.1:5432/pharmacy";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "Rm@38936";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
