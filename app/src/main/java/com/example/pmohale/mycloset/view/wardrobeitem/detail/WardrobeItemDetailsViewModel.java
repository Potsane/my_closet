package com.example.pmohale.mycloset.view.wardrobeitem.detail;

import android.arch.lifecycle.LiveData;
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

public class WardrobeItemDetailsViewModel extends ViewModel {

    @Inject
    WardrobeItemRepository itemRepository;

    @Inject
    public WardrobeItemDetailsViewModel() {
    }

    public LiveData<WardrobeItem> getWardrobeItem(long id) {
        return itemRepository.getWardrobeItem(id);
    }

    public void deleteWardrobeItem(long id) {
        itemRepository.deleteWardrobeItem(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
