package com.example.how_lunch.controller;

import com.example.how_lunch.dto.UserInfoDto;
import com.example.how_lunch.model.Transaction;
import com.example.how_lunch.service.AccountService;
import com.example.how_lunch.service.AccountServiceImpl;
import com.example.how_lunch.service.BankService;
import com.example.how_lunch.service.BankServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 최초생성 2024.07.23 - 김재근
 * */

@WebServlet("/account/*")
public class AccountController extends HttpServlet {
    private final String BASEPATH = "/WEB-INF/views";

    private static final int PAGE_SIZE = 10;
    private AccountService accountService = new AccountServiceImpl();
    private BankService bankService = new BankServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getParameter("path");
        String accountNumber = req.getParameter("accountNumber");
        String o = req.getParameter("order");
            String order = "desc";
        if(o != null) {
            order = o;
        }

        if (path == null) {
            long userId = 1L;
            int page = 1;
            String p = req.getParameter("page");
            if (p != null) {
                page = Integer.parseInt(p);
            }

            List<UserInfoDto> accounts = accountService.getAllAccounts(userId);
            List<Transaction> transactions = accountService.getAccountTransactions(userId, accountNumber, page, PAGE_SIZE, order);

            int totalTransactions = accountService.getAccountTransactionCount(userId, accountNumber);
            int totalPages = (int) Math.ceil((double) totalTransactions / PAGE_SIZE);


            req.setAttribute("userId", userId);
            req.setAttribute("account", accounts);
            req.setAttribute("accountNumber", accountNumber);

            req.setAttribute("transactions", transactions);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("order", order);


            req.getRequestDispatcher(BASEPATH + "/accountView.jsp").forward(req, resp);
        }
    }
}