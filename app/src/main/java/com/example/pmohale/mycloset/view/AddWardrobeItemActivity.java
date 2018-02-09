package com.example.pmohale.mycloset.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.view.dialog.ItemTypePickerFragment;

public class AddWardrobeItemActivity extends AppCompatActivity implements View.OnFocusChangeListener, ItemTypePickerFragment.ListDialogListener {

    private EditText editTextItemType;

    private EditText editTextDescription;

    private EditText editTextColor;

    private EditText editTextSize;

    private EditText editTextBrand;

    private EditText editTextDressCode;

    private EditText editTextWeatherCondition;

    private EditText editTextDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wardrobe_item);

        editTextItemType = findViewById(R.id.edit_text_item_type);
        editTextItemType.setOnFocusChangeListener(this);

        editTextDescription = findViewById(R.id.edit_text_dscription);
        editTextDescription.setOnFocusChangeListener(this);

        editTextColor = findViewById(R.id.edit_text_color);
        editTextColor.setOnFocusChangeListener(this);

        editTextSize = findViewById(R.id.edit_text_size);
        editTextSize.setOnFocusChangeListener(this);

        editTextBrand = findViewById(R.id.edit_text_brand);
        editTextBrand.setOnFocusChangeListener(this);

        editTextDressCode = findViewById(R.id.edit_text_dress_code);
        editTextDressCode.setOnFocusChangeListener(this);

        editTextWeatherCondition = findViewById(R.id.edit_text_weather_condition);
        editTextWeatherCondition.setOnFocusChangeListener(this);

        editTextDate = findViewById(R.id.edit_text_date_acquired);
        editTextDate.setOnFocusChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_wardrobe_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, WardrobeItemActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {

        if (view.getId() == R.id.edit_text_item_type && view.hasFocus()) {

            ItemTypePickerFragment pickerFragment = new ItemTypePickerFragment();
            pickerFragment.show(getFragmentManager(), "Items type");
        }
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "cliked", Toast.LENGTH_LONG).show();
    }
}
