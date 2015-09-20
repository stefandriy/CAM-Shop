package com.cam.shop.tests;

import com.cam.shop.dao.UserDAO;
import com.cam.shop.entity.User;

import java.util.List;

/**
 * Created by cam on 16.07.15.
 */
public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = new User(1,"user1", "pas1","fN","lN",true,"admin");
        userDAO.insert(user);
        List<User> list = userDAO.getAllUsers();
        for (User u : list) {
            System.out.println(u.getId() + u.getEmail() + u.getPassword() + u.getEnabled());
        }
    }

}
