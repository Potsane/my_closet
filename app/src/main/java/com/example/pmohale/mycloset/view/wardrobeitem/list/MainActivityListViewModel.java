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

public class MainActivityListViewModel extends ViewModel {

    @Inject
    WardrobeItemRepository itemRepository;

    @Inject
    public MainActivityListViewModel() {
    }

    public LiveData<List<WardrobeItem>> getItemsByDressCode(String dressCode) {
        return itemRepository.getItemsByDressCode(dressCode);
    }
}
