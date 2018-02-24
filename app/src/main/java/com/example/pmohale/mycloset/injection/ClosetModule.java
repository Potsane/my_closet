package com.example.pmohale.mycloset.injection;

import android.arch.persistence.room.Room;

import com.example.pmohale.mycloset.App;
import com.example.pmohale.mycloset.database.ClosetDatabase;
import com.example.pmohale.mycloset.database.dao.WardrobeItemDao;
import com.example.pmohale.mycloset.repo.WardrobeItemRepositoryImpl;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;

/**
 * Created by PMohale on 2018/02/24.
 */

@Module(includes = {AndroidInjectionModule.class, ViewModelModule.class})
public class ClosetModule {

    @Provides
    WardrobeItemRepository providesWardrobeItemRepository(WardrobeItemDao wardrobeItemDao) {
        return new WardrobeItemRepositoryImpl(wardrobeItemDao);
    }

    @Provides
    @Singleton
    WardrobeItemDao providesWardrobeItemDao(ClosetDatabase closetDatabase) {
        return closetDatabase.wardrobeItemDao();
    }

    @Provides
    @Singleton
    ClosetDatabase providesClosetDatabase(App context) {
        return Room.databaseBuilder(context.getApplicationContext(), ClosetDatabase.class, "closet").build();
    }
}
