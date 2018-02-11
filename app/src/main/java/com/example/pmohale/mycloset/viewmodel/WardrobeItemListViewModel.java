package com.example.pmohale.mycloset.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.util.InjectorUtils;

import java.util.List;

/**
 * Created by PMohale on 2018/02/10.
 */

public class WardrobeItemListViewModel extends AndroidViewModel {

    private WardrobeItemRepository wardrobeItemRepository;

    public WardrobeItemListViewModel(Application application) {
        super(application);
        wardrobeItemRepository = InjectorUtils.getWardrobeItemRepository(application);
    }


    public LiveData<List<WardrobeItem>> getAllWardrobeItems(){
        return wardrobeItemRepository.getAllWardrobeItems();
    }
}
