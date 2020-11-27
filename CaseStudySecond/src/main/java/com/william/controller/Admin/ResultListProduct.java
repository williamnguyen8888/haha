package com.william.controller.Admin;

import com.william.Dao.ProductDAO;
import com.william.model.CategoryModel;
import com.william.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ResultListProduct", urlPatterns = {"/productlist"})
public class ResultListProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        HttpSession session = request.getSession();
        String TypeOfAccountId =(String) session.getAttribute("TypeOfAccountId");
        if (TypeOfAccountId == null){
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/404.jsp");
//            requestDispatcher.forward(request,response);
            response.sendRedirect("/404");
        }else {
            if (TypeOfAccountId.equals("10001")){
                ArrayList<CategoryModel> categoryList = ProductDAO.loadCategory();
                request.setAttribute("categoryListEdit", categoryList);
                ArrayList<Product> products = ProductDAO.getProductInDb();
                request.setAttribute("productsReultAdmin",products );
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/html/resultListProduct.jsp");
                requestDispatcher.forward(request,response);
            }else {
//                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/404.jsp");
//                requestDispatcher.forward(request,response);
                response.sendRedirect("/404");

            }
        }


    }
}
