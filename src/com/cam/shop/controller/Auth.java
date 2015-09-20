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
import java.util.Map;

/**
 * Created by cam on 17.07.15.
 */
@WebServlet(name = "Auth")
public class Auth extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.
            session = request.getSession();
        } else {
            // Already created.
        }
        UserDAO userDAO = new UserDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDAO.getUserByEmail(email);
        if (user.getPassword() == password) {

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
