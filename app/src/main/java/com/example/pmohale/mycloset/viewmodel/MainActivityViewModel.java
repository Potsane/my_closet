package com.example.pmohale.mycloset.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.pmohale.mycloset.entity.WeatherObject;
import com.example.pmohale.mycloset.repo.ClosetRepository;

/**
 * Created by PMohale on 2018/02/06.
 */

public class MainActivityViewModel extends ViewModel {

    private final ClosetRepository repository;

    private final LiveData<WeatherObject> weather;

    public MainActivityViewModel(ClosetRepository closetRepository) {
        repository = closetRepository;
        weather = closetRepository.getWeather();
    }

    public LiveData<WeatherObject> getWeather() {
        return weather;
    }
}
