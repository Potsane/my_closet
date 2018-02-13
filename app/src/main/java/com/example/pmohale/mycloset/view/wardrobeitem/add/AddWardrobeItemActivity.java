package com.example.pmohale.mycloset.view.wardrobeitem.add;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.view.wardrobeitem.list.WardrobeItemsListActivity;
import com.example.pmohale.mycloset.view.wardrobeitem.add.dialog.ItemTypePickerFragment;

public class AddWardrobeItemActivity extends AppCompatActivity implements View.OnFocusChangeListener, ItemTypePickerFragment.ListDialogListener {

    private static final String[] COLORS = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    private static final String[] ITEM_TYPES = {"T-Shirt", "Pants", "Top", "Jacket", "Coat", "Sweater", "Jeans", " Shirt", "Shorts"};

    private static final String[] WEATHER_CONDITIONS = {"Sunny", "Rainy", "Windy", "Cloudy"};

    private static final String[] DRESS_CODES = {"Casual", "Smart casual", "Formal"};

    private static final String ITEMS_DIALOG_TITTLE = "Pick item type";

    private static final String COLOR_DIALOG_TITTLE = "Pick item color";

    private static final String WEATHER_DIALOG_TITTLE = "Pick suitable weather condition";

    private static final String DRESS_CODE_DIALOG_TITTLE = "Pick suitable dress code";

    private EditText editTextItemType;

    private EditText editTextDescription;

    private EditText editTextColor;

    private EditText editTextDressCode;

    private EditText editTextWeatherCondition;

    private View focusedView;

    private AddWardrobeItemViewModel addWardrobeItemViewModel;

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

        editTextDressCode = findViewById(R.id.edit_text_dress_code);
        editTextDressCode.setOnFocusChangeListener(this);

        editTextWeatherCondition = findViewById(R.id.edit_text_weather_condition);
        editTextWeatherCondition.setOnFocusChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        addWardrobeItemViewModel = ViewModelProviders.of(this).get(AddWardrobeItemViewModel.class);
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

    //TODO: this is badly wtitten must refactor into a utility class
    @Override
    public void onFocusChange(View view, boolean hasFocus) {

        setFocusedView(view);

        if (view.getId() == R.id.edit_text_item_type && view.hasFocus()) {

            ItemTypePickerFragment pickerFragment = new ItemTypePickerFragment();
            Bundle arguements = new Bundle();
            arguements.putStringArray("list", ITEM_TYPES);
            arguements.putString("tittle", ITEMS_DIALOG_TITTLE);
            pickerFragment.setArguments(arguements);
            pickerFragment.show(getFragmentManager(), "Items type");
        }
        if (view.getId() == R.id.edit_text_color && view.hasFocus()) {

            ItemTypePickerFragment pickerFragment = new ItemTypePickerFragment();
            Bundle arguements = new Bundle();
            arguements.putStringArray("list", COLORS);
            arguements.putString("tittle", COLOR_DIALOG_TITTLE);
            pickerFragment.setArguments(arguements);
            pickerFragment.show(getFragmentManager(), "Items type");
        }
        if (view.getId() == R.id.edit_text_weather_condition && view.hasFocus()) {

            ItemTypePickerFragment pickerFragment = new ItemTypePickerFragment();
            Bundle arguements = new Bundle();
            arguements.putStringArray("list", WEATHER_CONDITIONS);
            arguements.putString("tittle", WEATHER_DIALOG_TITTLE);
            pickerFragment.setArguments(arguements);
            pickerFragment.show(getFragmentManager(), "Items type");
        }
        if (view.getId() == R.id.edit_text_dress_code && view.hasFocus()) {

            ItemTypePickerFragment pickerFragment = new ItemTypePickerFragment();
            Bundle arguements = new Bundle();
            arguements.putStringArray("list", DRESS_CODES);
            arguements.putString("tittle", DRESS_CODE_DIALOG_TITTLE);
            pickerFragment.setArguments(arguements);
            pickerFragment.show(getFragmentManager(), "Items type");
        }
    }

    @Override
    public void onSelectedDialogItem(String value) {
        EditText currentFocusedEditeText = (EditText) getFocusedView();
        currentFocusedEditeText.setText(value);
    }

    private View getFocusedView() {
        return focusedView;
    }

    private void setFocusedView(View focusedView) {
        this.focusedView = focusedView;
    }

    private void addWardrobeItem() {
        addWardrobeItemViewModel.addWardrobeItem(editTextItemType.getText().toString(), editTextDescription.getText().toString(), editTextColor.getText().toString(), editTextDressCode.getText().toString(), editTextWeatherCondition.getText().toString());
    }
}
