package com.william.Dao;

import com.william.model.CategoryModel;
import com.william.model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    public static ArrayList<Product> getProductInDb() {
        Connection conn = null;
        ArrayList<Product> productsList = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            String query = "select * from product";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("productId"));
                    product.setCategoryId(rs.getInt("categoryId"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setPrice(rs.getInt("price"));
                    product.setDescription(rs.getString("description"));
                    product.setNameProduct(rs.getString("nameProduc"));
                    product.setImgMain(rs.getString("imgMain"));
                    product.setImg1(rs.getString("img1"));
                    product.setImg2(rs.getString("img2"));
                    product.setImg3(rs.getString("img3"));
                    product.setImg4(rs.getString("img4"));
                    product.setSize_S(rs.getInt("Size_S"));
                    product.setSize_M(rs.getInt("Size_M"));
                    product.setSize_L(rs.getInt("Size_L"));
                    product.setSize_XL(rs.getInt("Size_XL"));
                    product.setSize_XXL(rs.getInt("Size_XXL"));
                    productsList.add(product);
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
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
        return productsList;
    }

    public static ArrayList<Product> deleteProduct(int ProductId) {
        Connection conn = null;
        ArrayList<Product> productsList = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            String query = "DELETE FROM product WHERE productId = ?;";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setInt(1, ProductId);
                int rs = pre.executeUpdate();

//                while (rs.next()) {
//                    Product product = new Product();
//                    product.setProductId(rs.getInt("productId"));
//                    product.setCategoryId(rs.getInt("categoryId"));
//                    product.setQuantity(rs.getInt("quantity"));
//                    product.setPrice(rs.getInt("price"));
//                    product.setDescription(rs.getString("description"));
//                    product.setNameProduct(rs.getString("nameProduc"));
//                    product.setImgMain(rs.getString("imgMain"));
//                    product.setImg1(rs.getString("img1"));
//                    product.setImg2(rs.getString("img2"));
//                    product.setImg3(rs.getString("img3"));
//                    product.setImg4(rs.getString("img4"));
//                    product.setSize_S(rs.getInt("Size_S"));
//                    product.setSize_M(rs.getInt("Size_M"));
//                    product.setSize_L(rs.getInt("Size_L"));
//                    product.setSize_XL(rs.getInt("Size_XL"));
//                    product.setSize_XXL(rs.getInt("Size_XXL"));
//                    productsList.add(product);
//                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
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
        return productsList;
    }

    public static ArrayList<CategoryModel> loadCategory() {
        Connection conn = null;
        ArrayList<CategoryModel> categoryList = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            String query = "select * from category";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    CategoryModel categoryModel = new CategoryModel();
                    categoryModel.setCategoryID(rs.getInt("categoryId"));
                    categoryModel.setNameCategory(rs.getString("nameCategory"));
                    categoryModel.setImg_Category(rs.getString("Img_Category"));
                    categoryList.add(categoryModel);
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
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
        return categoryList;
    }
    public static ArrayList<Product> getProductByCate(String idCategory) {
        Connection conn = null;
        ArrayList<Product> productsList = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            String query = "select * from product where categoryId = ?";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, idCategory);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("productId"));
                    product.setCategoryId(rs.getInt("categoryId"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setPrice(rs.getInt("price"));
                    product.setDescription(rs.getString("description"));
                    product.setNameProduct(rs.getString("nameProduc"));
                    product.setImgMain(rs.getString("imgMain"));
                    product.setImg1(rs.getString("img1"));
                    product.setImg2(rs.getString("img2"));
                    product.setImg3(rs.getString("img3"));
                    product.setImg4(rs.getString("img4"));
                    product.setSize_S(rs.getInt("Size_S"));
                    product.setSize_M(rs.getInt("Size_M"));
                    product.setSize_L(rs.getInt("Size_L"));
                    product.setSize_XL(rs.getInt("Size_XL"));
                    product.setSize_XXL(rs.getInt("Size_XXL"));
                    productsList.add(product);
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
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
        return productsList;
    }
    public static Product getProductDetail(String productId) {
        Connection conn = null;
        Product product = new Product();
        Product productDetail = new Product();

        try {
            String url = "jdbc:mysql://localhost/mikencobrand";
            String USER_NAME = "root";
            String PASSWORD = "tuananhdeptrai";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
            String query = "select * from product where productId = ?";
            Statement stmt = null;
            try {
                PreparedStatement pre = conn.prepareStatement(query);
                pre.setString(1, productId);
                ResultSet rs = pre.executeQuery();

                while (rs.next()) {
                    productDetail.setProductId(rs.getInt("productId"));
                    productDetail.setCategoryId(rs.getInt("categoryId"));
                    productDetail.setQuantity(rs.getInt("quantity"));
                    productDetail.setPrice(rs.getInt("price"));
                    productDetail.setDescription(rs.getString("description"));
                    productDetail.setNameProduct(rs.getString("nameProduc"));
                    productDetail.setImgMain(rs.getString("imgMain"));
                    productDetail.setImg1(rs.getString("img1"));
                    productDetail.setImg2(rs.getString("img2"));
                    productDetail.setImg3(rs.getString("img3"));
                    productDetail.setImg4(rs.getString("img4"));
                    productDetail.setSize_S(rs.getInt("Size_S"));
                    productDetail.setSize_M(rs.getInt("Size_M"));
                    productDetail.setSize_L(rs.getInt("Size_L"));
                    productDetail.setSize_XL(rs.getInt("Size_XL"));
                    productDetail.setSize_XXL(rs.getInt("Size_XXL"));
                }


//                while (rs.next()) {
//                    String name = rs.getString("username");
//                    System.out.println(name);
//                }
            } catch (SQLException e) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
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
        return productDetail;
    }

}

