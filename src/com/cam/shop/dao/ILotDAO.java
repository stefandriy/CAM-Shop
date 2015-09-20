package com.cam.shop.dao;

import com.cam.shop.entity.Category;
import com.cam.shop.entity.City;
import com.cam.shop.entity.Lot;
import com.cam.shop.entity.User;

import java.util.List;

/**
 * Created by cam on 14.07.15.
 */
public interface ILotDAO {

    List<Lot> getAllLots();
    List<Lot> getAllAvailableLots();
    List<Lot> getLotsByCategory(Integer id);
    List<Lot> getLotsByCity(Integer id);
    List<Lot> getLotsByUser(Integer id);
    List<Lot> findLotsByKeyword(String keyword);
    Lot getLotById(Integer id);
    void insert(Lot lot);
    void update(Lot lot);
    void delete (Integer id);
}
