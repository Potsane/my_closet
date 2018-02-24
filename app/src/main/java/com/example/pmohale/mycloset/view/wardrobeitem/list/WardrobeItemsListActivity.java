package com.example.pmohale.mycloset.view.wardrobeitem.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.injection.ClosetViewModelFactory;
import com.example.pmohale.mycloset.view.wardrobeitem.add.AddWardrobeItemActivity;
import com.example.pmohale.mycloset.view.wardrobeitem.detail.WardrobeItemDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class WardrobeItemsListActivity extends AppCompatActivity implements HasSupportFragmentInjector, WardrobeItemsListAdapter.WardrobeItemsListAdapterOnItemClickHandler {

    private RecyclerView wardrobeItemsRecyclerView;

    private WardrobeItemsListAdapter wardrobeItemsListAdapter;

    @Inject
    ClosetViewModelFactory closetViewModelFactory;

    WardrobeItemsListViewModel wardrobeItemsListViewModel;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe_item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        wardrobeItemsRecyclerView = findViewById(R.id.recycler_view_wardrobe_items);
        wardrobeItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        wardrobeItemsListAdapter = new WardrobeItemsListAdapter(null, this);
        wardrobeItemsRecyclerView.setAdapter(wardrobeItemsListAdapter);

        setUpButtons();
        setupViewModels();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_wardrobe_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void setUpButtons() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WardrobeItemsListActivity.this, AddWardrobeItemActivity.class));
            }
        });
    }

    private void setupViewModels() {
        wardrobeItemsListViewModel = ViewModelProviders.of(this, closetViewModelFactory).get(WardrobeItemsListViewModel.class);

        wardrobeItemsListViewModel.getAllWardrobeItems().observe(this, new Observer<List<WardrobeItem>>() {
            @Override
            public void onChanged(@Nullable List<WardrobeItem> wardrobeItems) {
                wardrobeItemsListAdapter.setWardrobeItems(wardrobeItems);
            }
        });
    }


    @Override
    public void onItemClick(long id) {
        Intent wardrobeItemDetailsIntent = new Intent(this, WardrobeItemDetailsActivity.class);
        wardrobeItemDetailsIntent.putExtra("id", id);
        startActivity(wardrobeItemDetailsIntent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
