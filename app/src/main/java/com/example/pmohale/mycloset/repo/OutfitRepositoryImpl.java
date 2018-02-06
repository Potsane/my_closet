package com.example.pmohale.mycloset.repo;

import android.arch.lifecycle.LiveData;

import com.example.pmohale.mycloset.database.dao.OutfitDao;
import com.example.pmohale.mycloset.entity.Outfit;
import com.example.pmohale.mycloset.repo.internal.OutfitRepository;

import java.util.List;

/**
 * Created by PMohale on 2018/02/06.
 */

public class OutfitRepositoryImpl implements OutfitRepository{

    private OutfitDao outfitDao;

    public OutfitRepositoryImpl(OutfitDao outfitDao) {
        this.outfitDao = outfitDao;
    }


    @Override
    public LiveData<List<Outfit>> getAllOutfits() {
        //return outfitDao.getAllOutfits();
        return  null;
    }

    @Override
    public void addOutfit(Outfit outfit) {

    }
}
