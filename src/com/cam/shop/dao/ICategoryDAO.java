package com.cam.shop.dao;

import com.cam.shop.entity.Category;

import java.util.List;

/**
 * Created by cam on 14.07.15.
 */
public interface ICategoryDAO {
    List<Category> getAllCategories();
    List<Category> findCategoriesByName(String name);
    Category getCategoryById(Integer id);
    Category getCategoryByName(String name);
    void insert(Category category);
    void update(Category category);
    void delete (Integer id);
}
