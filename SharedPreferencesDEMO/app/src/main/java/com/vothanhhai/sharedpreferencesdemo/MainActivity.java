package com.vothanhhai.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnXacNhan;
    EditText edtTaikhoan, edtMatkhau;
    CheckBox cbGhinho;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

        //Lấy giá trị sharedPreferences
        edtTaikhoan.setText(sharedPreferences.getString("taikhoan",""));
        edtMatkhau.setText(sharedPreferences.getString("matkhau",""));
        cbGhinho.setChecked(sharedPreferences.getBoolean("checked",false));


        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edtTaikhoan.getText() .toString() .trim();
                String matkhau  = edtMatkhau.getText() .toString() .trim();

                if (taikhoan.equals("thanhhai") && matkhau.equals("123123")) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    //Nếu có check
                    if (cbGhinho.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", taikhoan);
                        editor.putString("matkhau", matkhau);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        btnXacNhan = (Button) findViewById(R.id.bt_xacnhan);
        edtTaikhoan = (EditText) findViewById(R.id.editDN);
        edtMatkhau = (EditText) findViewById(R.id.editMK);
        cbGhinho = (CheckBox) findViewById(R.id.cb_ghinho);
    }
}