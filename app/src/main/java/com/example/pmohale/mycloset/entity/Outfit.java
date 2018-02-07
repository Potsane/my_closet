package com.example.pmohale.mycloset.entity;

import android.arch.persistence.room.Entity;

import com.example.pmohale.mycloset.entity.internal.PersistableEntity;

import java.util.List;

/**
 * Created by PMohale on 2018/02/05.
 */

@Entity
public class Outfit extends PersistableEntity {

    private List<WardrobeItem> items;


}
