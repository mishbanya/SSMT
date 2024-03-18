package com.example.myapplication.cawClasses;


import android.content.Context;

import java.io.Serializable;

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

    public CAWDailyMacrosManager(Context context) {
        MacrosPrefManager prefManager = new MacrosPrefManager(context);
        //prefManager.removeMacros();
        CAWDailyMacrosManager dailyMacrosManager = prefManager.getMacros();
        if(dailyMacrosManager!=null) {
            this.breakfastCalories = dailyMacrosManager.breakfastCalories;
            this.breakfastProtein = dailyMacrosManager.breakfastProtein;
            this.breakfastFat = dailyMacrosManager.breakfastFat;
            this.breakfastCarb = dailyMacrosManager.breakfastCarb;
            this.lunchCalories = dailyMacrosManager.lunchCalories;
            this.lunchProtein = dailyMacrosManager.lunchProtein;
            this.lunchFat = dailyMacrosManager.lunchFat;
            this.lunchCarb = dailyMacrosManager.lunchCarb;
            this.dinnerCalories = dailyMacrosManager.dinnerCalories;
            this.dinnerProtein = dailyMacrosManager.dinnerProtein;
            this.dinnerFat = dailyMacrosManager.dinnerFat;
            this.dinnerCarb = dailyMacrosManager.dinnerCarb;
            this.otherFoodsCalories = dailyMacrosManager.otherFoodsCalories;
            this.otherFoodsProtein = dailyMacrosManager.otherFoodsProtein;
            this.otherFoodsFat = dailyMacrosManager.otherFoodsFat;
            this.otherFoodsCarb = dailyMacrosManager.otherFoodsCarb;
            this.expectedCalories = dailyMacrosManager.expectedCalories;
        }else {
            this.breakfastCalories = 0;
            this.lunchCalories = 0;
            this.dinnerCalories = 0;
            this.otherFoodsCalories = 0;
            this.breakfastProtein = 0;
            this.lunchProtein = 0;
            this.dinnerProtein = 0;
            this.otherFoodsProtein = 0;
            this.breakfastFat = 0;
            this.lunchFat = 0;
            this.dinnerFat = 0;
            this.otherFoodsFat = 0;
            this.breakfastCarb = 0;
            this.lunchCarb = 0;
            this.dinnerCarb = 0;
            this.otherFoodsCarb = 0;
            this.expectedCalories = 2000;
        }
        this.Updater(context);
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
    public double getOtherFoodsProtein(){return this.otherFoodsProtein;}

    public double getTotalFat(){return this.totalFat;}
    public double getBreakfastFat(){return this.breakfastFat;}
    public double getLunchFat(){return this.lunchFat;}
    public double getDinnerFat(){return this.dinnerFat;}
    public double getOtherFoodsFat(){return this.otherFoodsFat;}

    public double getTotalCarb(){return this.totalCarb;}
    public double getBreakfastCarb(){return this.breakfastCarb;}
    public double getLunchCarb(){return this.lunchCarb;}
    public double getDinnerCarb(){return this.dinnerCarb;}
    public double getOtherFoodsCarb(){return this.otherFoodsCarb;}

    public double getExpectedCalories(){
        return this.expectedCalories;
    }
    public double getProgress(){ return this.totalCalories / (double)this.expectedCalories * 100;}
    public void setExpectedCalories(int expectedCalories, Context context){
        this.expectedCalories = expectedCalories;
        Updater(context);
    }
    public void addMealMacros(Meal meal, Context context){
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
        Updater(context);
    }
    public void Updater(Context context){
        this.totalCalories = this.breakfastCalories + this.lunchCalories + this.dinnerCalories + this.otherFoodsCalories;
        this.totalProtein = this.breakfastProtein + this.lunchProtein + this.dinnerProtein + this.otherFoodsProtein;
        this.totalFat = this.breakfastFat + this.lunchFat + this.dinnerFat + this.otherFoodsFat;
        this.totalCarb = this.breakfastCarb + this.lunchCarb + this.dinnerCarb + this.otherFoodsCarb;
        MacrosPrefManager prefManager = new MacrosPrefManager(context);
        prefManager.saveMacros(this);
    }
}
