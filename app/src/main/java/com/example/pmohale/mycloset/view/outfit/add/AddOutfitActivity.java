package com.example.pmohale.mycloset.view.outfit.add;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pmohale.mycloset.R;

public class AddOutfitActivity extends AppCompatActivity {

    private static final int NUMBER_OF_SLIDES = 4;

    private ViewPager sliderViewPager;

    private SliderAdapter sliderAdapter;

    private Button buttonNext;

    private Button buttonPrevious;

    private int currentSlideNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outfit);

        sliderViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        sliderViewPager.addOnPageChangeListener(viewLister);

        sliderAdapter = new SliderAdapter(getSupportFragmentManager(), NUMBER_OF_SLIDES);
        sliderViewPager.setAdapter(sliderAdapter);

        buttonNext = (Button) findViewById(R.id.button_next);
        buttonPrevious = (Button) findViewById(R.id.button_previous);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderViewPager.setCurrentItem(currentSlideNumber + 1);
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddOutfitActivity.this, "cliked", Toast.LENGTH_LONG).show();
                sliderViewPager.setCurrentItem(currentSlideNumber - 1);
            }
        });


    }

    ViewPager.OnPageChangeListener viewLister = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentSlideNumber = position;

            System.out.println("pos " + currentSlideNumber);
            if (currentSlideNumber == 0) {

                buttonNext.setEnabled(true);
                buttonPrevious.setEnabled(false);
                buttonPrevious.setVisibility(View.INVISIBLE);

                buttonNext.setText("Next");
                buttonPrevious.setText("");
            } else if (currentSlideNumber == NUMBER_OF_SLIDES - 1) {
                buttonNext.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonPrevious.setVisibility(View.VISIBLE);

                buttonNext.setText("Finish");
                buttonPrevious.setText("Previous");

            } else {
                buttonNext.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonPrevious.setVisibility(View.VISIBLE);

                buttonNext.setText("Next");
                buttonPrevious.setText("Previous");
                ;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

}
