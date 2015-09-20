package com.cam.shop.dao;

import com.cam.shop.config.DBConfig;
import com.cam.shop.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cam on 16.07.15.
 */
public class UserDAO implements IUserDAO {
    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM User";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("usrId");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Boolean enabled = (rs.getInt("enabled") == 0) ? false : true;
                String role = rs.getString("role");
                User user = new User(id, email, password,
                        firstName, lastName, enabled, role);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public List<User> findAllByKeyword(String keyword) {
        List<User> allUsers = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM User WHERE " +
                "firstName LIKE '%" + keyword.trim() + "%' OR" +
                "lastName LIKE '%" + keyword.trim() + "%'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("usrId");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Boolean enabled = (rs.getInt("enabled") == 0) ? false : true;
                String role = rs.getString("role");
                User user = new User(id, email, password,
                        firstName, lastName, enabled, role);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public List<User> findUsersByRole(String role) {
        List<User> allUsers = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM User WHERE role ='" + role +"'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("usrId");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Boolean enabled = (rs.getInt("enabled") == 0) ? false : true;
                String r = rs.getString("role");
                User user = new User(id, email, password,
                        firstName, lastName, enabled, r);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public User getUserById(Integer usrId) {
        User user = null;
        Statement stmt;
        String query = "SELECT * FROM User WHERE usrId = " + usrId;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Integer id = rs.getInt("usrId");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            Boolean enabled = (rs.getInt("enabled") == 0) ? false : true;
            String role = rs.getString("role");
            user = new User(id, email, password,
                    firstName, lastName, enabled, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByEmail(String usrEmail) {
        User user = null;
        Statement stmt;
        String query = "SELECT * FROM User WHERE email = " + usrEmail;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Integer id = rs.getInt("usrId");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            Boolean enabled = (rs.getInt("enabled") == 0) ? false : true;
            String role = rs.getString("role");
            user = new User(id, email, password,
                    firstName, lastName, enabled, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void activate(Integer id) {
        Statement stmt;
        String query = "UPDATE User SET enabled = 1 WHERE usrId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deactivate(Integer id) {
        Statement stmt;
        String query = "UPDATE User SET enabled = 0 WHERE usrId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Boolean enabled = user.getEnabled();
        String role = user.getRole();
        Statement stmt;
        String query = "INSERT INTO User (email, password, firstName, lastName, enabled, role)  VALUES ('"
                + email + "', '" + password + "', '" + firstName + "', '" +
                lastName + "', " + ((enabled) ? 1 : 0) + ", '" + role + "')";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        Integer usrId = user.getId();
        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Boolean enabled = user.getEnabled();
        String role = user.getRole();
        Statement stmt;
        String query = "UPDATE User SET " +
                "email = '" + email + "', " +
                "password = '" + password + "', " +
                "firstName = '" + firstName + "', " +
                "lastName = '" + lastName + "', " +
                "enabled = " + ((enabled) ? 1 : 0) + ", " +
                "role = '" + role + "' " +
                "WHERE usrId = " + usrId;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer usrId) {
        Statement stmt;
        String query = "DELETE FROM User WHERE usrId = " + usrId;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
