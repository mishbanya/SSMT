package com.example.myapplication.cawClasses;


import android.os.Build;

import java.time.LocalDate;

public class CAWDailyMacrosManager {
    private double totalCalories;
    private double breakfastCalories;
    private double lunchCalories;
    private double dinnerCalories;
    private double otherFoodsCalories;
    private int expectedCalories;

    private double totalProtein;
    private double breakfastProtein;
    private double lunchProtein;
    private double dinnerProtein;
    private double otherFoodsProtein;
    private double totalFat;
    private double breakfastFat;
    private double lunchFat;
    private double dinnerFat;
    private double otherFoodsFat;
    private double totalCarb;
    private double breakfastCarb;
    private double lunchCarb;
    private double dinnerCarb;
    private double otherFoodsCarb;

    private LocalDate date;
    public CAWDailyMacrosManager(){
        this.breakfastCalories = 0;
        this.lunchCalories = 0;
        this.dinnerCalories = 0;
        this.otherFoodsCalories = 0;
        this.expectedCalories = 2000;
        this.Updater();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.date = LocalDate.now();
        }
    }
    public CAWDailyMacrosManager(int breakfastCalories, int lunchCalories, int dinnerCalories, int otherFoodsCalories, int expectedCalories, LocalDate date){
        this.breakfastCalories = breakfastCalories;
        this.lunchCalories = lunchCalories;
        this.dinnerCalories = dinnerCalories;
        this.otherFoodsCalories = otherFoodsCalories;
        this.expectedCalories = expectedCalories;
        this.Updater();
        this.date = date;
    }
    public double getTotalCalories(){
        return this.totalCalories;
    }
    public double getBreakfastCalories(){return this.breakfastCalories;}
    public double getLunchCalories(){return this.lunchCalories;}
    public double getDinnerCalories(){return this.dinnerCalories;} public double getOtherFoodsCalories(){return this.otherFoodsCalories;}

    public double getTotalProtein(){return this.totalProtein;}
    public double getBreakfastProtein(){return this.breakfastProtein;}
    public double getLunchProtein(){return this.lunchProtein;}
    public double getDinnerProtein(){return this.dinnerProtein;}

    public double getTotalFat(){return this.totalFat;}
    public double getBreakfastFat(){return this.breakfastFat;}
    public double getLunchFat(){return this.lunchFat;}
    public double getDinnerFat(){return this.dinnerFat;}

    public double getTotalCarb(){return this.totalCarb;}
    public double getBreakfastCarb(){return this.breakfastCarb;}
    public double getLunchCarb(){return this.lunchCarb;}
    public double getDinnerCarb(){return this.dinnerCarb;}

    public double getExpectedCalories(){
        return this.expectedCalories;
    }
    public double getProgress(){ return this.totalCalories / (double)this.expectedCalories * 100;}
    public LocalDate getDate(){
        return this.date;
    }
    public void setExpectedCalories(int expectedCalories){
        this.expectedCalories = expectedCalories;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public void addMealMacros(Meal meal){
        switch (meal.getMealType()){
            case BREAKFAST:
                this.breakfastCalories += meal.getCalories();
                this.breakfastProtein += meal.getProtein();
                this.breakfastFat += meal.getFat();
                this.breakfastCarb += meal.getCarb();
                break;
            case LUNCH:
                this.lunchCalories += meal.getCalories();
                this.lunchProtein += meal.getProtein();
                this.lunchFat += meal.getFat();
                this.lunchCarb += meal.getCarb();
                break;
            case DINNER:
                this.dinnerCalories += meal.getCalories();
                this.dinnerProtein += meal.getProtein();
                this.dinnerFat += meal.getFat();
                this.dinnerCarb += meal.getCarb();
                break;
            case OTHERFOODS:
                this.otherFoodsCalories += meal.getCalories();
                this.otherFoodsProtein += meal.getProtein();
                this.otherFoodsFat += meal.getFat();
                this.otherFoodsCarb += meal.getCarb();
                break;
        }
        Updater();
    }
    public void Updater(){
        this.totalCalories = this.breakfastCalories + this.lunchCalories + this.dinnerCalories + this.otherFoodsCalories;
        this.totalProtein = this.breakfastProtein + this.lunchProtein + this.dinnerProtein + this.otherFoodsProtein;
        this.totalFat = this.breakfastFat + this.lunchFat + this.dinnerFat + this.otherFoodsFat;
        this.totalCarb = this.breakfastCarb + this.lunchCarb + this.dinnerCarb + this.otherFoodsCarb;
    }
}
