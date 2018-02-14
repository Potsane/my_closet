package com.example.pmohale.mycloset.view.outfit.add;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.pmohale.mycloset.R;

public class AddOutfitActivity extends AppCompatActivity {

    private ViewPager sliderViewPager;

    private SliderAdapter sliderAdapter;

    private static final int NUMBER_OF_SLIDES =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outfit);

        sliderViewPager = (ViewPager) findViewById(R.id.slideViewPager);

        sliderAdapter = new SliderAdapter(getSupportFragmentManager(), NUMBER_OF_SLIDES);
        sliderViewPager.setAdapter(sliderAdapter);
    }
}
