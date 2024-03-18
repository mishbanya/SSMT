package com.example.myapplication.cawClasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MealsPrefManager {
    private String TODAY_MEALS_KEY = "meals";
    private final Context context;
    private final Gson gson;

    public MealsPrefManager(Context context) {
        this.context = context;
        this.gson = new Gson();
        TODAY_MEALS_KEY +=  new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    }

    public void addMeal(Meal meal) {
        List<Meal> meals = getMeals();
        meals.add(meal);
        saveMealDetails(meals);
    }

    public void removeMeal(int MealID) {
        List<Meal> meals = getMeals();
        for (Meal meal : meals) {
            if (meal.getMealId() == MealID) {
                meals.remove(meal);
                saveMealDetails(meals);
                return;
            }
        }
    }
    public void saveMealDetails(List<Meal> meals) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TODAY_MEALS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String mealsJson = gson.toJson(meals);
        editor.putString(TODAY_MEALS_KEY, mealsJson);
        editor.apply();
    }
    public List<Meal> getMeals() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TODAY_MEALS_KEY, Context.MODE_PRIVATE);
        String mealsJson = sharedPreferences.getString(TODAY_MEALS_KEY, "");

        if (!TextUtils.isEmpty(mealsJson)) {
            Type listType = new TypeToken<ArrayList<Meal>>() {}.getType();
            return gson.fromJson(mealsJson, listType);
        } else {
            return new ArrayList<>();
        }
    }
    public void removeAllMeals() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TODAY_MEALS_KEY, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(TODAY_MEALS_KEY).apply();
    }
}
