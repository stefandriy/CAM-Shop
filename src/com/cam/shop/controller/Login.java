package com.cam.shop.controller;

import com.cam.shop.dao.UserDAO;
import com.cam.shop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cam on 19.07.15.
 */
@WebServlet(name = "Login")
public class Login extends HttpServlet {

    void login (HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDAO.getUserByEmail(email);
        if (user.getPassword() == password) {

        }
        session.setAttribute("email", email);
        session.setAttribute("password", password);
    }

    void loguot (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("password");
    }
}
