package com.example.myapplication.cawClasses;


import java.util.ArrayList;
import java.util.List;

public class CAWMealsManager {
    private List<Meal> breakfastMeals;
    private List<Meal> lunchMeals;
    private List<Meal> dinnerMeals;
    private List<Meal> otherFoodsMeals;

    private List<Meal> allMeals;

    public CAWMealsManager(List<Meal> breakfastMeals, List<Meal> lunchMeals, List<Meal> dinnerMeals, List<Meal> otherFoodsMeals) {
        this.breakfastMeals = breakfastMeals;
        this.lunchMeals = lunchMeals;
        this.dinnerMeals = dinnerMeals;
        this.otherFoodsMeals = otherFoodsMeals;
        updateAllMeals();
    }
    public CAWMealsManager() {
        breakfastMeals = new ArrayList<>();
        lunchMeals = new ArrayList<>();
        dinnerMeals = new ArrayList<>();
        otherFoodsMeals = new ArrayList<>();
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
    }
}