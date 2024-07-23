package com.example.how_lunch.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

public class DBUtil {
    public static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db?useSSL=false&serverTimezone=UTC",
                    "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
