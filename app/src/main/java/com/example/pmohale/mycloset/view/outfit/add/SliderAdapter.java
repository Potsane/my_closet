package com.example.pmohale.mycloset.view.outfit.add;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.pmohale.mycloset.view.outfit.add.fragment.FirstFragment;
import com.example.pmohale.mycloset.view.outfit.add.fragment.SecondFrament;
import com.example.pmohale.mycloset.view.outfit.add.fragment.ThirdFragment;

/**
 * Created by PMohale on 2018/02/14.
 */

public class SliderAdapter extends FragmentStatePagerAdapter {

    private int numberOfSlides;

    public SliderAdapter(FragmentManager fragmentManager, int numberOfSlides) {
        super(fragmentManager);
        this.numberOfSlides = numberOfSlides;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FirstFragment slide1 = new FirstFragment();
                return slide1;
            case 1:
                SecondFrament slide2 = new SecondFrament();
                return slide2;
            case 2:
                ThirdFragment slide3 = new ThirdFragment();
                return slide3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfSlides;
    }
}
