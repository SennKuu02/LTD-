package com.vothanhhai.apptonghopgiuaki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.vothanhhai.apptonghopgiuaki.Adapter.MenuFoodAdapter;
import com.vothanhhai.apptonghopgiuaki.model.MenuFood;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView menuRCView;
    MenuFoodAdapter menuFoodAdapter;
    private Button btnSI, btnSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<MenuFood> menuFoodList = new ArrayList<>();


        menuFoodList.add(new MenuFood("Bánh Trôi Vietnam","$7.00",R.drawable.popularfood1,"4.5"));
        menuFoodList.add(new MenuFood("Đùi Gà","$9.00",R.drawable.popularfood2,"5"));
        menuFoodList.add(new MenuFood("Thịt Gà Tikka","$9.00",R.drawable.popularfood3,"3.5"));

        setFoodRCView(menuFoodList);

    }



    private void setFoodRCView(List<MenuFood> menuFoodList){
        menuRCView = findViewById(R.id.food_recycleview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        menuRCView.setLayoutManager(layoutManager);
        menuFoodAdapter = new MenuFoodAdapter(this,R.layout.menu_food_row_item,menuFoodList);
        setListAdapter(menuFoodAdapter);
    }



}