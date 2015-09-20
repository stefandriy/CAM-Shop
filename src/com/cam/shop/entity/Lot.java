package com.cam.shop.entity;

import java.net.URL;

/**
 * Created by cam on 14.07.15.
 */
public class Lot {
    private Integer lotId;
    private String lotName;
    private String description;
    private Integer catId;
    private Integer usrId;
    private Integer cityId;
    private URL picture;
    private Boolean available;

    public Lot() {
    }

    public Lot(Integer lotId, String lotName, String description,
               Integer catId, Integer usrId, Integer cityId,
               URL picture, Boolean available) {
        this.lotId = lotId;
        this.lotName = lotName;
        this.description = description;
        this.catId = catId;
        this.usrId = usrId;
        this.cityId = cityId;
        this.picture = picture;
        this.available = available;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
