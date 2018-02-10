package com.example.pmohale.mycloset.view.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.view.add.AddWardrobeItemActivity;

public class WardrobeItemsListActivity extends AppCompatActivity {

    private RecyclerView wardrobeItemsRecyclerView;

    private WardrobeItemsListAdapter wardrobeItemsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe_item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wardrobeItemsRecyclerView =

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(WardrobeItemsListActivity.this, AddWardrobeItemActivity.class));
            }
        });
    }

}
