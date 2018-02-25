package com.example.pmohale.mycloset.view.wardrobeitem.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import javax.inject.Inject;

/**
 * Created by PMohale on 2018/02/12.
 */

public class WardrobeItemDetailsViewModel extends ViewModel {

    @Inject WardrobeItemRepository itemRepository;

    @Inject
    public WardrobeItemDetailsViewModel() {
    }

    public LiveData<WardrobeItem> getWardrobeItem(long id) {
        return itemRepository.getWardrobeItem(id);
    }

    public void deleteWardrobeItem(long id) {
        itemRepository.deleteWardrobeItem(id);
    }
}
