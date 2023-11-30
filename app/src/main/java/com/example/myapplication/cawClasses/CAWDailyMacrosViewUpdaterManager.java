package com.example.myapplication.cawClasses;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class CAWDailyMacrosViewUpdaterManager {
    CAWDailyMacrosManager CAWDailyMacrosManager;
    View view;
    TextView totalCaloriesView;TextView breakfastCaloriesView;TextView lunchCaloriesView;TextView dinnerCaloriesView;TextView otherFoodsCaloriesView;
    TextView totalProteinView;TextView breakfastProteinView;TextView lunchProteinView;TextView dinnerProteinView;TextView otherFoodsProteinView;
    TextView totalFatView;TextView breakfastFatView;TextView lunchFatView;TextView dinnerFatView;TextView otherFoodsFatView;
    TextView totalCarbView;TextView breakfastCarbView;TextView lunchCarbView;TextView dinnerCarbView;TextView otherFoodsCarbView;
    ProgressBar TotalCaloriesProgressBar;
    public CAWDailyMacrosViewUpdaterManager(CAWDailyMacrosManager CAWDailyMacrosManager, View view) {
        this.CAWDailyMacrosManager = CAWDailyMacrosManager;
        this.view = view;
        this.totalCaloriesView = view.findViewById(R.id.caw_textview_totalcalories);
        this.breakfastCaloriesView = view.findViewById(R.id.caw_breakfast_textview_calories);
        this.lunchCaloriesView = view.findViewById(R.id.caw_lunch_textview_calories);
        this.dinnerCaloriesView = view.findViewById(R.id.caw_dinner_textview_calories);
        this.otherFoodsCaloriesView = view.findViewById(R.id.caw_otherfoods_textview_calories);
        this.totalProteinView = view.findViewById(R.id.caw_textview_totalprotein);
        this.totalFatView = view.findViewById(R.id.caw_textview_totalfat);
        this.totalCarbView = view.findViewById(R.id.caw_textview_totalcarb);
        this.breakfastProteinView = view.findViewById(R.id.caw_breakfast_textview_protein);
        this.lunchProteinView = view.findViewById(R.id.caw_lunch_textview_protein);
        this.dinnerProteinView = view.findViewById(R.id.caw_dinner_textview_protein);
        this.otherFoodsProteinView = view.findViewById(R.id.caw_otherfoods_textview_protein);
        this.breakfastFatView = view.findViewById(R.id.caw_breakfast_textview_fat);
        this.lunchFatView = view.findViewById(R.id.caw_lunch_textview_fat);
        this.dinnerFatView = view.findViewById(R.id.caw_dinner_textview_fat);
        this.otherFoodsFatView = view.findViewById(R.id.caw_otherfoods_textview_fat);
        this.breakfastCarbView = view.findViewById(R.id.caw_breakfast_textview_carb);
        this.lunchCarbView = view.findViewById(R.id.caw_lunch_textview_carb);
        this.dinnerCarbView = view.findViewById(R.id.caw_dinner_textview_carb);
        this.otherFoodsCarbView = view.findViewById(R.id.caw_otherfoods_textview_carb);

        this.TotalCaloriesProgressBar = view.findViewById(R.id.caw_totalcalories_progressbar);
    }

    public void updateViewOfTodayCalories(){
        breakfastCaloriesView.setText(String.valueOf((int)CAWDailyMacrosManager.getBreakfastCalories()));
        lunchCaloriesView.setText(String.valueOf((int)CAWDailyMacrosManager.getLunchCalories()));
        dinnerCaloriesView.setText(String.valueOf((int)CAWDailyMacrosManager.getDinnerCalories()));
        otherFoodsCaloriesView.setText(String.valueOf((int)CAWDailyMacrosManager.getOtherFoodsCalories()));

        totalProteinView.setText(String.valueOf((int)CAWDailyMacrosManager.getTotalProtein()));
        totalFatView.setText(String.valueOf((int)CAWDailyMacrosManager.getTotalFat()));
        totalCarbView.setText(String.valueOf((int)CAWDailyMacrosManager.getTotalCarb()));

        breakfastProteinView.setText(String.valueOf((int)CAWDailyMacrosManager.getBreakfastProtein()));
        lunchProteinView.setText(String.valueOf((int)CAWDailyMacrosManager.getLunchProtein()));
        dinnerProteinView.setText(String.valueOf((int)CAWDailyMacrosManager.getDinnerProtein()));
        otherFoodsProteinView.setText(String.valueOf((int)CAWDailyMacrosManager.getOtherFoodsProtein()));

        breakfastFatView.setText(String.valueOf((int)CAWDailyMacrosManager.getBreakfastFat()));
        lunchFatView.setText(String.valueOf((int)CAWDailyMacrosManager.getLunchFat()));
        dinnerFatView.setText(String.valueOf((int)CAWDailyMacrosManager.getDinnerFat()));
        otherFoodsFatView.setText(String.valueOf((int)CAWDailyMacrosManager.getOtherFoodsFat()));

        breakfastCarbView.setText(String.valueOf((int)CAWDailyMacrosManager.getBreakfastCarb()));
        lunchCarbView.setText(String.valueOf((int)CAWDailyMacrosManager.getLunchCarb()));
        dinnerCarbView.setText(String.valueOf((int)CAWDailyMacrosManager.getDinnerCarb()));
        otherFoodsCarbView.setText(String.valueOf((int)CAWDailyMacrosManager.getOtherFoodsCarb()));

        totalCaloriesView.setText((int)CAWDailyMacrosManager.getTotalCalories() +" из "+ (int)CAWDailyMacrosManager.getExpectedCalories());

        TotalCaloriesProgressBar.setProgress((int) CAWDailyMacrosManager.getProgress(), true);
    }
}
