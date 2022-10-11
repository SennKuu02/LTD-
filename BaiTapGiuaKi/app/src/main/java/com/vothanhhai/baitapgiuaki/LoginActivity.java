package com.vothanhhai.baitapgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName,edtPass;
    TextView tvSigup;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btn_login1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });

        edtUserName=findViewById(R.id.edt_username);
        edtPass=findViewById(R.id.edt_pass);


        tvSigup=findViewById(R.id.tv_signup);
        tvSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });

    }

    private void openHome() {
        if(edtUserName.getText().length() != 0 && edtUserName.getText().length() != 0){
            if(edtUserName.getText().toString().equals("thanhhai") && edtPass.getText().toString().equals("123")){
                Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(LoginActivity.this, "Bạn cần nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        }
    }

    private void openSignup() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
}