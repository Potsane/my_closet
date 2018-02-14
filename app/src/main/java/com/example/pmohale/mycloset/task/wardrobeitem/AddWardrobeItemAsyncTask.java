package com.example.pmohale.mycloset.task.wardrobeitem;

import android.os.AsyncTask;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.entity.WardrobeItem;

/**
 * Created by PMohale on 2018/02/07.
 */

public class AddWardrobeItemAsyncTask extends AsyncTask<Void, Void, Void>{

    private WardrobeItemDao wardrobeItemDao;

    private WardrobeItem wardrobeItem;

    public  AddWardrobeItemAsyncTask(WardrobeItemDao wardrobeItemDao, WardrobeItem wardrobeItem) {
        this.wardrobeItemDao = wardrobeItemDao;
        this.wardrobeItem = wardrobeItem;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        wardrobeItemDao.addItem(wardrobeItem);
        return null;
    }

}
