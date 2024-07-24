package com.example.how_lunch.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Start filter - Authentication logging");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestUri = httpRequest.getRequestURI();


        String token = null;
        String UID = null;

        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
                if ("UID".equals(cookie.getName())) {
                    UID = cookie.getValue();
                }
            }
        }

        if(requestUri.contains("/login") ||
                requestUri.contains("/register") ||
                requestUri.contains("/doRegister") ||
                requestUri.contains("/doLogin")){
            chain.doFilter(request, response);
        }else if(token == null || !token.equals("인증토큰")) {
            ((HttpServletResponse) response).sendRedirect("/user/login");
        }else if(token.equals("인증토큰")){
            httpRequest.setAttribute("UID", UID);
            chain.doFilter(request, response);
        }
    }
}
