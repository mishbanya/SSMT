package com.example.myapplication.cawClasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Meal extends Food implements Parcelable {

    public enum MealType {
        BREAKFAST,
        LUNCH,
        DINNER,
        OTHERFOODS
    }
    private int mealId;
    private int weight;
    private MealType mealType;
    public Meal(Food food, int weight, MealType mealType, int mealId) {
        this.name  = food.getName();
        this.caloriesper100g = food.caloriesper100g;
        this.proteinper100g = food.proteinper100g;
        this.fatper100g = food.fatper100g;
        this.carbper100g = food.carbper100g;
        this.weight = weight;
        this.mealType = mealType;
        this.mealId = mealId;
    }
    public int getWeight() {return weight;}
    public MealType getMealType() {
        return mealType;
    }
    public int getMealId() {
        return mealId;
    }

    public void setCaloriesper100g(double caloriesper100g) {
        this.caloriesper100g = caloriesper100g;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getCalories() {
        return caloriesper100g * weight / 100;
    }
    public double getProtein() {return proteinper100g * weight / 100;}
    public double getFat() {return fatper100g * weight / 100;}
    public double getCarb() {return carbper100g * weight / 100;}


    protected Meal(Parcel in) {
        name = in.readString();
        weight = in.readInt();
        caloriesper100g = in.readDouble();
        proteinper100g = in.readDouble();
        fatper100g = in.readDouble();
        carbper100g = in.readDouble();
        mealId = in.readInt();
        switch (in.readString()){
            case "Breakfast":
                mealType = MealType.BREAKFAST;
                break;
            case "Lunch":
                mealType = MealType.LUNCH;
                break;
            case "Dinner":
                mealType = MealType.DINNER;
                break;
            case "OtherFoods":
                mealType = MealType.OTHERFOODS;
                break;
        }
    }
    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(weight);
        dest.writeDouble(caloriesper100g);
        dest.writeDouble(proteinper100g);
        dest.writeDouble(fatper100g);
        dest.writeDouble(carbper100g);
        dest.writeInt(mealId);
        switch (mealType){
            case BREAKFAST:
                dest.writeString("Breakfast");
                break;
            case LUNCH:
                dest.writeString("Lunch");
                break;
            case DINNER:
                dest.writeString("Dinner");
                break;
            case OTHERFOODS:
                dest.writeString("OtherFoods");
                break;
        }
    }
}
