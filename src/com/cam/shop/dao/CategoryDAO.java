package com.cam.shop.dao;

import com.cam.shop.config.DBConfig;
import com.cam.shop.entity.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cam on 14.07.15.
 */
public class CategoryDAO implements ICategoryDAO {

    @Override
    public List<Category> getAllCategories() {
        List<Category> allCategories = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Category";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("catId");
                String name = rs.getString("catName");
                Category category = new Category(id, name);
                allCategories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCategories;
    }

    @Override
    public List<Category> findCategoriesByName(String name) {
        List<Category> allCategories = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Category WHERE catName LIKE '%" + name.trim() + "%'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("catId");
                String catName = rs.getString("catName");
                Category category = new Category(id, catName);
                allCategories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCategories;
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = null;
        Statement stmt;
        String query = "SELECT * FROM Category WHERE catId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer catId = rs.getInt("catId");
                String catName = rs.getString("catName");
                category = new Category(catId, catName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        Category category = null;
        Statement stmt;
        String query = "SELECT * FROM Category WHERE catName = '" + name + "'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer catId = rs.getInt("catId");
                String catName = rs.getString("catName");
                category = new Category(catId, catName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void insert(Category category) {
        Statement stmt;
        String query = "INSERT INTO Category (catName) VALUES ('" + category.getName() + "')";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        Statement stmt;
        String query = "UPDATE Category"
                + " SET catId = " + category.getId()
                + ", catName = '" + category.getName() + "'"
                + " WHERE catId = " + category.getId();
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        Statement stmt;
        String query = "DELETE FROM Category WHERE catId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
