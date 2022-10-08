package com.vothanhhai.baitapgiuaki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vothanhhai.baitapgiuaki.Adapter.MenuFoodAdapter;
import com.vothanhhai.baitapgiuaki.model.MenuFood;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       btnLogin=findViewById(R.id.btn_login);
       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openLogin();
           }
       });

        btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });


    }

    private void openSignup() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void openLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}