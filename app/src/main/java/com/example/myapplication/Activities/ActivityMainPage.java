package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Fragments.FragmentCaloriesAndWeight;
import com.example.myapplication.Fragments.FragmentGym;
import com.example.myapplication.Fragments.FragmentSocials;
import com.example.myapplication.R;

public class ActivityMainPage extends AppCompatActivity implements
        View.OnClickListener {
    public FragmentCaloriesAndWeight fragmentCaloriesAndWeight = new FragmentCaloriesAndWeight();
    public FragmentGym fragmentGym = new FragmentGym();
    public FragmentSocials fragmentSocials = new FragmentSocials();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        Button buttonPage1 = findViewById(R.id.button_fragment_caw);
        Button buttonPage2 = findViewById(R.id.button_fragment_gym);
        Button buttonPage3 = findViewById(R.id.button_fragment_socials);

        fragmentReplacer(fragmentCaloriesAndWeight, buttonPage1, buttonPage2, buttonPage3, 1);

        buttonPage1.setOnClickListener(this);
        buttonPage2.setOnClickListener(this);
        buttonPage3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Button ButtonFragmentCAW = findViewById(R.id.button_fragment_caw);
        Button ButtonFragmentGym = findViewById(R.id.button_fragment_gym);
        Button ButtonFragmentSocials = findViewById(R.id.button_fragment_socials);
        if (v == ButtonFragmentCAW) {
            fragmentReplacer(fragmentCaloriesAndWeight, ButtonFragmentCAW, ButtonFragmentGym, ButtonFragmentSocials, 1);
        } else if (v == ButtonFragmentGym) {
            fragmentReplacer(fragmentGym, ButtonFragmentCAW, ButtonFragmentGym, ButtonFragmentSocials, 2);
        } else if (v == ButtonFragmentSocials) {
            fragmentReplacer(fragmentSocials, ButtonFragmentCAW, ButtonFragmentGym, ButtonFragmentSocials, 3);
        }
    }

    public void fragmentReplacer(Fragment fragment, Button button1, Button button2, Button button3, int buttonNumber) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_fragmentfitter, fragment);
        fragmentTransaction.commit();
        switch (buttonNumber) {
            case 1:
                button1.setBackground(getDrawable(R.drawable.main_page_buttons_active));
                button2.setBackground(getDrawable(R.drawable.main_page_buttons));
                button3.setBackground(getDrawable(R.drawable.main_page_buttons));
                break;
            case 2:
                button2.setBackground(getDrawable(R.drawable.main_page_buttons_active));
                button1.setBackground(getDrawable(R.drawable.main_page_buttons));
                button3.setBackground(getDrawable(R.drawable.main_page_buttons));
                break;
            case 3:
                button3.setBackground(getDrawable(R.drawable.main_page_buttons_active));
                button1.setBackground(getDrawable(R.drawable.main_page_buttons));
                button2.setBackground(getDrawable(R.drawable.main_page_buttons));
                break;
        }
    }
    public void MakeAToastMsg(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }
}