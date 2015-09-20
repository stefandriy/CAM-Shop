package com.cam.shop.dao;

import com.cam.shop.entity.User;

import java.util.List;

/**
 * Created by cam on 14.07.15.
 */
public interface IUserDAO {
    List<User> getAllUsers();
    List<User> findAllByKeyword(String keyword);
    List<User> findUsersByRole(String role);
    User getUserById (Integer id);
    User getUserByEmail (String email);
    void activate(Integer id);
    void deactivate(Integer id);
    void insert(User user);
    void update(User user);
    void delete (Integer usrId);
}
