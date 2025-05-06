//package com.venus.filter;
//
//import com.venus.util.CookieUtil;
//import com.venus.util.SessionUtil;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
///**
// * Authentication filter for Venus Models that restricts access based on session and cookie role.
// */
//@WebFilter("/*")
//public class AuthenticationFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Optional: initialization logic
//    }
//
//    @Override
//    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        String uri = req.getRequestURI();
//        boolean isLoggedIn = SessionUtil.getAttribute(req, "username") != null;
//        String userRole = CookieUtil.getCookie(req, "role") != null
//                ? CookieUtil.getCookie(req, "role").getValue()
//                : null;
//
//        // Allow static resources and public pages
//        if (uri.contains("/resources/") || uri.endsWith("login.jsp") || uri.endsWith("register.jsp")
//                || uri.endsWith("login") || uri.endsWith("signup")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        if (isLoggedIn) {
//            if ("admin".equals(userRole) && uri.contains("/admin")) {
//                chain.doFilter(request, response);
//            } else if ("client".equals(userRole) && uri.contains("/client")) {
//                chain.doFilter(request, response);
//            } else {
//                res.sendRedirect("login.jsp");
//            }
//        } else {
//            res.sendRedirect("login.jsp");
//        }
//    }
//
//    @Override
//    public void destroy() {
//        // Optional: cleanup logic
//    }
//}
