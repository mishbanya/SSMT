package com.example.myapplication.cawClasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MacrosPrefManager {
    private String TODAY_MACROS_KEY = "macros";
    private final Context context;
    private final Gson gson;

    public MacrosPrefManager(Context context) {
        this.context = context;
        this.gson = new Gson();
        TODAY_MACROS_KEY +=  new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    }
    public void saveMacros(CAWDailyMacrosManager cawDailyMacrosManager) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TODAY_MACROS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        this.removeMacros();
        String macrosJson = gson.toJson(cawDailyMacrosManager);
        editor.putString(TODAY_MACROS_KEY, macrosJson);
        editor.apply();
    }
    public CAWDailyMacrosManager getMacros() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TODAY_MACROS_KEY, Context.MODE_PRIVATE);
        String macrosJson = sharedPreferences.getString(TODAY_MACROS_KEY, "");

        if (!TextUtils.isEmpty(macrosJson)) {
            Type managerType = new TypeToken<CAWDailyMacrosManager>() {}.getType();
            return gson.fromJson(macrosJson, managerType);
        } else {
            return null;
        }
    }
    public void removeMacros() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TODAY_MACROS_KEY, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(TODAY_MACROS_KEY).apply();
    }
}
