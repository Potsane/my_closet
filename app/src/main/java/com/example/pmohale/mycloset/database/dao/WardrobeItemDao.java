package com.example.pmohale.mycloset.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.List;

/**
 * Created by PMohale on 2018/02/05.
 */
@Dao
public interface WardrobeItemDao {

    @Insert
    void addItem(WardrobeItem item);

    @Query("SELECT * FROM wardrobe_items")
    LiveData<List<WardrobeItem>> getAllItems();

    @Query("SELECT * FROM wardrobe_items WHERE id = :id")
    LiveData<WardrobeItem> getWardrobeItem(long id);

    @Query("DELETE FROM wardrobe_items WHERE id = :id")
    void deleteWardrobeItem(long id);
}
