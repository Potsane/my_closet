package com.example.pmohale.mycloset.view.wardrobeitem.add;

import android.arch.lifecycle.ViewModel;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import javax.inject.Inject;

/**
 * Created by PMohale on 2018/02/12.
 */

public class AddWardrobeItemViewModel extends ViewModel {

    @Inject
    WardrobeItemRepository itemRepository;

    @Inject
    public AddWardrobeItemViewModel() {
    }

    public void addWardrobeItem(String type, String description, String color, String suitableDressCode, String suitableWeatherCondition) {
        WardrobeItem item = new WardrobeItem(description, type, color, suitableDressCode, suitableWeatherCondition);
        itemRepository.addWardrobeItem(item);
    }

}
