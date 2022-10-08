package com.vothanhhai.apptonghopgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.vothanhhai.apptonghopgiuaki.model.DetailFood;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imgFood;
    private TextView tvName, tvRating, tvDes, tvprice;
    private DetailFood object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


}}
