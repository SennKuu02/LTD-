package com.example.bai2_tuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_Dangnhap;
    Button btn_Taotk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btn_Dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenProfile();
            }
        });
        btn_Taotk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenSignin();
            }
        });
    }
    private void OpenSignin() {
        Intent intent1 = new Intent(this, SigninActivity.class);
        startActivity(intent1);
    }
    private void OpenProfile() {
        Intent intent2 = new Intent(this, Profile.class);
        startActivity(intent2);
    }
    private void Anhxa(){
        btn_Dangnhap =(Button) findViewById(R.id.bt_dangnhap);
        btn_Taotk =(Button) findViewById(R.id.bt_taotk);
    }
}