package com.vothanhhai.baitapgiuaki;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends MenuActivity {

    private ImageView imgFood;
    private TextView tvName, tvRating, tvDes, tvprice;
    private DetailFood object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        initview();
        tvRating.setText(getIntent().getStringExtra("rating"));
        tvprice.setText(getIntent().getStringExtra("price"));
        tvName.setText(getIntent().getStringExtra("name"));
        imgFood.setImageResource(getIntent().getIntExtra("image",0));



}



    private void initview() {
        imgFood= findViewById(R.id.img_food);
        tvName = findViewById(R.id.tv_name);
        tvDes= findViewById(R.id.tv_description);
        tvprice=findViewById(R.id.tv_price);
        tvRating=findViewById(R.id.tv_rating1);
    }
}
