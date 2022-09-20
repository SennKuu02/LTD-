package com.vothanhhai.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }

        User user = (User) bundle.get("object_user");
        TextView tvNameUser= findViewById(R.id.tv_user);
        tvNameUser.setText(user.getTen());
        ImageView imgAvata = findViewById(R.id.img_avatar);
        imgAvata.setImageResource(user.getResourceId());

    }
}