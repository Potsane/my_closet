package com.example.pmohale.mycloset.database.internal;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.pmohale.mycloset.entity.WardrobeItem;

/**
 * Created by PMohale on 2018/02/05.
 */
@Dao
public interface WardrobeItemDao {

    @Insert
    void insertItem(WardrobeItem item);
}
