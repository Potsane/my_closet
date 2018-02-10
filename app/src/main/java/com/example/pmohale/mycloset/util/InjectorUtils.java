package com.example.pmohale.mycloset.util;

import android.content.Context;

import com.example.pmohale.mycloset.database.ClosetDatabase;
import com.example.pmohale.mycloset.repo.OutfitRepositoryImpl;
import com.example.pmohale.mycloset.repo.WardrobeItemRepositoryImpl;
import com.example.pmohale.mycloset.repo.WeatherItemRepositoryImpl;
import com.example.pmohale.mycloset.repo.internal.OutfitRepository;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.repo.internal.WeatherItemRepository;

/**
 * Created by PMohale on 2018/02/07.
 */

public class InjectorUtils {

    private static OutfitRepository outfitRepository = null;

    private static WardrobeItemRepository wardrobeItemRepository = null;

    private static WeatherItemRepository weatherItemRepository = null;

    //TODO: refactor this methods
    public static OutfitRepository getOutfitRepository(final Context context) {
        if(outfitRepository == null){
            synchronized (OutfitRepository.class){
                if(outfitRepository == null){
                    outfitRepository = new OutfitRepositoryImpl(ClosetDatabase.getInstance(context).outfitDao());
                }
            }
        }
        return outfitRepository;
    }

    public static WardrobeItemRepository getWardrobeItemRepository(final Context context) {
        if(wardrobeItemRepository == null){
            synchronized (WardrobeItemRepository.class){
                if(wardrobeItemRepository == null){
                    wardrobeItemRepository = new WardrobeItemRepositoryImpl(ClosetDatabase.getInstance(context).wardrobeItemDao());
                }
            }
        }
        return wardrobeItemRepository;
    }

    public static WeatherItemRepository getWeatherItemRepository(final Context context) {
        if(weatherItemRepository == null){
            synchronized (OutfitRepository.class){
                if(weatherItemRepository == null){
                    weatherItemRepository = new WeatherItemRepositoryImpl(ClosetDatabase.getInstance(context).weatherDao());
                }
            }
        }
        return weatherItemRepository;
    }

}
