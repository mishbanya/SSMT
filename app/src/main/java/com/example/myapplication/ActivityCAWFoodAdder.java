package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.cawClasses.Food;
import com.example.myapplication.cawClasses.Meal;
import com.example.myapplication.faClasses.FARecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityCAWFoodAdder extends AppCompatActivity implements FARecyclerAdapter.OnItemClickListener {

    private List<Food> foods;
    private FARecyclerAdapter faRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_adder);

        Intent intent = getIntent();
        Meal.MealType mealTypeFlag = (Meal.MealType) intent.getSerializableExtra("mealTypeFlag");
        int mealIDFlag = intent.getIntExtra("mealIDFlag", -1);
        if (mealTypeFlag == null || mealIDFlag == -1) {
            throw new RuntimeException("mealTypeFlag or mealIDFlag is null");
        }
        RecyclerView faRecycler = findViewById(R.id.fa_recycler);

        foods = new ArrayList<>();
        faRecyclerAdapter = new FARecyclerAdapter(this, foods, mealTypeFlag, mealIDFlag, this::onItemClick);
        faRecycler.setAdapter(faRecyclerAdapter);
        faRecycler.setLayoutManager(new LinearLayoutManager(this));

        fillFoods();
    }

    public void fillFoods() {
        foods.add(new Food("Картошка", 80, 1, 1, 1));
        foods.add(new Food("Мясо", 200, 1, 1, 1));
        foods.add(new Food("Рис", 100, 1, 1, 1));
        foods.add(new Food("Курица", 150, 1, 1, 1));
        foods.add(new Food("Гречка", 100, 1, 1, 1));
        faRecyclerAdapter.FoodsAdded(5);
    }

    @Override
    public void onItemClick(Meal meal) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("meal", meal);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}