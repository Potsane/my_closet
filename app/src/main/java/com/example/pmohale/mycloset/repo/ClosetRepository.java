package com.example.pmohale.mycloset.repo;

import com.example.pmohale.mycloset.database.dao.WeatherDao;

/**
 * Created by PMohale on 2018/02/06.
 */

public class ClosetRepository {

    private final WeatherDao weatherDao;

    public ClosetRepository(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    /*public LiveData<WeatherObject> getWeather() {
        return weather;
    }*/
}
