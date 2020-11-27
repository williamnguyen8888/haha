package com.william.Dao;

import java.sql.*;

public class AdminDAO {
    public static Boolean addInforProduct(String categoryId, String quantity,String price, String description, String nameProduct,String imgMain,String img1,String img2,String img3,String img4,String sizeS,String sizeM,String sizeL,String sizeXL,String sizeXXL){
        Connection conn = null;
        boolean isValid = false;
        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
            String query = "insert into product(categoryId, quantity, price, description, nameProduc, imgMain, img1, img2, img3, img4, Size_S, Size_M, Size_L, Size_XL, Size_XXL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
//                pre.setString(1,categoryId);
                pre.setString(1,categoryId);
                pre.setString(2,quantity);
                pre.setString(3,price);
                pre.setString(4,description);
                pre.setString(5,nameProduct);
                pre.setString(6,imgMain);
                pre.setString(7,img1);
                pre.setString(8,img2);
                pre.setString(9,img3);
                pre.setString(10,img4);
                pre.setString(11,sizeS);
                pre.setString(12,sizeM);
                pre.setString(13,sizeL);
                pre.setString(14,sizeXL);
                pre.setString(15,sizeXXL);

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
    public static Boolean EditProduct(String ProductId,String categoryId, String quantity,String price, String description, String nameProduct,String imgMain,String img1,String img2,String img3,String img4,String sizeS,String sizeM,String sizeL,String sizeXL,String sizeXXL){
        Connection conn = null;
        boolean isValid = false;
        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
            String query = "UPDATE product SET categoryId = ?, quantity= ?, price = ?, description = ?, nameProduc = ?, imgMain = ?,img1 = ?,img2 = ?,img3=?,img4=?,Size_S = ?, Size_M=?, Size_L= ?, Size_XL = ?, Size_XXL=? WHERE productId = ?;";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
//                pre.setString(1,categoryId);
                pre.setString(1,categoryId);
                pre.setString(2,quantity);
                pre.setString(3,price);
                pre.setString(4,description);
                pre.setString(5,nameProduct);
                pre.setString(6,imgMain);
                pre.setString(7,img1);
                pre.setString(8,img2);
                pre.setString(9,img3);
                pre.setString(10,img4);
                pre.setString(11,sizeS);
                pre.setString(12,sizeM);
                pre.setString(13,sizeL);
                pre.setString(14,sizeXL);
                pre.setString(15,sizeXXL);
                pre.setString(16,ProductId);

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
