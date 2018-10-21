package com.example.asus.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.CircularProgressButton;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    static String name;
    static String passwd;
    static String email;
    static String repsd;
    EditText edUserName;
    EditText edUserPwd;
    EditText edRePsd;
    EditText edEmail;
    Button btnLogin;
    //MorphingButton mb_signup;
    Button btnSignup;
    CircularProgressButton cbpSubmit;
    //CheckBox checked;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        edUserName=findViewById(R.id.et_userName);
        edUserPwd=findViewById(R.id.et_userPwd);
        edRePsd=findViewById(R.id.rePasswd);
        edEmail=findViewById(R.id.et_email);
        //btnSignup=findViewById(R.id.btn_login);
        btnLogin=findViewById(R.id.btn_login);
        cbpSubmit=findViewById(R.id.cpb_submit);
        //checked=(CheckBox) findViewById(R.id.check);
//        ed_userPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());
//        ed_rePsd.setTransformationMethod(PasswordTransformationMethod.getInstance());

        edUserName.setText("Rayfun");
        edEmail.setText("rayfun@gmail.com");
        edUserPwd.setText("123456");
        edRePsd.setText("123456");

        cbpSubmit.setProgress(0);
        cbpSubmit.setIdleText("提交信息");
        cbpSubmit.setCompleteText("注册成功！");


        cbpSubmit.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
//        ActionBar actionBar = this.getSupportActionBar();
//        actionBar.setTitle("创建新用户");
//        actionBar.setDisplayHomeAsUpEnabled(true);

//        checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    //方法1
//                    //userPsd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    //rePsd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    //方法2
//                    userPsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                    rePsd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                } else {
//                    //方法1
//                    //userPsd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    //rePsd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    //方法2
//                    userPsd.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                    rePsd.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });

//        cbp_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                name=ed_userName.getText().toString();
//                passwd=ed_rePsd.getText().toString();
//                repsd=ed_rePsd.getText().toString();
//                email=ed_email.getText().toString();
//
//                if (validate()) {
//                    cbp_submit.setProgress(100);
//                    Toast.makeText(SignupActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                    finish();
//                } else {
//
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cpb_submit:
                name=edUserName.getText().toString();
                passwd=edUserPwd.getText().toString();
                repsd=edRePsd.getText().toString();
                email=edEmail.getText().toString();

                if (validate()) {
                    cbpSubmit.setIndeterminateProgressMode(true);
                    cbpSubmit.setProgress(CircularProgressButton.INDETERMINATE_STATE_PROGRESS);

                    cbpSubmit.setClickable(false);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(SignupActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }, 800);

                } else {
                    Toast.makeText(SignupActivity.this, "您输入的信息有误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_login:
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
        }
    }

    @Override
    public void onBackPressed() {

        name=edUserName.getText().toString();
        passwd=edUserPwd.getText().toString();
        repsd=edRePsd.getText().toString();
        email=edEmail.getText().toString();

        if (!name.equals("") || !passwd.equals("") || !repsd.equals("") || !email.equals("")) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(SignupActivity.this)
                .setMessage("你输入的数据将不会被保存")
                .setCancelable(true)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SignupActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        dialog.show();
        }
        else {
            finish();
        }
    }

    public boolean validate() {

        valid = true;

        if (name.isEmpty()) {
            edUserName.setError("请输入用户名");
            valid = false;
        } else {
            edUserName.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edEmail.setError("请输入邮箱地址");
            valid = false;
        } else {
            edEmail.setError(null);
        }

        if (passwd.isEmpty() || passwd.length() < 6 || passwd.length() > 16) {
            edUserPwd.setError("密码长度应为6~16位");
            valid = false;
        } else {
            edUserPwd.setError(null);
        }

        if (!passwd.equals(repsd)) {
            edRePsd.setError("两次输入的密码不匹配");
            valid = false;
        } else {
            edRePsd.setError(null);
        }

        return valid;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
