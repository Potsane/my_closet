package com.example.pmohale.mycloset.repo.internal;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.entity.Outfit;

import java.util.List;

/**
 * Created by PMohale on 2018/02/06.
 */

public interface OutfitRepository {

    LiveData<List<Outfit>> getAllOutfits();

    void addOutfit(Outfit outfit);
}
