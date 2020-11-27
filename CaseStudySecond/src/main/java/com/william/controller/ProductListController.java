package com.william.controller;

import com.william.Dao.ProductDAO;
import com.william.model.CategoryModel;
import com.william.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductListController", urlPatterns = "/sanpham")
public class ProductListController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        ArrayList<CategoryModel> categoryList = ProductDAO.loadCategory();
        request.setAttribute("categoryListProduct", categoryList);
        String categoryId = request.getParameter("category");
        if (categoryId == null){
            ArrayList<Product> products = ProductDAO.getProductInDb();
            request.setAttribute("products",products );
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-category.jsp");
            requestDispatcher.forward(request,response);
        }else {
            ArrayList<Product> products = ProductDAO.getProductByCate(categoryId);
            request.setAttribute("products",products );
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-category.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
