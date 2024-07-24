//package com.example.how_lunch.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*")
//public class AuthFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) {
//        System.out.println("Start filter - Authentication logging");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        if((httpRequest.getSession() == null)){
//            System.out.println("Session is closed");
//            httpResponse.sendRedirect("/login");
//        }
//    }
//}
