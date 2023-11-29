package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ActivityLogin extends AppCompatActivity {

    public String LOGIN = "admin";
    public String PASSWORD = "12345";
    public static Intent IntentActivityMainPage = new Intent(".ActivityMainPage");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addListenerOnButton();
    }
    public  void  addListenerOnButton(){
        Button buttonEnter = (Button) findViewById(R.id.login_button_enter);
        buttonEnter.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*TextInputEditText LoginEditTextLogin = (TextInputEditText)findViewById(R.id.login_edittext_login);
                    TextInputEditText LoginEditTextPassword = (TextInputEditText)findViewById(R.id.login_edittext_password);
                    if (LoginEditTextLogin.getText().toString().equals("")||LoginEditTextPassword.getText().toString().equals("")){
                        AlertError("Одно из полей пусто -_-");
                    }else {
                        if (LoginEditTextLogin.getText().toString().equals(LOGIN) && LoginEditTextPassword.getText().toString().equals(PASSWORD)) { */
                            startActivity(IntentActivityMainPage);
                        /*} else {
                            AlertError("Неверный логин или пароль");
                        }
                    }*/
                }
            }
        );
    }
    public void AlertError(String ErrorMessage){
        AlertDialog.Builder BuilderWrongLoginOrPassword = new AlertDialog.Builder(ActivityLogin.this);
        BuilderWrongLoginOrPassword.setTitle("Ошибка")
                .setIcon(R.drawable.error_icon)
                .setMessage(ErrorMessage)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog AlertWrongLoginOrPassword = BuilderWrongLoginOrPassword.create();
        AlertWrongLoginOrPassword.show();
    }
}