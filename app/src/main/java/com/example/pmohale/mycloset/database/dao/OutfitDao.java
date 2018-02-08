package com.example.pmohale.mycloset.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pmohale.mycloset.entity.Outfit;

import java.util.List;

/**
 * Created by PMohale on 2018/02/05.
 */

@Dao
public interface OutfitDao {

    @Insert
    void add(Outfit outfit);

    @Query("SELECT * FROM outfits")
    LiveData<List<Outfit>> getAllOutfits();
}
