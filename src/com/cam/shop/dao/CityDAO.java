package com.cam.shop.dao;

import com.cam.shop.config.DBConfig;
import com.cam.shop.entity.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cam on 15.07.15.
 */
public class CityDAO implements ICityDAO {
    @Override
    public List<City> getAllCities() {
        List<City> allCities = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM City";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("cityId");
                String name = rs.getString("cityName");
                City city = new City(id, name);
                allCities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCities;
    }

    @Override
    public List<City> findCitiesByName(String name) {
        List<City> allCities = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM City WHERE City.cityName LIKE '%" + name.trim() + "%'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("cityId");
                String cityName = rs.getString("cityName");
                City city = new City(id, cityName);
                allCities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCities;
    }

    @Override
    public City getCityById(Integer id) {
        City city = null;
        Statement stmt;
        String query = "SELECT * FROM City WHERE cityId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer cityId = rs.getInt("cityId");
                String cityName = rs.getString("cityName");
                city = new City(cityId, cityName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public City getCityByName(String name) {
        City city = null;
        Statement stmt;
        String query = "SELECT * FROM City WHERE cityName = '" + name + "'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer cityId = rs.getInt("cityId");
                String cityName = rs.getString("cityName");
                city = new City(cityId, cityName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void insert(City city) {
        Statement stmt;
        String query = "INSERT INTO City (cityName) VALUES ('" + city.getName() + "')";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(City city) {
        Statement stmt;
        String query = "UPDATE City"
                + " SET cityId = " + city.getId()
                + ", cityName = '" + city.getName() + "'"
                + " WHERE cityId = " + city.getId();
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
        String query = "DELETE FROM City WHERE cityId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
