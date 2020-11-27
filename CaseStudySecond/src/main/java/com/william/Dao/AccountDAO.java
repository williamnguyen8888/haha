package com.william.Dao;

import com.william.model.Customer;

import java.sql.*;

public class AccountDAO {
    public static boolean checkLogin(String usernameCheck, String passwordCheck){
        Connection conn = null;
        boolean isValid = false;
        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
            String query = "select * from customer where username = ? and password = ?";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1,usernameCheck);
                pre.setString(2,passwordCheck);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    isValid = true;
                } else {
                    isValid = false;
                }
//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        } catch (SQLException | ClassNotFoundException e) {
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
        return isValid;
    }
    public static Customer getInfo(String usernameCheck, String passwordCheck){
        Connection conn = null;
        Customer customer = new Customer();
        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
            String query = "select * from customer where username = ? and password = ?";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1,usernameCheck);
                pre.setString(2,passwordCheck);
                ResultSet rs = pre.executeQuery();

                if(rs.next()){
                    customer.setUsername(rs.getString("username"));
                    customer.setFirstname(rs.getString("firsName"));
                    customer.setAddress(rs.getString("address"));
                    customer.setBirthDay(rs.getString("birthDay"));
                    customer.setCustomerID(Integer.parseInt(rs.getString("customerID")));
                    customer.setSurname(rs.getString("surName"));
                    customer.setPassword(rs.getString("password"));
                    customer.setPhoneNumber(rs.getString("phoneNumber"));
                    customer.setTypeAccountId(rs.getInt("TypeAccountId"));
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        } catch (SQLException | ClassNotFoundException e) {
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
        return customer;
    }
    public static boolean checkRegister(String usernameCheck, String passwordCheck, String emailCheck){
        Connection conn = null;
        boolean isValid = false;
        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
            String query = "insert into customer(username, password, email) values(?,?,?);";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1,usernameCheck);
                pre.setString(2,passwordCheck);
                pre.setString(3,emailCheck);

                int rs = pre.executeUpdate();
                if (rs > 0) {
                    isValid = true;
                } else {
                    isValid = false;
                }
//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        } catch (SQLException | ClassNotFoundException e) {
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
        return isValid;
    }
}
