package com.example.pmohale.mycloset.view.wardrobeitem.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by PMohale on 2018/02/12.
 */

public class WardrobeItemsListViewModel extends ViewModel {

    @Inject
    WardrobeItemRepository itemRepository;

    @Inject
    public WardrobeItemsListViewModel() {
    }

    public LiveData<List<WardrobeItem>> getAllWardrobeItems() {
        return itemRepository.getAllWardrobeItems();
    }
}
