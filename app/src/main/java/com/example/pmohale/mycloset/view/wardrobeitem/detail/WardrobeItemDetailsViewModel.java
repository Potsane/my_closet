package com.example.pmohale.mycloset.view.wardrobeitem.detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.util.InjectorUtils;

/**
 * Created by PMohale on 2018/02/12.
 */

public class WardrobeItemDetailsViewModel extends AndroidViewModel {

    private WardrobeItemRepository itemRepository;

    public WardrobeItemDetailsViewModel(Application application) {
        super(application);
        itemRepository = InjectorUtils.getWardrobeItemRepository(application);
    }

    public LiveData<WardrobeItem> getWardrobeItem(long id) {
        return itemRepository.getWardrobeItem(id);
    }
}
