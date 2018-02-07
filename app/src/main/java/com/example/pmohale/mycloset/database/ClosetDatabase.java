package com.example.pmohale.mycloset.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pmohale.mycloset.database.dao.OutfitDao;
import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.database.dao.WeatherDao;
import com.example.pmohale.mycloset.entity.WeatherObject;

/**
 * Created by PMohale on 2018/02/05.
 */

@Database(entities = {WeatherObject.class}, version = 1)
public abstract class ClosetDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "closet";

    private static final Object LOCK = new Object();

    private static ClosetDatabase instance;

    //alt -  can make the method synchronized ie public static synchronized
    public static ClosetDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(context.getApplicationContext(), ClosetDatabase.class, ClosetDatabase.DATABASE_NAME).build();
            }
        }
        return instance;
    }

    public abstract OutfitDao outfitDao();

    public abstract WardrobeItemDao wardrobeItemDao();

    public abstract WeatherDao weatherDao();
}