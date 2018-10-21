package com.example.asus.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import info.hoang8f.widget.FButton;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    static boolean isLogin = false;

    FButton btnSignin;
    FButton btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        if(isLogin==false) {
            btnSignin = findViewById(R.id.btn_signin);
            btnSignup = findViewById(R.id.btn_signup);

            btnSignin.setShadowEnabled(false);
            btnSignup.setShadowEnabled(false);

            btnSignup.setOnClickListener(this);
            btnSignin.setOnClickListener(this);
        } else {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signin:
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                break;
            case R.id.btn_signup:
                startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
                break;
        }
    }
}
