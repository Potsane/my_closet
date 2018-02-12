package com.example.pmohale.mycloset.task;

import android.os.AsyncTask;

import com.example.pmohale.mycloset.database.dao.OutfitDao;
import com.example.pmohale.mycloset.entity.Outfit;

/**
 * Created by PMohale on 2018/02/06.
 */

public class AddOutfitAsyncTask extends AsyncTask<Void,Void,Void>{

    private OutfitDao outfitDao;

    private Outfit outfit;

    public AddOutfitAsyncTask(OutfitDao outfitDao, Outfit outfit) {
        this.outfitDao = outfitDao;
        this.outfit = outfit;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        outfitDao.add(outfit);
        return null;
    }
}
