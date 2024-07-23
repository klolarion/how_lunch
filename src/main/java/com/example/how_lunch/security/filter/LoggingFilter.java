package com.example.how_lunch.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("initFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("doFilter");

        long start = System.currentTimeMillis();
        System.out.println("Request to " + ((HttpServletRequest) request).getRequestURI());

        chain.doFilter(request, response);

        long end = System.currentTimeMillis();
        System.out.println("Processing time : " + (end - start) + "ms");
        System.out.println("Request from " + ((HttpServletRequest) request).getRequestURI());

    }

    @Override
    public void destroy() {
        System.out.println("destroyFilter");
    }
}
