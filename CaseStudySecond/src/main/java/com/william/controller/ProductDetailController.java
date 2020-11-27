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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProductDetailController", urlPatterns = "/product")
public class ProductDetailController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String idProduct = request.getParameter("productId");
        Product productDetail = ProductDAO.getProductDetail(idProduct);
        request.setAttribute("productDetail",productDetail);
        ArrayList<CategoryModel> categoryListDetail = ProductDAO.loadCategory();
        request.setAttribute("categoryListDetail", categoryListDetail);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product.jsp");
        requestDispatcher.forward(request,response);
    }
}
