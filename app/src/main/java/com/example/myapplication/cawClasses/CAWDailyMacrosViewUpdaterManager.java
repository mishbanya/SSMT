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
    //TODO: Раскомментировать, когда будет готовa разметка для БЖУ
    public CAWDailyMacrosViewUpdaterManager(CAWDailyMacrosManager CAWDailyMacrosManager, View view) {
        this.CAWDailyMacrosManager = CAWDailyMacrosManager;
        this.view = view;
        this.totalCaloriesView = view.findViewById(R.id.caw_textview_totalcalories);
        this.breakfastCaloriesView = view.findViewById(R.id.caw_breakfast_textview_calories);
        this.lunchCaloriesView = view.findViewById(R.id.caw_lunch_textview_calories);
        this.dinnerCaloriesView = view.findViewById(R.id.caw_dinner_textview_calories);
        this.otherFoodsCaloriesView = view.findViewById(R.id.caw_otherfoods_textview_calories);
        /*this.totalProteinView = view.findViewById(R.id.caw_textview_totalprotein);
        this.breakfastProteinView = view.findViewById(R.id.caw_breakfast_textview_protein);
        this.lunchProteinView = view.findViewById(R.id.caw_lunch_textview_protein);
        this.dinnerProteinView = view.findViewById(R.id.caw_dinner_textview_protein);
        this.otherFoodsProteinView = view.findViewById(R.id.caw_otherfoods_textview_protein);
        this.totalFatView = view.findViewById(R.id.caw_textview_totalfat);
        this.breakfastFatView = view.findViewById(R.id.caw_breakfast_textview_fat);
        this.lunchFatView = view.findViewById(R.id.caw_lunch_textview_fat);
        this.dinnerFatView = view.findViewById(R.id.caw_dinner_textview_fat);
        this.otherFoodsFatView = view.findViewById(R.id.caw_otherfoods_textview_fat);
        this.totalCarbView = view.findViewById(R.id.caw_textview_totalcarb);
        this.breakfastCarbView = view.findViewById(R.id.caw_breakfast_textview_carb);
        this.lunchCarbView = view.findViewById(R.id.caw_lunch_textview_carb);
        this.dinnerCarbView = view.findViewById(R.id.caw_dinner_textview_carb);
        this.otherFoodsCarbView = view.findViewById(R.id.caw_otherfoods_textview_carb);*/

        this.TotalCaloriesProgressBar = view.findViewById(R.id.caw_totalcalories_progressbar);
    }

    public void updateViewOfTodayCalories(){
        breakfastCaloriesView.setText(String.valueOf(CAWDailyMacrosManager.getBreakfastCalories()));
        lunchCaloriesView.setText(String.valueOf(CAWDailyMacrosManager.getLunchCalories()));
        dinnerCaloriesView.setText(String.valueOf(CAWDailyMacrosManager.getDinnerCalories()));
        otherFoodsCaloriesView.setText(String.valueOf(CAWDailyMacrosManager.getOtherFoodsCalories()));

        /*totalProteinView.setText(String.valueOf(CAWDailyMacrosManager.getTotalProtein()));
        breakfastProteinView.setText(String.valueOf(CAWDailyMacrosManager.getBreakfastProtein()));
        lunchProteinView.setText(String.valueOf(CAWDailyMacrosManager.getLunchProtein()));
        dinnerProteinView.setText(String.valueOf(CAWDailyMacrosManager.getDinnerProtein()));

        totalFatView.setText(String.valueOf(CAWDailyMacrosManager.getTotalFat()));
        breakfastFatView.setText(String.valueOf(CAWDailyMacrosManager.getBreakfastFat()));
        lunchFatView.setText(String.valueOf(CAWDailyMacrosManager.getLunchFat()));
        dinnerFatView.setText(String.valueOf(CAWDailyMacrosManager.getDinnerFat()));

        totalCarbView.setText(String.valueOf(CAWDailyMacrosManager.getTotalCarb()));
        breakfastCarbView.setText(String.valueOf(CAWDailyMacrosManager.getBreakfastCarb()));
        lunchCarbView.setText(String.valueOf(CAWDailyMacrosManager.getLunchCarb()));
        dinnerCarbView.setText(String.valueOf(CAWDailyMacrosManager.getDinnerCarb()));*/

        totalCaloriesView.setText(CAWDailyMacrosManager.getTotalCalories() +" из "+ CAWDailyMacrosManager.getExpectedCalories());

        TotalCaloriesProgressBar.setProgress((int) CAWDailyMacrosManager.getProgress(), true);
    }
}
