package com.william.controller.Admin;

import com.william.Dao.AdminDAO;
import com.william.Dao.ProductDAO;
import com.william.model.CategoryModel;

import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddProduct", urlPatterns = {"/addProduct"})
public class AddProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("txt/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String TypeOfAccountId =(String) session.getAttribute("TypeOfAccountId");

            try {
                String categoryProduct = "10001";
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
                boolean isValue = AdminDAO.addInforProduct(categoryProduct, quantityProduct, priceProduct, descriptionProduct, nameProduct, imgProduct, imgProduct1, imgProduct2, imgProduct3, imgProduct4, sizeSProduct, sizeMProduct, sizeLProduct, sizeXLProduct, sizeXXLProduct);

                if (isValue) {
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/admin/html/formAdd.jsp");
                    requestDispatcher.forward(request, response);
                }
            } finally {
                writer.close();
            }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String TypeOfAccountId =(String) session.getAttribute("TypeOfAccountId");
        if (TypeOfAccountId == null){
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/404");
//            requestDispatcher.forward(req,resp);
            resp.sendRedirect("/404");

        }else {
            if (TypeOfAccountId.equals("10001")){
                ArrayList<CategoryModel> categoryList = ProductDAO.loadCategory();
                req.setAttribute("categoryList", categoryList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/admin/html/formAdd.jsp");
                requestDispatcher.forward(req,resp);
            }else {
//                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/404");
//                requestDispatcher.forward(req,resp);
                resp.sendRedirect("/404");

            }
        }



    }
}
