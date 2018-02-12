package com.example.pmohale.mycloset.task;

import android.os.AsyncTask;

import com.example.pmohale.mycloset.database.dao.WeatherDao;
import com.example.pmohale.mycloset.entity.WeatherObject;

/**
 * Created by PMohale on 2018/02/07.
 */

public class AddWeatherItemAsyncTask extends AsyncTask<Void, Void, Void> {

    private WeatherDao weatherDao;

    private WeatherObject weatherObject;

    public AddWeatherItemAsyncTask(WeatherDao weatherDao, WeatherObject weatherObject) {
        this.weatherDao = weatherDao;
        this.weatherObject = weatherObject;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        weatherDao.addWeatherObject(weatherObject);
        return null;
    }
}
