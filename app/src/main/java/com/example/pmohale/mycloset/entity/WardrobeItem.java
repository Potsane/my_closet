package com.example.pmohale.mycloset.entity;

import android.arch.persistence.room.Entity;

import com.example.pmohale.mycloset.entity.internal.PersistableEntity;

@Entity(tableName = "wardrobe_items")
public class WardrobeItem extends PersistableEntity {

    private String description;

    private String type;

    private String color;

    private String suitableDressCode;

    private String suitableWeatherCondition;


    public WardrobeItem(String description, String type, String color, String suitableDressCode, String suitableWeatherCondition) {
        this.description = description;
        this.type = type;
        this.color = color;
        this.suitableDressCode = suitableDressCode;
        this.suitableWeatherCondition = suitableWeatherCondition;
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


}
