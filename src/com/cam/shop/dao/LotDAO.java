package com.cam.shop.dao;

import com.cam.shop.config.DBConfig;
import com.cam.shop.entity.Lot;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cam on 16.07.15.
 */
public class LotDAO implements ILotDAO {
    @Override
    public List<Lot> getAllLots() {
        List<Lot> allLots = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Lot";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer lotId = rs.getInt("lotId");
                String lotName = rs.getString("lotName");
                String description = rs.getString("description");
                Integer catId = rs.getInt("catId");
                Integer usrId = rs.getInt("usrId");
                Integer cityId = rs.getInt("cityId");
                URL picture = new URL(rs.getString("picture"));
                Boolean available = (rs.getInt("available") != 0);
                Lot lot = new Lot(lotId, lotName, description,
                        catId, usrId, cityId, picture, available);
                allLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return allLots;
    }

    @Override
    public List<Lot> getAllAvailableLots() {
        List<Lot> allLots = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Lot WHERE available = 1";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer lotId = rs.getInt("lotId");
                String lotName = rs.getString("lotName");
                String description = rs.getString("description");
                Integer catId = rs.getInt("catId");
                Integer usrId = rs.getInt("usrId");
                Integer cityId = rs.getInt("cityId");
                URL picture = new URL(rs.getString("picture"));
                Boolean available = (rs.getInt("available") != 0);
                Lot lot = new Lot(lotId, lotName, description,
                        catId, usrId, cityId, picture, available);
                allLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return allLots;
    }

    @Override
    public List<Lot> getLotsByCategory(Integer id) {
        List<Lot> allLots = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Lot WHERE catId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer lotId = rs.getInt("lotId");
                String lotName = rs.getString("lotName");
                String description = rs.getString("description");
                Integer catId = rs.getInt("catId");
                Integer usrId = rs.getInt("usrId");
                Integer cityId = rs.getInt("cityId");
                URL picture = new URL(rs.getString("picture"));
                Boolean available = (rs.getInt("available") != 0);
                Lot lot = new Lot(lotId, lotName, description,
                        catId, usrId, cityId, picture, available);
                allLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return allLots;
    }

    @Override
    public List<Lot> getLotsByCity(Integer id) {
        List<Lot> allLots = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Lot WHERE cityId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer lotId = rs.getInt("lotId");
                String lotName = rs.getString("lotName");
                String description = rs.getString("description");
                Integer catId = rs.getInt("catId");
                Integer usrId = rs.getInt("usrId");
                Integer cityId = rs.getInt("cityId");
                URL picture = new URL(rs.getString("picture"));
                Boolean available = (rs.getInt("available") != 0);
                Lot lot = new Lot(lotId, lotName, description,
                        catId, usrId, cityId, picture, available);
                allLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return allLots;
    }

    @Override
    public List<Lot> getLotsByUser(Integer id) {
        List<Lot> allLots = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Lot WHERE usrId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer lotId = rs.getInt("lotId");
                String lotName = rs.getString("lotName");
                String description = rs.getString("description");
                Integer catId = rs.getInt("catId");
                Integer usrId = rs.getInt("usrId");
                Integer cityId = rs.getInt("cityId");
                URL picture = new URL(rs.getString("picture"));
                Boolean available = (rs.getInt("available") != 0);
                Lot lot = new Lot(lotId, lotName, description,
                        catId, usrId, cityId, picture, available);
                allLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return allLots;
    }

    @Override
    public List<Lot> findLotsByKeyword(String keyword) {
        List<Lot> allLots = new ArrayList<>();
        Statement stmt;
        String query = "SELECT * FROM Lot WHERE " +
                "lotName LIKE '%" + keyword.trim() + "%'";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer lotId = rs.getInt("lotId");
                String lotName = rs.getString("lotName");
                String description = rs.getString("description");
                Integer catId = rs.getInt("catId");
                Integer usrId = rs.getInt("usrId");
                Integer cityId = rs.getInt("cityId");
                URL picture = new URL(rs.getString("picture"));
                Boolean available = (rs.getInt("available") != 0);
                Lot lot = new Lot(lotId, lotName, description,
                        catId, usrId, cityId, picture, available);
                allLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return allLots;
    }

    @Override
    public Lot getLotById(Integer id) {
        Lot lot = null;
        Statement stmt;
        String query = "SELECT * FROM Lot WHERE lotId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Integer lotId = rs.getInt("lotId");
            String lotName = rs.getString("lotName");
            String description = rs.getString("description");
            Integer catId = rs.getInt("catId");
            Integer usrId = rs.getInt("usrId");
            Integer cityId = rs.getInt("cityId");
            URL picture = new URL(rs.getString("picture"));
            Boolean available = (rs.getInt("available") != 0);
            lot = new Lot(lotId, lotName, description,
                    catId, usrId, cityId, picture, available);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return lot;
    }

    @Override
    public void insert(Lot lot) {
        String lotName = lot.getLotName();
        String description = lot.getDescription();
        Integer catId = lot.getCatId();
        Integer usrId = lot.getUsrId();
        Integer cityId = lot.getCityId();
        URL picture = lot.getPicture();
        Boolean available = lot.getAvailable();
        Statement stmt;
        String query = "INSERT INTO Lot (lotName, description, catId, usrId, cityId, picture, available) VALUES ('"
                + lotName + "', '" + description + "', " + catId + ", " +
                usrId + ", " + cityId + ", '" + picture.toString() + "', " +((available) ? 1 : 0) + ")";
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Lot lot) {
        Integer lotId = lot.getLotId();
        String lotName = lot.getLotName();
        String description = lot.getDescription();
        Integer catId = lot.getCatId();
        Integer usrId = lot.getUsrId();
        Integer cityId = lot.getCityId();
        URL picture = lot.getPicture();
        Boolean available = lot.getAvailable();
        Statement stmt;
        String query = "UPDATE Lot SET "
                + "lotName = '" + lotName + "', "
                + "description = '" + description + "', "
                + "catId = " + catId + ", "
                + "usrId = " + usrId + ", "
                + "cityId = " + cityId + ", "
                + "picture = '" + picture.toString() + "', "
                + "available = " +((available) ? 1 : 0)
                + "WHERE lotId = " + lotId;
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
        String query = "DELETE FROM Lot WHERE lotId = " + id;
        try {
            Connection con = DBConfig.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
