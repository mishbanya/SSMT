package com.example.myapplication.cawClasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MealsPrefManager {
    private static final String MEALS_KEY = "meals";
    private Context context;
    private Gson gson;

    public MealsPrefManager(Context context) {
        this.context = context;
        this.gson = new Gson();
    }

    public void addMeal(Meal meal) {
        List<Meal> meals = getMeals();
        meals.add(meal);
        saveMealDetails(meal);
    }

    public void removeMeal(Meal meal) {
        List<Meal> meals = getMeals();
        for (Meal meal1 : meals) {
            if (meal1.getMealId() == meal.getMealId()) {
                meals.remove(meal);
                saveMealDetails(meals);
                return;
            }
        }
    }
    public void saveMealDetails(List<Meal> meals) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MEALS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String mealsJson = gson.toJson(meals);
        editor.putString(MEALS_KEY, mealsJson);
        editor.apply();
    }
    public List<Meal> getMeals() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MEALS_KEY, Context.MODE_PRIVATE);
        String mealsJson = sharedPreferences.getString(MEALS_KEY, "");

        if (!TextUtils.isEmpty(mealsJson)) {
            Type listType = new TypeToken<ArrayList<Meal>>() {}.getType();
            return gson.fromJson(mealsJson, listType);
        } else {
            return new ArrayList<>();
        }
    }
    public void removeAllMeals() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MEALS_KEY, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(MEALS_KEY).apply();
    }
}
