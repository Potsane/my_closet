package com.example.pmohale.mycloset.repo;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

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
        return Completable.fromAction(() -> wardrobeItemDao.addItem(item));
    }

    @Override
    public LiveData<WardrobeItem> getWardrobeItem(long id) {
        return wardrobeItemDao.getWardrobeItem(id);
    }

    @Override
    public Completable deleteWardrobeItem(long id) {
        return Completable.fromAction(() -> wardrobeItemDao.deleteWardrobeItem(id));
    }

    @Override
    public LiveData<List<WardrobeItem>> getItemsByDressCode(String dressCode) {
        return wardrobeItemDao.getItemsByDressCode(dressCode);
    }
}
