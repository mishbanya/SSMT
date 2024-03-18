package com.example.myapplication.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.Activities.ActivityCAWFoodAdder;
import com.example.myapplication.Activities.ActivityGraphs;
import com.example.myapplication.R;
import com.example.myapplication.cawClasses.CAWDailyMacrosManager;
import com.example.myapplication.cawClasses.CAWDailyMacrosViewUpdaterManager;
import com.example.myapplication.cawClasses.Meal;
import com.example.myapplication.cawClasses.CAWMealsManager;
import com.example.myapplication.cawClasses.CAWRecyclerManager;

//TODO: делаем sharedpreference класс, сохраняем коллории этого дня
public class FragmentCaloriesAndWeight extends Fragment implements View.OnClickListener{

    private CAWMealsManager CAWMealsManager;
    private CAWDailyMacrosManager TodayMacros;
    private CAWRecyclerManager CAWrecyclerManager;
    private CAWDailyMacrosViewUpdaterManager todayMacrosViewUpdater;

    private final ActivityResultLauncher<Intent> ActivityCAWAdderResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        Meal returnedMeal = data.getParcelableExtra("meal");
                        assert returnedMeal != null;
                        TodayMacros.addMealMacros(returnedMeal, requireContext());
                        todayMacrosViewUpdater.updateViewOfTodayCalories();
                        CAWMealsManager.addMeal(returnedMeal);
                        CAWrecyclerManager.mealAdded(returnedMeal);
                    }
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View FragmentCAW = inflater.inflate(R.layout.fragment_calories_and_weight, container, false);

        CAWMealsManager = new CAWMealsManager(requireContext());
        TodayMacros =  new CAWDailyMacrosManager(requireContext());
        //TODO: CAWButtonManager

        ImageButton ButtonGraph = FragmentCAW.findViewById(R.id.caw_button_graph);
        ButtonGraph.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), ActivityGraphs.class);
            startActivity(intent);
        });

        Button BreakfastButtonExtend = FragmentCAW.findViewById(R.id.caw_breakfast_button_extend);
        Button LunchButtonExtend = FragmentCAW.findViewById(R.id.caw_lunch_button_extend);
        Button DinnerButtonExtend = FragmentCAW.findViewById(R.id.caw_dinner_button_extend);
        Button OtherFoodsButtonExtend = FragmentCAW.findViewById(R.id.caw_otherfoods_button_extend);

        BreakfastButtonExtend.setOnClickListener(this);
        LunchButtonExtend.setOnClickListener(this);
        DinnerButtonExtend.setOnClickListener(this);
        OtherFoodsButtonExtend.setOnClickListener(this);

        Button BreakfastButtonAddCalories = FragmentCAW.findViewById(R.id.caw_breakfast_button_addcalories);
        Button LunchButtonAddCalories = FragmentCAW.findViewById(R.id.caw_lunch_button_addcalories);
        Button DinnerButtonAddCalories = FragmentCAW.findViewById(R.id.caw_dinner_button_addcalories);
        Button OtherFoodsButtonAddCalories = FragmentCAW.findViewById(R.id.caw_otherfoods_button_addcalories);

        BreakfastButtonAddCalories.setOnClickListener(this);
        LunchButtonAddCalories.setOnClickListener(this);
        DinnerButtonAddCalories.setOnClickListener(this);
        OtherFoodsButtonAddCalories.setOnClickListener(this);

        Button ButtonSetExpectedCalories = FragmentCAW.findViewById(R.id.caw_button_setexpectedcalories);

        ButtonSetExpectedCalories.setOnClickListener(this);

        todayMacrosViewUpdater = new CAWDailyMacrosViewUpdaterManager(TodayMacros, FragmentCAW);
        CAWrecyclerManager = new CAWRecyclerManager(FragmentCAW, CAWMealsManager, requireContext());
        CAWrecyclerManager.updateMeals();

        return FragmentCAW;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        todayMacrosViewUpdater.updateViewOfTodayCalories();
    }

    @Override
    public void onClick(View view) {
        int buttonId = view.getId();
        if (buttonId == R.id.caw_breakfast_button_extend) {
            CAWrecyclerManager.recyclerExtender(requireView().findViewById(R.id.caw_breakfast_recycler),view);
        } else if (buttonId == R.id.caw_lunch_button_extend) {
            CAWrecyclerManager.recyclerExtender(requireView().findViewById(R.id.caw_lunch_recycler),view);
        } else if (buttonId == R.id.caw_dinner_button_extend) {
            CAWrecyclerManager.recyclerExtender(requireView().findViewById(R.id.caw_dinner_recycler),view);
        } else if (buttonId == R.id.caw_otherfoods_button_extend) {
            CAWrecyclerManager.recyclerExtender(requireView().findViewById(R.id.caw_otherfoods_recycler),view);
        }
        else if (buttonId == R.id.caw_breakfast_button_addcalories) {
            startCAWAdderActivity(Meal.MealType.BREAKFAST, CAWMealsManager.getMealsCount());
        } else if (buttonId == R.id.caw_lunch_button_addcalories) {
            startCAWAdderActivity(Meal.MealType.LUNCH, CAWMealsManager.getMealsCount());
        } else if (buttonId == R.id.caw_dinner_button_addcalories) {
            startCAWAdderActivity(Meal.MealType.DINNER, CAWMealsManager.getMealsCount());
        } else if (buttonId == R.id.caw_otherfoods_button_addcalories) {
            startCAWAdderActivity(Meal.MealType.OTHERFOODS, CAWMealsManager.getMealsCount());
        } else if (buttonId == R.id.caw_button_setexpectedcalories){
            expectedCaloriesEditingDialog();
        }
    }

    private void startCAWAdderActivity(Meal.MealType mealTypeFlag, int mealIDFlag) {
        Intent intent = new Intent(requireContext(), ActivityCAWFoodAdder.class);
        intent.putExtra("mealTypeFlag", mealTypeFlag);
        intent.putExtra("mealIDFlag", mealIDFlag);
        ActivityCAWAdderResultLauncher.launch(intent);
    }
    public void expectedCaloriesEditingDialog(){
        AlertDialog.Builder AlertName = new AlertDialog.Builder(requireView().getContext());
        final EditText EditTextName = new EditText(requireView().getContext());
        AlertName.setTitle("Введите количество калорий");
        AlertName.setView(EditTextName);
        AlertName.setPositiveButton("Ок", (dialog, whichButton) -> {
            String name = EditTextName.getText().toString();
            if (name.equals("")) {
                makeAToastMsg("Поле не может быть пустым");
            } else {
                TodayMacros.setExpectedCalories(Integer.parseInt(name), requireContext());
                todayMacrosViewUpdater.updateViewOfTodayCalories();
            }
        });
        AlertName.setNegativeButton("Отмена", (dialog, whichButton) -> {
        });
        AlertName.show();
    }

    public void makeAToastMsg(String txt) {
        Toast.makeText(requireView().getContext(), txt, Toast.LENGTH_SHORT).show();
    }
}