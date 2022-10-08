package com.vothanhhai.baitapgiuaki;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vothanhhai.baitapgiuaki.model.DetailFood;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imgFood;
    private TextView tvName, tvRating, tvDes, tvprice;
    private DetailFood object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


}}
