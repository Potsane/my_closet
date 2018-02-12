/*
package com.example.pmohale.mycloset.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;
import com.example.pmohale.mycloset.util.InjectorUtils;

import java.util.List;

*/
/**
 * Created by PMohale on 2018/02/10.
 *//*


public class WardrobeItemViewModel extends AndroidViewModel{

    private WardrobeItemRepository itemRepository;


    public WardrobeItemViewModel(Application application) {
        super(application);
        itemRepository = InjectorUtils.getWardrobeItemRepository(application);
    }

    public void addWardrobeItem(String type, String description, String color, String suitableDressCode, String suitableWeatherCondition){
        WardrobeItem item = new WardrobeItem(description,type,color,suitableDressCode,suitableWeatherCondition);
        itemRepository.addWardrobeItem(item);
    }

    public LiveData<List<WardrobeItem>> getAllWardrobeItems(){
        return itemRepository.getAllWardrobeItems();
    }

    public LiveData<WardrobeItem> getWardrobeItem(long id){
        return itemRepository.getWardrobeItem(id);
    }

    public void deleteItem(){

    }


}
*/
