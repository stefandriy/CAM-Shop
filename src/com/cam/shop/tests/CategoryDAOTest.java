package com.cam.shop.tests;

import com.cam.shop.dao.CategoryDAO;
import com.cam.shop.entity.Category;

import java.util.List;

/**
 * Created by cam on 14.07.15.
 */
public class CategoryDAOTest {
    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category mobile = new Category("Mobile");
        Category vehicle = new Category("Vehicle");

        System.out.println("insert");
        categoryDAO.insert(mobile);
        categoryDAO.insert(vehicle);
        List<Category> list1 = categoryDAO.getAllCategories();
        for (Category cat : list1) {
            System.out.println(cat.getId() + " : " + cat.getName());
        }

        System.out.println("find by name 'Mo'");
        List<Category> list2 = categoryDAO.findCategoriesByName("Mo");
        for (Category cat : list2) {
            System.out.println(cat.getId() + " : " + cat.getName());
        }

        System.out.println("find by id 2");
        Category category1 = categoryDAO.getCategoryById(2);
        System.out.println(category1.getId() + " : " + category1.getName());

        System.out.println("insert");
        categoryDAO.insert(new Category("Moto"));
        list1 = categoryDAO.getAllCategories();
        for (Category cat : list1) {
            System.out.println(cat.getId() + " : " + cat.getName());
        }

        System.out.println("update");
        categoryDAO.update(new Category(categoryDAO.getCategoryByName("Moto").getId(),"Bike"));
        list1 = categoryDAO.getAllCategories();
        for (Category cat : list1) {
            System.out.println(cat.getId() + " : " + cat.getName());
        }

        System.out.println("delete");
        categoryDAO.delete(1);
        list1 = categoryDAO.getAllCategories();
        for (Category cat : list1) {
            System.out.println(cat.getId() + " : " + cat.getName());
        }

    }
}
