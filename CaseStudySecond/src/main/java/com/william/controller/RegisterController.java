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

@WebServlet(name = "RegisterController", urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("userpassword");
            String email = request.getParameter("useremail");
            boolean isValue = AccountDAO.checkRegister(username,password,email);
            if (isValue){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                String userName=(String)session.getAttribute("username");
                String nameResult ;
                if(userName!=null)
                {
                    nameResult = userName;
                }else {
                    nameResult = "LOGIN";
                }
                request.setAttribute("nameResult",nameResult);
                Customer customer = AccountDAO.getInfo(username,password);
                request.setAttribute("infoCustomer",customer);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request,response);
            };
        }finally {
            writer.close();
        }
    }


}
