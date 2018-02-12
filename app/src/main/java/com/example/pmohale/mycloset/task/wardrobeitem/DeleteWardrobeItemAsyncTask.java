package com.example.pmohale.mycloset.task.wardrobeitem;

import android.os.AsyncTask;

import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;

/**
 * Created by PMohale on 2018/02/12.
 */

public class DeleteWardrobeItemAsyncTask extends AsyncTask<Void, Void, Void> {

    private WardrobeItemDao wardrobeItemDao;

    private long id;

    public DeleteWardrobeItemAsyncTask(WardrobeItemDao wardrobeItemDao, long id) {
        this.wardrobeItemDao = wardrobeItemDao;
        this.id = id;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        wardrobeItemDao.deleteWardrobeItem(id);
        return null;
    }
}
