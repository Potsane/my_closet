package com.example.pmohale.mycloset.repo;

import com.example.pmohale.mycloset.database.dao.WeatherDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WeatherItemRepository;

/**
 * Created by PMohale on 2018/02/07.
 */

public class WeatherItemRepositoryImpl implements WeatherItemRepository {

    private WeatherDao weatherDao;

    public WeatherItemRepositoryImpl(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    @Override
    public void addWeatherItem(WardrobeItem item) {

    }
}
