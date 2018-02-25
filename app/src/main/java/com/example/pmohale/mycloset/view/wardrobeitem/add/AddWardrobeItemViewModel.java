package com.example.pmohale.mycloset.view.wardrobeitem.add;

import android.arch.lifecycle.ViewModel;

import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.repo.internal.WardrobeItemRepository;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PMohale on 2018/02/12.
 */

public class AddWardrobeItemViewModel extends ViewModel {

    @Inject
    WardrobeItemRepository itemRepository;

    @Inject
    public AddWardrobeItemViewModel() {
    }

    public void addWardrobeItem(String type, String description, String color, String suitableDressCode, String suitableWeatherCondition) {
        WardrobeItem item = new WardrobeItem(description, type, color, suitableDressCode, suitableWeatherCondition);
        itemRepository.addWardrobeItem(item).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
