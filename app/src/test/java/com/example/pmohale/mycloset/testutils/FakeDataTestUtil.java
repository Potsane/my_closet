package com.example.pmohale.mycloset.testutils;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PMohale on 2018/02/26.
 */

public class FakeDataTestUtil {

    @NonNull
    public static MutableLiveData<List<WardrobeItem>> getWardrobeItemsListMutableLiveData() {
        List<WardrobeItem> wardrobeItems = new ArrayList<>();
        WardrobeItem wardrobeItem = getFakeWardrobeItem();
        wardrobeItems.add(wardrobeItem);

        MutableLiveData<List<WardrobeItem>> fakeWardrobeItems = new MutableLiveData<>();
        fakeWardrobeItems.setValue(wardrobeItems);
        return fakeWardrobeItems;
    }

    @NonNull
    public static MutableLiveData<WardrobeItem> getWardrobeItemMutableLiveData() {
        WardrobeItem wardrobeItem = getFakeWardrobeItem();
        MutableLiveData<WardrobeItem> fakeWardrobeItem = new MutableLiveData<>();
        fakeWardrobeItem.setValue(wardrobeItem);

        return fakeWardrobeItem;
    }

    public static WardrobeItem getFakeWardrobeItem() {
        return new WardrobeItem("description", "type", "color", "dress code", "weather ");
    }
}
