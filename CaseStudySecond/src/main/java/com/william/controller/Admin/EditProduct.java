package com.william.controller.Admin;

import com.william.Dao.AdminDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditProduct",urlPatterns = "/editProduct")
public class EditProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            String ProductId = request.getParameter("ProductId");
            String categoryProduct = request.getParameter("categoryId");
            String nameProduct = request.getParameter("nameProduct");
            String priceProduct = request.getParameter("priceProduct");
            String descriptionProduct = request.getParameter("descriptionProduct");
            String imgProduct = request.getParameter("imgProduct");
            String imgProduct1 = request.getParameter("imgProduct1");
            String imgProduct2 = request.getParameter("imgProduct2");
            String imgProduct3 = request.getParameter("imgProduct3");
            String imgProduct4 = request.getParameter("imgProduct4");
            String quantityProduct = request.getParameter("quantityProduct");
            String sizeSProduct = request.getParameter("sizeSProduct");
            String sizeMProduct = request.getParameter("sizeMProduct");
            String sizeLProduct = request.getParameter("sizeLProduct");
            String sizeXLProduct = request.getParameter("sizeXLProduct");
            String sizeXXLProduct = request.getParameter("sizeXXLProduct");
            boolean isValue = AdminDAO.EditProduct(ProductId,categoryProduct, quantityProduct, priceProduct, descriptionProduct, nameProduct, imgProduct, imgProduct1, imgProduct2, imgProduct3, imgProduct4, sizeSProduct, sizeMProduct, sizeLProduct, sizeXLProduct, sizeXXLProduct);
            System.out.println(isValue);
            if (isValue) {
//                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/productlist");
//                requestDispatcher.forward(request, response);
                response.sendRedirect("/productlist");
            }
        } finally {
            writer.close();
        }
    }


}
