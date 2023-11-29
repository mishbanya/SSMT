package com.example.myapplication.cawClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;


public class CAWRecyclerAdapter extends RecyclerView.Adapter<CAWRecyclerAdapter.ViewHolder> {

    List<Meal> meals;
    private LayoutInflater Inflater;

    //TODO: Реализация кнопок настроек (изменение/удаление/еды)
    public CAWRecyclerAdapter(Context context, List<Meal> dataList) {
        this.Inflater = LayoutInflater.from(context);
        this.meals = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = Inflater.inflate(R.layout.item_caw_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Meal data = meals.get(position);
        holder.textViewName.setText(data.getName());
        holder.textViewCalories.setText(String.valueOf(data.getCalories()));
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
    public void MealAdded() {
        notifyItemInserted(meals.size() - 1);
    }
    public void MealsAdded() {
        notifyItemRangeInserted(0, meals.size() - 1);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewCalories;
        ImageButton buttonOptions;
        ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.item_meal_textview_name);
            textViewCalories = itemView.findViewById(R.id.item_meal_textview_calories);
            buttonOptions = itemView.findViewById(R.id.item_meal_button_options);
        }
    }
}