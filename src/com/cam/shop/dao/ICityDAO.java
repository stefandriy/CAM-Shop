package com.cam.shop.dao;

import com.cam.shop.entity.City;

import java.util.List;

/**
 * Created by cam on 14.07.15.
 */
public interface ICityDAO {
    List<City> getAllCities();
    List<City> findCitiesByName(String name);
    City getCityById(Integer id);
    City getCityByName(String name);
    void insert(City city);
    void update(City city);
    void delete (Integer id);
}
