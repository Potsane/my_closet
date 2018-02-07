package com.example.pmohale.mycloset.entity;

import android.arch.persistence.room.Entity;

import com.example.pmohale.mycloset.entity.internal.PersistableEntity;

import java.util.Date;

/**
 * Created by PMohale on 2018/02/05.
 */

@Entity(tableName = "wardrobe_items")
public class WardrobeItem extends PersistableEntity {

    private String description;

    private String type;

    private String color;

    private String size;

    private String brand;

    private String suitableDressCode;

    private String suitableWeatherCondition;

    private Date dateAcquired;

    private Date dateAddedToCloset;

    public WardrobeItem(String description, String type, String color, String size, String brand, String suitableDressCode, String suitableWeatherCondition, Date dateAcquired, Date dateAddedToCloset) {
        this.description = description;
        this.type = type;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.suitableDressCode = suitableDressCode;
        this.suitableWeatherCondition = suitableWeatherCondition;
        this.dateAcquired = dateAcquired;
        this.dateAddedToCloset = dateAddedToCloset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSuitableDressCode() {
        return suitableDressCode;
    }

    public void setSuitableDressCode(String suitableDressCode) {
        this.suitableDressCode = suitableDressCode;
    }

    public String getSuitableWeatherCondition() {
        return suitableWeatherCondition;
    }

    public void setSuitableWeatherCondition(String suitableWeatherCondition) {
        this.suitableWeatherCondition = suitableWeatherCondition;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public Date getDateAddedToCloset() {
        return dateAddedToCloset;
    }

    public void setDateAddedToCloset(Date dateAddedToCloset) {
        this.dateAddedToCloset = dateAddedToCloset;
    }
}
