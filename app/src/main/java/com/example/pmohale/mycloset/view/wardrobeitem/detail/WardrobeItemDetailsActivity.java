package com.example.pmohale.mycloset.view.wardrobeitem.detail;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.injection.ClosetViewModelFactory;
import com.example.pmohale.mycloset.view.wardrobeitem.list.WardrobeItemsListActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class WardrobeItemDetailsActivity extends AppCompatActivity {

    @Inject
    ClosetViewModelFactory closetViewModelFactory;

    private WardrobeItemDetailsViewModel wardrobeItemDetailsViewModel;

    private TextView textViewItemColorAndType;

    private TextView textViewItemDescription;

    private TextView textViewSuitableWeatherConndition;

    private TextView textViewSuitableDressCode;

    private Button buttonDeleteItem;

    private long currentItemId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe_item_details2);

        Bundle extras = getIntent().getExtras();
        currentItemId = extras.getLong("id");

        textViewItemColorAndType = (TextView) findViewById(R.id.text_view_color_type);
        textViewItemDescription = (TextView) findViewById(R.id.text_view_description);
        textViewSuitableWeatherConndition = (TextView) findViewById(R.id.text_view_suitable_weather);
        textViewSuitableDressCode = (TextView) findViewById(R.id.text_view_dress_code);

        setupToolBar();
        setupBackButton();
        setupButtons();
        setupViewModels(currentItemId);
    }

    private void setupViewModels(long id) {
        wardrobeItemDetailsViewModel = ViewModelProviders.of(this, closetViewModelFactory).get(WardrobeItemDetailsViewModel.class);

        wardrobeItemDetailsViewModel.getWardrobeItem(id).observe(this, new Observer<WardrobeItem>() {
            @Override
            public void onChanged(@Nullable WardrobeItem wardrobeItem) {
                updateView(wardrobeItem);
            }
        });
    }

    private void updateView(WardrobeItem wardrobeItem) {
        textViewItemColorAndType.setText(wardrobeItem.getColor() + " " + wardrobeItem.getType());
        textViewItemDescription.setText(wardrobeItem.getDescription());
        textViewSuitableWeatherConndition.setText(wardrobeItem.getSuitableWeatherCondition());
        textViewSuitableDressCode.setText(wardrobeItem.getSuitableDressCode());
    }

    private void deleteCurrentItem() {
        wardrobeItemDetailsViewModel.deleteWardrobeItem(currentItemId);
        Intent intent = new Intent(WardrobeItemDetailsActivity.this, WardrobeItemsListActivity.class);
        startActivity(intent);
    }

    private void setupBackButton() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupButtons() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Item added to your favoyrites list", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buttonDeleteItem = (Button) findViewById(R.id.button_remove_item);
        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCurrentItem();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, WardrobeItemsListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
