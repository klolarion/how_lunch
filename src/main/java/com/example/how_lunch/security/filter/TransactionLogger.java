package com.example.how_lunch.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/*")
public class TransactionLogger implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Start filter - Transaction logging");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getParameter("path");

        String UID = null;

        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("UID".equals(cookie.getName())) {
                    UID = cookie.getValue();
                }
            }
        }
        String userId = "";

        if (UID != null) {
            userId = UID;
        }

        if (path == null) {
            chain.doFilter(request, response);
            return;
        }

        if (path.contains("doDeposit")) {
            System.out.println("[User ID : " + userId + "] Deposit Request - " + LocalDateTime.now());
        } else if (path.contains("doWithdraw")) {
            System.out.println("[User ID : " + userId + "] Withdraw Request - " + LocalDateTime.now());
        } else if (path.contains("doTransfer")) {
            System.out.println("[User ID : " + userId + "] Transfer Request - " + LocalDateTime.now());
        } else if (path.contains("newAccount")) {
            System.out.println("[User ID : " + userId + "] New account Request - " + LocalDateTime.now());
        }

        chain.doFilter(request, response);
    }
}
