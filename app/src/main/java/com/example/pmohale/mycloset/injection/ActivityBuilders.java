package com.example.pmohale.mycloset.injection;

import com.example.pmohale.mycloset.view.wardrobeitem.add.AddWardrobeItemActivity;
import com.example.pmohale.mycloset.view.wardrobeitem.detail.WardrobeItemDetailsActivity;
import com.example.pmohale.mycloset.view.wardrobeitem.list.MainActivity;
import com.example.pmohale.mycloset.view.wardrobeitem.list.WardrobeItemsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by PMohale on 2018/02/24.
 */

@Module
public abstract class ActivityBuilders {

    @ContributesAndroidInjector
    abstract AddWardrobeItemActivity bindAddWardrobeItemActivity();

    @ContributesAndroidInjector
    abstract WardrobeItemDetailsActivity bindWardrobeItemDetailsActivity();

    @ContributesAndroidInjector
    abstract WardrobeItemsListActivity bindWardrobeItemsListActivity();

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
