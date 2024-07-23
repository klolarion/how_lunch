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
 *
 * */

@WebServlet("/bank/*")
public class BankController extends HttpServlet {

    private final String BASEPATH = "/WEB-INF/views";
    private AccountService accountService = new AccountServiceImpl();
    private BankService bankService = new BankServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        String path = req.getParameter("path");

        if (path == null) {
            System.out.println("list");
            long userId = 1L;
            List<UserInfoDto> accounts = accountService.getAllAccounts(userId);
            List<Transaction> transactions = accountService.getMyAllTransactions(userId);


            req.setAttribute("accounts", accounts);
            req.setAttribute("username", accounts.get(0).getUsername());

            req.setAttribute("transactions", transactions);


            req.getRequestDispatcher(BASEPATH + "/myInfo.jsp").forward(req, resp);
        }else if(path.equals("deposit")){
            String accountNumber = req.getParameter("accountNumber");
            String balance = req.getParameter("balance");

            System.out.println("deposit");
            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher(BASEPATH + "/deposit.jsp").forward(req, resp);
        }else if(path.equals("withdraw")) {
            String accountNumber = req.getParameter("accountNumber");
            String balance = req.getParameter("balance");

            System.out.println("withdraw");
            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher(BASEPATH + "/withdraw.jsp").forward(req, resp);
        }else if(path.equals("transfer")) {
            String accountNumber = req.getParameter("accountNumber");
            String balance = req.getParameter("balance");

            System.out.println("transfer");
            req.setAttribute("accountNumber", accountNumber);
            req.setAttribute("balance", balance);
            req.getRequestDispatcher(BASEPATH + "/transfer.jsp").forward(req, resp);
        }else if(path.equals("accountView")) {
            String accountNumber = req.getParameter("accountNumber");

            long userId = 1L;
            UserInfoDto account = accountService.getAccount(userId, accountNumber);
            List<Transaction> transactions = accountService.getAccountTransactions(userId, accountNumber);

            System.out.println("accountView");
            req.setAttribute("account", account);
            req.setAttribute("transactions", transactions);
            req.getRequestDispatcher(BASEPATH + "/accountView.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doPost");
        String path = req.getParameter("path");


        if(path.equals("doDeposit")){
            System.out.println("doDeposit");
            String accountNumber = req.getParameter("accountNumber");
            String amount = req.getParameter("amount");
            req.setAttribute("accountNumber", accountNumber);
            long userId = Long.parseLong(req.getParameter("userId"));

            bankService.deposit(userId, accountNumber, Double.parseDouble(amount));
            resp.sendRedirect("/bank");
        } else if(path.equals("doWithdraw")){
            System.out.println("doWithdraw");

            String accountNumber = req.getParameter("accountNumber");

            String amount = req.getParameter("amount");
            long userId = Long.parseLong(req.getParameter("userId"));
            req.setAttribute("accountNumber", accountNumber);

            bankService.withdraw(userId, accountNumber, Double.parseDouble(amount));
            resp.sendRedirect("/bank");
        }else if(path.equals("doTransfer")){
            System.out.println("doTransfer");

            double amount = Double.parseDouble(req.getParameter("amount"));
            String myAccountNum = req.getParameter("myAccountNum");
            String targetAccountNum = req.getParameter("targetAccountNum");
            long userId = Long.parseLong(req.getParameter("userId"));

            bankService.transfer(userId, amount, myAccountNum, targetAccountNum);
            resp.sendRedirect("/bank");
        }
    }
}
