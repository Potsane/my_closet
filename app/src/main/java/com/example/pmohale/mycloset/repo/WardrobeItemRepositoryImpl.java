package com.example.pmohale.mycloset.repo;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.task.wardrobeitem.DeleteWardrobeItemAsyncTask;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by PMohale on 2018/02/07.
 */

public class WardrobeItemRepositoryImpl implements WardrobeItemRepository {

    @Inject
    WardrobeItemDao wardrobeItemDao;

    public WardrobeItemRepositoryImpl(WardrobeItemDao wardrobeItemDao) {
        this.wardrobeItemDao = wardrobeItemDao;
    }

    @Override
    public LiveData<List<WardrobeItem>> getAllWardrobeItems() {
        return wardrobeItemDao.getAllItems();
    }

    @Override
    public Completable addWardrobeItem(WardrobeItem item) {
        if (item == null){
            return Completable.error(new IllegalArgumentException("Wardrobe intem cannot be null"));
        }
        return Completable.fromAction(() -> wardrobeItemDao.addItem(item));
    }

    @Override
    public LiveData<WardrobeItem> getWardrobeItem(long id) {
        return wardrobeItemDao.getWardrobeItem(id);
    }

    @Override
    public void deleteWardrobeItem(long id) {
        new DeleteWardrobeItemAsyncTask(wardrobeItemDao, id).execute();
    }

    @Override
    public LiveData<List<WardrobeItem>> getItemsByDressCode(String dressCode) {
        return wardrobeItemDao.getItemsByDressCode(dressCode);
    }
}
