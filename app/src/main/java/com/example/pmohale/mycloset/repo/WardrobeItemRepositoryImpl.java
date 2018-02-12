package com.example.pmohale.mycloset.repo;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.task.wardrobeitem.AddWardrobeItemAsyncTask;
import com.example.pmohale.mycloset.task.wardrobeitem.DeleteWardrobeItemAsyncTask;

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
    public LiveData<List<WardrobeItem>> getAllWardrobeItems() {
        return wardrobeItemDao.getAllItems();
    }

    @Override
    public void addWardrobeItem(WardrobeItem item) {
        new AddWardrobeItemAsyncTask(wardrobeItemDao, item).execute();
    }

    @Override
    public LiveData<WardrobeItem> getWardrobeItem(long id) {
        return wardrobeItemDao.getWardrobeItem(id);
    }

    @Override
    public void deleteWardrobeItem(long id) {
        new DeleteWardrobeItemAsyncTask(wardrobeItemDao, id).execute();
    }
}
