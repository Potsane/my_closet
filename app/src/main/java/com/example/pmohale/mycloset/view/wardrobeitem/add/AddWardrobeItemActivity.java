package com.example.pmohale.mycloset.view.wardrobeitem.add;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.view.wardrobeitem.list.WardrobeItemsListActivity;

public class AddWardrobeItemActivity extends AppCompatActivity {

    private Spinner spinnerItemType;

    private Spinner spinnerItemColor;

    private Spinner spinnerSuitableWeather;

    private Spinner spinnerDressCode;

    private EditText editTextDescription;

    private AddWardrobeItemViewModel addWardrobeItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wardrobe_item);

        setupSpinners();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        addWardrobeItemViewModel = ViewModelProviders.of(this).get(AddWardrobeItemViewModel.class);
    }

    private void setupSpinners() {
        spinnerItemType = (Spinner) findViewById(R.id.spinner_item_type);
        spinnerItemColor = (Spinner) findViewById(R.id.spinner_item_color);
        spinnerSuitableWeather = (Spinner) findViewById(R.id.spinner_weather_condition);
        spinnerDressCode = (Spinner) findViewById(R.id.spinner_dress_code);
        editTextDescription = (EditText) findViewById(R.id.edit_text_dscription);

        ArrayAdapter itemsColorAdapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        itemsColorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItemColor.setAdapter(itemsColorAdapter);

        ArrayAdapter itemTypesAdapter = ArrayAdapter.createFromResource(this,
                R.array.item_types_array, android.R.layout.simple_spinner_item);
        itemTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItemType.setAdapter(itemTypesAdapter);

        ArrayAdapter suitableWeatherConditionsAdapotor = ArrayAdapter.createFromResource(this,
                R.array.weather_conditions_array, android.R.layout.simple_spinner_item);
        suitableWeatherConditionsAdapotor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSuitableWeather.setAdapter(suitableWeatherConditionsAdapotor);

        ArrayAdapter dressCodeAdapter = ArrayAdapter.createFromResource(this,
                R.array.dress_code_array, android.R.layout.simple_spinner_item);
        dressCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDressCode.setAdapter(dressCodeAdapter);
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
                Intent intent = new Intent(this, WardrobeItemsListActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_add_item:
                addWardrobeItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addWardrobeItem() {
        addWardrobeItemViewModel.addWardrobeItem(spinnerItemType.getSelectedItem().toString(), editTextDescription.getText().toString(), spinnerItemColor.getSelectedItem().toString(), spinnerDressCode.getSelectedItem().toString(), spinnerSuitableWeather.getSelectedItem().toString());
        Toast.makeText(this, "Succssfully added item", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddWardrobeItemActivity.this, WardrobeItemsListActivity.class);
        startActivity(intent);
    }
}
