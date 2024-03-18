package com.example.myapplication.cawClasses;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CAWMealsManager {
    private List<Meal> breakfastMeals;
    private List<Meal> lunchMeals;
    private List<Meal> dinnerMeals;
    private List<Meal> otherFoodsMeals;

    private List<Meal> allMeals;

    Context context;
    MealsPrefManager prefManager;

    public CAWMealsManager(Context context) {
        this.context = context;
        prefManager = new MealsPrefManager(context);
        List<Meal> mealsfrompref = prefManager.getMeals();
        breakfastMeals = new ArrayList<>();
        lunchMeals = new ArrayList<>();
        dinnerMeals = new ArrayList<>();
        otherFoodsMeals = new ArrayList<>();
        allMeals = new ArrayList<>();
        for(Meal meal : mealsfrompref){
            this.addMeal(meal);
            prefManager.removeMeal(meal.getMealId());
        }
        updateAllMeals();
    }
    public List<Meal> getBreakfastMeals() {
        return breakfastMeals;
    }
    public List<Meal> getLunchMeals() {
        return lunchMeals;
    }
    public List<Meal> getDinnerMeals() {
        return dinnerMeals;
    }
    public List<Meal> getOtherFoodsMeals() {
        return otherFoodsMeals;
    }
    public int getMealsCount() {
        return allMeals.size();
    }
    public void updateAllMeals() {
        allMeals = new ArrayList<>();
        allMeals.addAll(breakfastMeals);
        allMeals.addAll(lunchMeals);
        allMeals.addAll(dinnerMeals);
        allMeals.addAll(otherFoodsMeals);
    }
    public void addMeal(Meal meal) {
        switch (meal.getMealType()) {
            case BREAKFAST:
                breakfastMeals.add(meal);
                break;
            case LUNCH:
                lunchMeals.add(meal);
                break;
            case DINNER:
                dinnerMeals.add(meal);
                break;
            case OTHERFOODS:
                otherFoodsMeals.add(meal);
                break;
        }
        allMeals.add(meal);
        prefManager.addMeal(meal);
    }
    public void removeMeal(int mealID){
        for (Meal meal : allMeals) {
            if (meal.getMealId() == mealID) {
                switch (meal.getMealType()) {
                    case BREAKFAST:
                        breakfastMeals.remove(meal);
                        break;
                    case LUNCH:
                        lunchMeals.remove(meal);
                        break;
                    case DINNER:
                        dinnerMeals.remove(meal);
                        break;
                    case OTHERFOODS:
                        otherFoodsMeals.remove(meal);
                        break;
                }
                allMeals.remove(meal);
                break;
            }
        }
        prefManager.removeMeal(mealID);
    }
}