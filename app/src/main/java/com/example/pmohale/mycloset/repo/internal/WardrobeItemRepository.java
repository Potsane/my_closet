package com.example.pmohale.mycloset.repo.internal;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.List;

/**
 * Created by PMohale on 2018/02/07.
 */

public interface WardrobeItemRepository {

    LiveData<List<WardrobeItem>> getAllWardrobeItems();

    void addWardrobeItem(WardrobeItem item);
}
