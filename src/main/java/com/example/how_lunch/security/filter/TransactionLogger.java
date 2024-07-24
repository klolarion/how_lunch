package com.example.how_lunch.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
        String UId = httpRequest.getParameter("userId");
        long userId = 0L;

        if (UId != null) {
            try {
                userId = Long.parseLong(UId);
            } catch (NumberFormatException e) {
                System.out.println("Invalid userId format: " + UId);
            }
        }

        if (path == null) {
            chain.doFilter(request, response);
            return;
        }

        if (path.contains("doDeposit")) {
            System.out.println("[User ID : " + userId + "] Deposit Request");
        } else if (path.contains("doWithdraw")) {
            System.out.println("[User ID : " + userId + "] Withdraw Request");
        } else if (path.contains("doTransfer")) {
            System.out.println("[User ID : " + userId + "] Transfer Request");
        }

        // 다음 필터 또는 서블릿 호출
        chain.doFilter(request, response);
    }
}
