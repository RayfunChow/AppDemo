package com.example.asus.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    static boolean isLogin = false;
//
//    FButton btnSignin;
//    FButton btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnSignin = findViewById(R.id.btn_signin);
//        btnSignup = findViewById(R.id.btn_signup);
//
////        btnSignin.setCornerRadius(20);
//        btnSignin.setShadowEnabled(false);
////        btnSignin.setBackgroundColor(getResources().getColor(R.color.white));
//
//        btnSignup.setShadowEnabled(false);
////        btnSignup.setBackgroundColor(getResources().getColor(R.color.white));
//        //btnSignup.setCornerRadius(20);
//
//        btnSignup.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_signin:
//
//                break;
//            case R.id.btn_signup:
//                startActivity(new Intent(MainActivity.this, SignupActivity.class));
//                break;
//        }
//    }
}
