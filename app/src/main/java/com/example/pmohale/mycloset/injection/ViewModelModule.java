package com.example.pmohale.mycloset.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.pmohale.mycloset.view.wardrobeitem.add.AddWardrobeItemViewModel;
import com.example.pmohale.mycloset.view.wardrobeitem.detail.WardrobeItemDetailsViewModel;
import com.example.pmohale.mycloset.view.wardrobeitem.list.MainActivityListViewModel;
import com.example.pmohale.mycloset.view.wardrobeitem.list.WardrobeItemsListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by PMohale on 2018/02/24.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddWardrobeItemViewModel.class)
    abstract ViewModel bindAddWardrobeItemViewModel(AddWardrobeItemViewModel addWardrobeItemViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WardrobeItemDetailsViewModel.class)
    abstract ViewModel bindWardrobeItemDetailsViewModel(WardrobeItemDetailsViewModel wardrobeItemDetailsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WardrobeItemsListViewModel.class)
    abstract ViewModel bindWardrobeItemsListViewModel(WardrobeItemsListViewModel wardrobeItemsListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityListViewModel.class)
    abstract ViewModel bindMainActivityListViewModel(MainActivityListViewModel mainActivityListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelProide(ClosetViewModelFactory closetViewModelFactory);
}
