package com.example.pmohale.mycloset.util;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by PMohale on 2018/02/12.
 */

public class Recommender {

    public static String recommendFormalTopItem(List<WardrobeItem> items) {

        if (items.size() == 0) {
            return "White Shirt";
        } else if (items.size() == 1) {
            return items.get(1).getColor() + " " + items.get(1).getType();
        } else {
            return items.get(randomizer(items.size())).getColor() + " " + items.get(items.size()).getType();
        }
    }

    public static String getTopFormalItemReccommendation(List<WardrobeItem> items) {

        System.out.println("number is " +items.size());
        List<WardrobeItem> formalTopItems = new ArrayList<>();

        if (items.size() == 0) {
            return "White Shirt";
        } else {

            for (WardrobeItem item : items) {

                System.out.println(item.getType()+"   "+item.getSuitableDressCode());
                String type = new String(item.getType());
                String itemType =  "Shirt";
                if (item.getType().equals(itemType)) {
                    formalTopItems.add(item);
                    System.out.println("++++++++++++++++++++++++");
                }
            }
            if (formalTopItems.size() == 0) {
                return "White Shirt";
            } else if (items.size() == 1) {
                return items.get(1).getColor() + " " + items.get(1).getType();
            } else {
                return items.get(randomizer(items.size())).getColor() + " " + items.get(items.size()).getType();
            }
        }
    }

    public static String getBottomFormalItemReccommendation(List<WardrobeItem> items) {

        List<WardrobeItem> formalTopItems = new ArrayList<>();

        if (items.size() == 0) {
            return "Blue Pants";
        } else {

            for (WardrobeItem item : items) {
                if (item.getType().equals("Pants") && item.getSuitableDressCode().equals("Formal")) {
                    formalTopItems.add(item);
                }
            }
            if (formalTopItems.size() == 0) {
                return "Blue Pants";
            } else if (items.size() == 1) {
                return items.get(1).getColor() + " " + items.get(1).getType();
            } else {
                return items.get(randomizer(items.size())).getColor() + " " + items.get(items.size()).getType();
            }
        }
    }

    private static int randomizer(int topBound) {
        Random random = new Random();
        int lowBound = 0;
        int result = random.nextInt(topBound - lowBound) + lowBound;
        return result-1;
    }
}
