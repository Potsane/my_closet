package com.example.pmohale.mycloset.util;

import android.content.Context;

import com.example.pmohale.mycloset.database.ClosetDatabase;
import com.example.pmohale.mycloset.repo.OutfitRepositoryImpl;
import com.example.pmohale.mycloset.repo.WardrobeItemRepositoryImpl;
import com.example.pmohale.mycloset.repo.internal.OutfitRepository;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

/**
 * Created by PMohale on 2018/02/07.
 */

public class InjectorUtils {

    private static OutfitRepository outfitRepository = null;

    private static WardrobeItemRepository wardrobeItemRepository = null;

    //TODO: refactor this methods
    public static OutfitRepository getOutfitRepository(final Context context) {
        if(outfitRepository == null){
            synchronized (OutfitRepository.class){
                if(outfitRepository == null){
                    outfitRepository = new OutfitRepositoryImpl(ClosetDatabase.getInstance(context).outfitDao());
                }
            }
        }
        return outfitRepository;
    }

    public static WardrobeItemRepository getWardrobeItemRepository(final Context context) {
        if(wardrobeItemRepository == null){
            synchronized (WardrobeItemRepository.class){
                if(wardrobeItemRepository == null){
                    wardrobeItemRepository = new WardrobeItemRepositoryImpl(ClosetDatabase.getInstance(context).wardrobeItemDao());
                }
            }
        }
        return wardrobeItemRepository;
    }

}
