package com.example.how_lunch.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/*")
public class AuthController extends HttpServlet {
    private final String BASEPATH = "/WEB-INF/views";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(BASEPATH + "/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");


        if(path.equals("doLogin")){
            String accountNumber = req.getParameter("accountNumber");
            String amount = req.getParameter("amount");
            req.setAttribute("accountNumber", accountNumber);
            long userId = Long.parseLong(req.getParameter("userId"));

            resp.sendRedirect("/bank");
        }
    }
}
