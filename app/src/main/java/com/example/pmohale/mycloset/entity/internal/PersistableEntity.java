package com.example.pmohale.mycloset.entity.internal;

import android.arch.persistence.room.PrimaryKey;


public abstract class PersistableEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
