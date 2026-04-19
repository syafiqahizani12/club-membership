/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.lab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (UserStore.passwordMap.containsKey(username)) {

            String storedPass = UserStore.passwordMap.get(username);
            String storedRole = UserStore.roleMap.get(username);

            if (storedPass.equals(password) && storedRole.equals(role)) {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                switch (role) {
                    case "manager":
                        response.sendRedirect("managerDashboard.jsp");
                        break;

                    case "trainer":
                        response.sendRedirect("trainerDashboard.jsp");
                        break;

                    case "member":
                        response.sendRedirect("memberDashboard.jsp");
                        break;

                    default:
                        response.sendRedirect("login.jsp");
                }

            } else {
                response.sendRedirect("login.jsp");
            }

        } else {
            response.sendRedirect("login.jsp");
        }
    }
}