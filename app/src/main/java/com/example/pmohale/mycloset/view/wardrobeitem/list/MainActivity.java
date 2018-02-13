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

        textViewTopFormalItemReccommendation = (TextView) findViewById(R.id.text_view_top_formal_item);
        textViewBottomFormalItemReccommendation = (TextView) findViewById(R.id.text_view_bottom_formal_item);

        setupViewModels();

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

        textViewTopFormalItemReccommendation.setText(Recommender.getTopFormalItemReccommendation(items));
        textViewBottomFormalItemReccommendation.setText(Recommender.getBottomFormalItemReccommendation(items));
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
