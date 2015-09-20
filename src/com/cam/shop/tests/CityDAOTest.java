package com.cam.shop.tests;

import com.cam.shop.dao.CityDAO;
import com.cam.shop.entity.City;

import java.util.List;

/**
 * Created by cam on 15.07.15.
 */
public class CityDAOTest {
    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAO();
        City lviv = new City("Lviv");
        City kolomyia = new City("Kolomyia");

        System.out.println("insert");
        cityDAO.insert(lviv);
        cityDAO.insert(kolomyia);
        List<City> list = cityDAO.getAllCities();
        for (City city : list) {
            System.out.println(city.toString());
        }

        System.out.println("find 2");
        System.out.println(cityDAO.getCityById(2).toString());

        System.out.println("find cities with 'i'");
        list = cityDAO.findCitiesByName("i");
        for (City city : list) {
            System.out.println(city.toString());
        }

        System.out.println("update 'lviv' to 'lvov'");
        cityDAO.update(new City(cityDAO.getCityByName("Lviv").getId(),"Lvov"));
        list = cityDAO.getAllCities();
        for (City city : list) {
            System.out.println(city.toString());
        }

        System.out.println("delete 'Kolomyia'");
        cityDAO.delete(cityDAO.findCitiesByName("Kolomyia").get(0).getId());
        list = cityDAO.getAllCities();
        for (City city : list) {
            System.out.println(city.toString());
        }
    }
}
