package com.example.shanmetta_tm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    EditText emailTxt, passwordTxt;

    Button loginBtn, regisBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        emailTxt = findViewById(R.id.email_txt);
        passwordTxt = findViewById(R.id.password_txt);
        loginBtn = findViewById(R.id.login_btn);
        regisBtn = findViewById(R.id.regis_btn);




        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = emailTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                final String[] emailArray = getResources().getStringArray(R.array.email);
                final String[] passwordArray = getResources().getStringArray(R.array.password);

                if (email.isEmpty()) {
                    emailTxt.setError("Email must be filled");
                } else if (!Arrays.asList(emailArray).contains(email)) {
                    emailTxt.setError("Email must be registered");
                } else if (password.isEmpty()) {
                    passwordTxt.setError("Password must be filled");
                }else if(!Arrays.asList(passwordArray).contains(password)){
                    passwordTxt.setError("password must be registered");
                } else{
                    Intent intent = new Intent(MainActivity.this, Homepages.class);
                    startActivity(intent);
                }

            }
        });

        regisBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Register.class);
              startActivity(intent);
          }
      });

    }



}



