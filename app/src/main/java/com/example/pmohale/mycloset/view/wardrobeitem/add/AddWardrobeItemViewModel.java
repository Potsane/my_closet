package com.example.pmohale.mycloset.view.wardrobeitem.add;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.util.InjectorUtils;

/**
 * Created by PMohale on 2018/02/12.
 */

public class AddWardrobeItemViewModel extends AndroidViewModel {

    private WardrobeItemRepository itemRepository;

    public AddWardrobeItemViewModel(Application application) {
        super(application);
        itemRepository = InjectorUtils.getWardrobeItemRepository(application);
    }

    public void addWardrobeItem(String type, String description, String color, String suitableDressCode, String suitableWeatherCondition) {
        WardrobeItem item = new WardrobeItem(description, type, color, suitableDressCode, suitableWeatherCondition);
        itemRepository.addWardrobeItem(item);
    }

}
