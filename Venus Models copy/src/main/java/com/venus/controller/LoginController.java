package com.venus.controller;

import com.venus.model.UserModel;
import com.venus.service.LoginService;
import com.venus.util.PasswordUtil;
import com.venus.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"}) 

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Please enter both username and password.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            return;
        }

        UserModel user = loginService.getUserByUsername(username);

        if (user != null) {
            String encryptedInput = PasswordUtil.encrypt(username, password);

            if (encryptedInput != null && encryptedInput.equals(user.getPassword())) {
                // Login successful – set session
                SessionUtil.setAttribute(request, "username", user.getUserName());
                SessionUtil.setAttribute(request, "role", user.getUserRole());
                
               

                // Redirect based on role
                if ("admin".equalsIgnoreCase(user.getUserRole())) {
                    response.sendRedirect(request.getContextPath() + "/admin");
                } else {
                    response.sendRedirect(request.getContextPath() + "/clientdirectory");
                }
                return;
            }
        }

        // Login failed
        request.setAttribute("error", "Invalid username or password.");
        request.getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
    }
}

