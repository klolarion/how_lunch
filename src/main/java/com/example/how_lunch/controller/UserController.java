package com.example.how_lunch.controller;

import com.example.how_lunch.service.AccountService;
import com.example.how_lunch.service.AccountServiceImpl;
import com.example.how_lunch.service.UserService;
import com.example.how_lunch.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 최초생성 2024.07.22 - 김재근
 *
 * */

@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private final String BASEPATH = "/WEB-INF/views";
    private UserService userService= new UserServiceImpl();
    private AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
