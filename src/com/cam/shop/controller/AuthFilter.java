package com.cam.shop.controller;

import com.cam.shop.dao.UserDAO;
import com.cam.shop.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cam on 19.07.15.
 */

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getSession(true);
            response.sendRedirect("login.jsp");
        } else {
            String email = (String) session.getAttribute("email");
            String password = (String) session.getAttribute("password");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByEmail(email);
            if(password.equals(user.getPassword())){
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                chain.doFilter(request, response);
            }
            else {response.sendRedirect("login.jsp");}
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
