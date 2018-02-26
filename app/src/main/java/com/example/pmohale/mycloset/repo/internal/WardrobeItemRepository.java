package com.example.pmohale.mycloset.repo.internal;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by PMohale on 2018/02/07.
 */

public interface WardrobeItemRepository {

    LiveData<List<WardrobeItem>> getAllWardrobeItems();

    Completable addWardrobeItem(WardrobeItem item);

    LiveData<WardrobeItem> getWardrobeItem(long id);

    Completable deleteWardrobeItem(long id);

    LiveData<List<WardrobeItem>> getItemsByDressCode(String dressCode);
}
