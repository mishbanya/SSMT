package com.example.myapplication.cawClasses;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class CAWRecyclerManager {
    CAWRecyclerAdapter breakfastCAWRecyclerAdapter;
    CAWRecyclerAdapter lunchCAWRecyclerAdapter;
    CAWRecyclerAdapter dinnerCAWRecyclerAdapter;
    CAWRecyclerAdapter otherFoodsCAWRecyclerAdapter;
    public CAWRecyclerManager(View Fragment, CAWMealsManager CAWMealsManager, Context context) {
        RecyclerView BreakfastRecycler = Fragment.findViewById(R.id.caw_breakfast_recycler);
        RecyclerView LunchRecycler = Fragment.findViewById(R.id.caw_lunch_recycler);
        RecyclerView DinnerRecycler = Fragment.findViewById(R.id.caw_dinner_recycler);
        RecyclerView OtherFoodsRecycler = Fragment.findViewById(R.id.caw_otherfoods_recycler);

        breakfastCAWRecyclerAdapter = new CAWRecyclerAdapter(context, CAWMealsManager.getBreakfastMeals());
        BreakfastRecycler.setAdapter(breakfastCAWRecyclerAdapter);
        BreakfastRecycler.setLayoutManager(new LinearLayoutManager(context));
        lunchCAWRecyclerAdapter = new CAWRecyclerAdapter(context, CAWMealsManager.getLunchMeals());
        LunchRecycler.setAdapter(lunchCAWRecyclerAdapter);
        LunchRecycler.setLayoutManager(new LinearLayoutManager(context));
        dinnerCAWRecyclerAdapter = new CAWRecyclerAdapter(context, CAWMealsManager.getDinnerMeals());
        DinnerRecycler.setAdapter(dinnerCAWRecyclerAdapter);
        DinnerRecycler.setLayoutManager(new LinearLayoutManager(context));
        otherFoodsCAWRecyclerAdapter = new CAWRecyclerAdapter(context, CAWMealsManager.getOtherFoodsMeals());
        OtherFoodsRecycler.setAdapter(otherFoodsCAWRecyclerAdapter);
        OtherFoodsRecycler.setLayoutManager(new LinearLayoutManager(context));
    }
    public void recyclerExtender(RecyclerView recyclerView, View view){
        ViewGroup.LayoutParams RecyclerViewParams = recyclerView.getLayoutParams();
        if(RecyclerViewParams.height == 0) {
            RecyclerViewParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            view.setBackgroundResource(R.drawable.caw_hide_foods_button);
        }else{
            RecyclerViewParams.height =  0;
            view.setBackgroundResource(R.drawable.caw_show_foods_button);
        }
        recyclerView.setLayoutParams(RecyclerViewParams);
    }
    public void updateMeals(){
        breakfastCAWRecyclerAdapter.MealsAdded();
        lunchCAWRecyclerAdapter.MealsAdded();
        dinnerCAWRecyclerAdapter.MealsAdded();
        otherFoodsCAWRecyclerAdapter.MealsAdded();
    }
    public void mealAdded(Meal meal){
        switch (meal.getMealType()) {
            case BREAKFAST:
                breakfastCAWRecyclerAdapter.MealAdded();
                break;
            case LUNCH:
                lunchCAWRecyclerAdapter.MealAdded();
                break;
            case DINNER:
                dinnerCAWRecyclerAdapter.MealAdded();
                break;
            case OTHERFOODS:
                otherFoodsCAWRecyclerAdapter.MealAdded();
                break;
        }
    }
}