package com.example.pmohale.mycloset.repo;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.service.AddWardrobeItemAsyncTask;

import java.util.List;

/**
 * Created by PMohale on 2018/02/07.
 */

public class WardrobeItemRepositoryImpl implements WardrobeItemRepository {

    private WardrobeItemDao wardrobeItemDao;

    public WardrobeItemRepositoryImpl(WardrobeItemDao wardrobeItemDao) {
        this.wardrobeItemDao = wardrobeItemDao;
    }

    @Override
    public LiveData<List<WardrobeItem>> getAllOutfits() {
        return wardrobeItemDao.getAllItems();
    }

    @Override
    public void addWardrobeItem(WardrobeItem item) {
        new AddWardrobeItemAsyncTask(wardrobeItemDao, item);
    }
}
