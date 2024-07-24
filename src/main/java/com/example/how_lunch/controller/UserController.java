package com.example.how_lunch.controller;

import com.example.how_lunch.model.Users;
import com.example.how_lunch.service.AccountService;
import com.example.how_lunch.service.AccountServiceImpl;
import com.example.how_lunch.service.UserService;
import com.example.how_lunch.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private final String BASEPATH = "/WEB-INF/views";
    private UserService userService = new UserServiceImpl();
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        String path = req.getPathInfo();
        System.out.println("Path: " + path);
        if (path == null || path.equals("/login")) {
            req.getRequestDispatcher(BASEPATH + "/login.jsp").forward(req, resp);
        } else if (path.equals("/register")) {
            req.getRequestDispatcher(BASEPATH + "/register.jsp").forward(req, resp);
        } else if (path.equals("/logout")) {
            HttpSession session = req.getSession();
            session.invalidate(); // 세션 무효화
            resp.sendRedirect(req.getContextPath() + "/user/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        String path = req.getPathInfo();
        System.out.println("Path: " + path);

        if (path.equals("/doLogin")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            boolean success = userService.login(email, password); // 로그인 성공 여부 확인

            System.out.println("login success : " + success);

            if (success) {
                HttpSession session = req.getSession();
                session.setAttribute("email", email);
                resp.sendRedirect(req.getContextPath() + "/bank");
            } else {
                req.setAttribute("error", "Invalid credentials");
                req.getRequestDispatcher(BASEPATH + "/login.jsp").forward(req, resp);
            }
        } else if (path.equals("/doRegister")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            Users user = new Users();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            userService.newUser(user);
            resp.sendRedirect(req.getContextPath() + "/user/login");
        }
    }
}