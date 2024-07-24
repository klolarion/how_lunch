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
 * 최초생성 2024.07.22 - 김재근
 * 계좌상세페이지 분리, 페이징 추가 2024.07.23 김재근
 * */

@WebServlet("/bank/*")
public class BankController extends HttpServlet {

    private final String BASEPATH = "/WEB-INF/views";

    private static final int PAGE_SIZE = 10;
    private AccountService accountService = new AccountServiceImpl();
    private BankService bankService = new BankServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");

        String o = req.getParameter("order");
        String order = "desc";
        if(o != null) {
            order = o;
        }

        if (path == null) {
            long userId = 1L;
            int page = 1;
            String p = req.getParameter("page");
            if(p != null) {
                page = Integer.parseInt(p);
            }

            List<UserInfoDto> accounts = accountService.getAllAccounts(userId);
            List<Transaction> transactions = accountService.getMyAllTransactions(userId, page, PAGE_SIZE, order);
            int totalTransactions = accountService.getMyTransactionCount(userId);
            int totalPages = (int) Math.ceil((double) totalTransactions / PAGE_SIZE);


            req.setAttribute("userId", userId);
            req.setAttribute("accounts", accounts);
            req.setAttribute("username", accounts.get(0).getUsername());

            req.setAttribute("transactions", transactions);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);


            req.getRequestDispatcher(BASEPATH + "/myInfo.jsp").forward(req, resp);
        }else if(path.equals("deposit")){
            String accountNumber = req.getParameter("accountNumber");
            String balance = req.getParameter("balance");

            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher(BASEPATH + "/deposit.jsp").forward(req, resp);
        }else if(path.equals("withdraw")) {
            String accountNumber = req.getParameter("accountNumber");
            String balance = req.getParameter("balance");

            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher(BASEPATH + "/withdraw.jsp").forward(req, resp);
        }else if(path.equals("transfer")) {

            String accountNumber = req.getParameter("accountNumber");
            String balance = req.getParameter("balance");

            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher(BASEPATH + "/transfer.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getParameter("path");


        if(path.equals("doDeposit")){
            String accountNumber = req.getParameter("accountNumber");
            String amount = req.getParameter("amount");
            req.setAttribute("accountNumber", accountNumber);
            long userId = Long.parseLong(req.getParameter("userId"));

            bankService.deposit(userId, accountNumber, Double.parseDouble(amount));
            resp.sendRedirect("/bank");
        } else if(path.equals("doWithdraw")){
            String accountNumber = req.getParameter("accountNumber");

            String amount = req.getParameter("amount");
            long userId = Long.parseLong(req.getParameter("userId"));
            req.setAttribute("accountNumber", accountNumber);

            bankService.withdraw(userId, accountNumber, Double.parseDouble(amount));
            resp.sendRedirect("/bank");
        }else if(path.equals("doTransfer")){

            double amount = Double.parseDouble(req.getParameter("amount"));
            String myAccountNum = req.getParameter("myAccountNum");
            String targetAccountNum = req.getParameter("targetAccountNum");
            long userId = Long.parseLong(req.getParameter("userId"));

            bankService.transfer(userId, amount, myAccountNum, targetAccountNum);
            resp.sendRedirect("/bank");
        }
    }
}
