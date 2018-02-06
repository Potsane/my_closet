package com.example.pmohale.mycloset.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.pmohale.mycloset.entity.Outfit;

/**
 * Created by PMohale on 2018/02/05.
 */

@Dao
public interface OutfitDao {

    @Insert
    void insert(Outfit outfit);

}
