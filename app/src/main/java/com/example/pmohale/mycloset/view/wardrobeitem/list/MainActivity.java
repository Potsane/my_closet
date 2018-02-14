package com.example.pmohale.mycloset.view.wardrobeitem.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.util.Recommender;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainActivityListViewModel mainActivityListViewModel;

    private TextView textViewTopFormalItemReccommendation;

    private TextView textViewBottomFormalItemReccommendation;

    private TextView textViewTopCasualItemReccommendation;

    private TextView textViewBottomCasualItemReccommendation;

    private Button buttonViewMoreFormalReccommendations;

    private int itemCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupViews();

        setupViewModels();

    }

    private void setupViews() {

        textViewTopFormalItemReccommendation = (TextView) findViewById(R.id.text_view_top_formal_item);
        textViewBottomFormalItemReccommendation = (TextView) findViewById(R.id.text_view_bottom_formal_item);
        textViewTopCasualItemReccommendation = (TextView) findViewById(R.id.text_view_top_casual_item);
        textViewBottomCasualItemReccommendation = (TextView) findViewById(R.id.text_view_bottom_casual_item);


        buttonViewMoreFormalReccommendations = (Button) findViewById(R.id.button_view_more_formal_items);
        buttonViewMoreFormalReccommendations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void setupViewModels() {
        mainActivityListViewModel = ViewModelProviders.of(this).get(MainActivityListViewModel.class);

        mainActivityListViewModel.getItemsByDressCode("Formal").observe(this, new Observer<List<WardrobeItem>>() {
            @Override
            public void onChanged(@Nullable List<WardrobeItem> items) {
                setFormalItemsRecommendations(items);
            }
        });
    }

    private void setFormalItemsRecommendations(List<WardrobeItem> items) {

        itemCursor = 1;
        textViewTopFormalItemReccommendation.setText(Recommender.getTopFormalItemReccommendation(items, itemCursor));
        textViewBottomFormalItemReccommendation.setText(Recommender.getBottomFormalItemReccommendation(items, itemCursor));
        textViewTopCasualItemReccommendation.setText(Recommender.getTopCasualItemReccommendation(items, itemCursor));
        textViewBottomCasualItemReccommendation.setText(Recommender.getBottomCasualItemReccommendation(items, itemCursor));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_my_closet) {
            startActivity(new Intent(this, WardrobeItemsListActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
