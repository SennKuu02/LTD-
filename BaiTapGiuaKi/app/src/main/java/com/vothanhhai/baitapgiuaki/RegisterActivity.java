package com.vothanhhai.baitapgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtUserName,edtPass, edtRePass;
    TextView tvLogin;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUserName=findViewById(R.id.edt_username);
        edtPass=findViewById(R.id.edt_pass);
        edtRePass=findViewById(R.id.edt_repass);
        btnSignup=findViewById(R.id.btn_sighup1);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    private void openHome() {

        if(edtUserName.getText().length() != 0 && edtPass.getText().length() != 0 && edtRePass.getText().length() != 0) {
               if(edtPass.getText() != edtRePass.getText()){
                   Toast.makeText(this, "Mật khẩu không trùng", Toast.LENGTH_SHORT).show();

            } else {
                   Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(this, LoginActivity.class);
                   startActivity(intent);
               }


        }else {
            Toast.makeText(RegisterActivity.this,"Bạn cần phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
    }

    private void openLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}