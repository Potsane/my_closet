package com.example.pmohale.mycloset.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.pmohale.mycloset.database.dao.OutfitDao;
import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.Outfit;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.util.DateConverter;

/**
 * Created by PMohale on 2018/02/05.
 */

@Database(entities = {Outfit.class, WardrobeItem.class}, version = 5)
@TypeConverters(DateConverter.class)
public abstract class ClosetDatabase extends RoomDatabase {

    public abstract OutfitDao outfitDao();

    public abstract WardrobeItemDao wardrobeItemDao();

}
