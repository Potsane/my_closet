package com.example.pmohale.mycloset.view.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.entity.WardrobeItem;
import com.example.pmohale.mycloset.view.add.AddWardrobeItemActivity;
import com.example.pmohale.mycloset.viewmodel.WardrobeItemListViewModel;

import java.util.List;

public class WardrobeItemsListActivity extends AppCompatActivity {

    private RecyclerView wardrobeItemsRecyclerView;

    private WardrobeItemsListAdapter wardrobeItemsListAdapter;

    private WardrobeItemListViewModel wardrobeItemListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe_item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wardrobeItemsRecyclerView = findViewById(R.id.recycler_view_wardrobe_items);
        wardrobeItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        wardrobeItemsListAdapter = new WardrobeItemsListAdapter(null);
        wardrobeItemsRecyclerView.setAdapter(wardrobeItemsListAdapter);

        setUpButtons();
        setupViewModels();
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
        wardrobeItemListViewModel = ViewModelProviders.of(this).get(WardrobeItemListViewModel.class);

        wardrobeItemListViewModel.getAllWardrobeItems().observe(this, new Observer<List<WardrobeItem>>() {
            @Override
            public void onChanged(@Nullable List<WardrobeItem> wardrobeItems) {
                wardrobeItemsListAdapter.setWardrobeItems(wardrobeItems);
                System.out.println(wardrobeItemsListAdapter.getItemCount());
            }
        });
    }
}
