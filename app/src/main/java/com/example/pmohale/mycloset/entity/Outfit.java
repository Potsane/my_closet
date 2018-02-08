package com.example.pmohale.mycloset.entity;

import android.arch.persistence.room.Entity;

import com.example.pmohale.mycloset.entity.internal.PersistableEntity;

/**
 * Created by PMohale on 2018/02/05.
 */

@Entity(tableName = "outfits")
public class Outfit extends PersistableEntity {

    //private List<WardrobeItem> items;
    private String someDummyString;

    public String getSomeDummyString() {
        return someDummyString;
    }

    public void setSomeDummyString(String someDummyString) {
        this.someDummyString = someDummyString;
    }


}
