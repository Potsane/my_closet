package com.example.pmohale.mycloset.view.wardrobeitem.list;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.util.InjectorUtils;

import java.util.List;

/**
 * Created by PMohale on 2018/02/12.
 */

public class MainActivityListViewModel extends AndroidViewModel {

    private WardrobeItemRepository itemRepository;

    public MainActivityListViewModel(Application application) {
        super(application);
        itemRepository = InjectorUtils.getWardrobeItemRepository(application);
    }
    public LiveData<List<WardrobeItem>> getItemsByDressCode(String dressCode){
        return itemRepository.getItemsByDressCode(dressCode);
    }
}