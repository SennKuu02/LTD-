package com.vothanhhai.baitapgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfiteActivity extends AppCompatActivity {

    ImageView imgBack;
    ImageView imgOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profite1);

        imgOff=findViewById(R.id.img_off);
        imgOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

        imgBack=findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backHome();
            }
        });
    }

    private void logOut() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void backHome() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}