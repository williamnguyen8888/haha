package com.william;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
    public static void insertCustomer(String query){
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(query);
//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}