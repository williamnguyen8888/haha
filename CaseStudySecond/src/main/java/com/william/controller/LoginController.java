package com.william.controller;

import com.william.Dao.AccountDAO;
import com.william.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController",urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean isValue = AccountDAO.checkLogin(username,password);
            if (isValue){
                Customer customer = AccountDAO.getInfo(username,password);
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                String TypeOfAccountId = String.valueOf(customer.getTypeAccountId()) ;
                session.setAttribute("TypeOfAccountId", TypeOfAccountId);
                String userName=(String)session.getAttribute("username");
                String nameResult ;
                if(userName!=null)
                {
                    nameResult = userName;
                }else {
                    nameResult = "LOGIN";
                }
                request.setAttribute("nameResult",nameResult);
                request.setAttribute("infoCustomer",customer);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request,response);
            }
        }finally {
            writer.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req,resp);

    }
}
