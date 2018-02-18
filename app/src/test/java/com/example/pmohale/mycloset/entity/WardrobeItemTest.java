package com.example.pmohale.mycloset.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.

/**
 * Created by PMohale on 2018/02/18.
 */
public class WardrobeItemTest {

    @Test
    public void shouldReturnItemType() {

        String expected = "T-Shirt";

        WardrobeItem wardrobeItem = new WardrobeItem("", expected, "", "", "");

        String actual = wardrobeItem.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnItemDescription() {

        String expected = "Test description";

        WardrobeItem wardrobeItem = new WardrobeItem(expected, "", "", "", "");

        String actual = wardrobeItem.getDescription();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnItemColor() {

        String expected = "Red";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", expected, "", "");

        String actual = wardrobeItem.getColor();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSuitableDressCode() {

        String expected = "Formal";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", expected, "");

        String actual = wardrobeItem.getSuitableDressCode();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSuitableWeatherCondition() {

        String expected = "Rainy";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", "", expected);

        String actual = wardrobeItem.getSuitableWeatherCondition();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetItemType() {

        String type = "T-Shirt";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", "", "");
        wardrobeItem.setType(type);

        String actual = wardrobeItem.getType();

        assertEquals(type, actual);
    }

    @Test
    public void shouldSetItemDescription() {

        String itemDescription = "Test description";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", "", "");
        wardrobeItem.setDescription(itemDescription);

        String actual = wardrobeItem.getDescription();

        assertEquals(itemDescription, actual);
    }

    @Test
    public void shouldSetItemColor() {

        String color = "Red";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", "", "");
        wardrobeItem.setColor(color);

        String actual = wardrobeItem.getColor();

        assertEquals(color, actual);
    }

    @Test
    public void shouldSetSuitableDressCode() {

        String dressCode = "Formal";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", "", "");
        wardrobeItem.setSuitableDressCode(dressCode);

        String actual = wardrobeItem.getSuitableDressCode();

        assertEquals(dressCode, actual);
    }

    @Test
    public void shouldSetSuitableWeatherCondition() {

        String weatherCondition = "Rainy";

        WardrobeItem wardrobeItem = new WardrobeItem("", "", "", "", "");
        wardrobeItem.setSuitableWeatherCondition(weatherCondition);

        String actual = wardrobeItem.getSuitableWeatherCondition();

        assertEquals(weatherCondition, actual);
    }

}