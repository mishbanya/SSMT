package com.example.myapplication.faClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.cawClasses.Food;
import com.example.myapplication.cawClasses.Meal;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Objects;

public class FARecyclerAdapter extends RecyclerView.Adapter<FARecyclerAdapter.ViewHolder> {

    private static List<Food> foods;
    private LayoutInflater inflater;
    private static OnItemClickListener clickListener;
    private static Meal.MealType mealTypeFlag;
    private static int mealIDFlag;

    public FARecyclerAdapter(Context context, List<Food> foodList, Meal.MealType mealTypeFlag, int mealIDFlag, OnItemClickListener clickListener) {
        this.inflater = LayoutInflater.from(context);
        this.foods = foodList;
        this.mealTypeFlag = mealTypeFlag;
        this.clickListener = clickListener;
        this.mealIDFlag = mealIDFlag;
    }

    public interface OnItemClickListener {
        void onItemClick(Meal meal);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_fa_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = foods.get(position);
        holder.textViewName.setText(food.getName());
        holder.textViewCaloriesPer100g.setText(String.valueOf(food.getCaloriesper100g()));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public void FoodsAdded(int count) {
        notifyItemRangeInserted(foods.size() - count, count);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewCaloriesPer100g;
        TextInputEditText editTextWeight;
        Button buttonAdd;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.item_fa_textview_name);
            textViewCaloriesPer100g = itemView.findViewById(R.id.item_fa_textview_caloriesper100g);
            editTextWeight = itemView.findViewById(R.id.item_fa_edittext_weight);
            buttonAdd = itemView.findViewById(R.id.item_fa_button_add);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && clickListener != null) {

                        Food food = foods.get(position);
                        int weight = Integer.parseInt(Objects.requireNonNull(editTextWeight.getText()).toString());
                        Meal meal = new Meal(food.getName(), food.getCaloriesper100g(), weight, mealTypeFlag, mealIDFlag);
                        clickListener.onItemClick(meal);
                    }
                }
            });
        }
    }
}