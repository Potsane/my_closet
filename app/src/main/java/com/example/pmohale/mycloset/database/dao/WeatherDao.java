package com.example.pmohale.mycloset.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.pmohale.mycloset.entity.WeatherObject;

/**
 * Created by PMohale on 2018/02/05.
 */

@Dao
public interface WeatherDao {

    @Insert
    void addWeatherObject(WeatherObject weatherObject);
}