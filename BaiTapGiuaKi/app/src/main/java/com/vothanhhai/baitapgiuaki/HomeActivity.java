package com.vothanhhai.baitapgiuaki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vothanhhai.baitapgiuaki.Adapter.MenuFoodAdapter;
import com.vothanhhai.baitapgiuaki.model.MenuFood;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView menuRCView;
    MenuFoodAdapter menuFoodAdapter;
    ImageView imgProfite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        imgProfite=findViewById(R.id.img_profite);
        imgProfite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfite();
            }
        });

        List<MenuFood> menuFoodList = new ArrayList<>();


        menuFoodList.add(new MenuFood("Bánh Trôi Vietnam","$7.00",R.drawable.popularfood1,"4.5"));
        menuFoodList.add(new MenuFood("Đùi Gà","$9.00",R.drawable.popularfood2,"5"));
        menuFoodList.add(new MenuFood("Thịt Gà Tikka","$9.00",R.drawable.popularfood3,"3.5"));

        setFoodRCView(menuFoodList);

    }

    private void openProfite() {
        Intent intent = new Intent(this,ProfiteActivity.class);
        startActivity(intent);
    }


    private void setFoodRCView(List<MenuFood> menuFoodList){
        menuRCView = findViewById(R.id.food_recycleview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        menuRCView.setLayoutManager(layoutManager);
        menuFoodAdapter = new MenuFoodAdapter(this,menuFoodList);
        menuRCView.setAdapter(menuFoodAdapter);
    }

}
