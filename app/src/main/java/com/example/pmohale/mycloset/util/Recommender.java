package com.example.pmohale.mycloset.util;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PMohale on 2018/02/12.
 */

public class Recommender {

    public static String getTopFormalItemReccommendation(List<WardrobeItem> items, int cursor) {

        List<WardrobeItem> formalTopItems = new ArrayList<>();

        if (items.size() == 0) {
            return "White Shirt";
        } else if (items.size() == 1) {

            return items.get(0).getColor() + " " + items.get(0).getType();
        } else {
            return items.get(cursor).getColor() + " " + items.get(cursor).getType();
        }
    }

    public static String getBottomFormalItemReccommendation(List<WardrobeItem> items, int cursor) {

        List<WardrobeItem> formalTopItems = new ArrayList<>();

        if (items.size() == 0) {
            return "Blue Pants";
        } else if (items.size() == 1) {

            return items.get(0).getColor() + " " + items.get(0).getType();
        } else {
            return items.get(cursor).getColor() + " " + items.get(cursor).getType();
        }
    }

    public static String getTopCasualItemReccommendation(List<WardrobeItem> items, int cursor) {

        List<WardrobeItem> formalTopItems = new ArrayList<>();

        if (items.size() == 0) {
            return "Blue T-Shirt";
        } else if (items.size() == 1) {

            return items.get(0).getColor() + " " + items.get(0).getType();
        } else {
            return items.get(cursor).getColor() + " " + items.get(cursor).getType();
        }
    }
    public static String getBottomCasualItemReccommendation(List<WardrobeItem> items, int cursor) {

        List<WardrobeItem> formalTopItems = new ArrayList<>();

        if (items.size() == 0) {
            return "Blue Jeans";
        } else if (items.size() == 1) {

            return items.get(0).getColor() + " " + items.get(0).getType();
        } else {
            return items.get(cursor).getColor() + " " + items.get(cursor).getType();
        }
    }
}

