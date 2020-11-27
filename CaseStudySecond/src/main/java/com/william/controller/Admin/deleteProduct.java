package com.william.controller.Admin;

import com.william.Dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteProduct" , urlPatterns = "/deleteProduct")
public class deleteProduct extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProductDelete = request.getParameter("idProductDelete");
        if (Integer.parseInt(idProductDelete) > 0){
            ProductDAO.deleteProduct(Integer.parseInt(idProductDelete));
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/productlist");
//            requestDispatcher.forward(request,response);
        }
    }
}
