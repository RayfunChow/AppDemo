package com.example.asus.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import info.hoang8f.widget.FButton;

public class LoginActivity extends AppCompatActivity {

    FButton fbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fbLogin=findViewById(R.id.fb_login);
        fbLogin.setShadowEnabled(false);
    }


//    private void login() {
//        if(){
//            WelcomeActivity.isLogin=true;
//        }
//    }
}
