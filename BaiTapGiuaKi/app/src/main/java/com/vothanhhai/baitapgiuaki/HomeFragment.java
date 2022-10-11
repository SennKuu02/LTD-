package com.vothanhhai.baitapgiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends ListFragment {

    MenuFoodAdapter adapter;
    ArrayList<MenuFood> menuFoodList;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Addarray();
        adapter = new MenuFoodAdapter(getActivity(),R.layout.menu_food_row_item,menuFoodList);
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick( ListView l,  View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(),DetailsActivity.class);
        startActivity(intent);
    }

    private void Addarray(){
        menuFoodList = new ArrayList<>();

        menuFoodList.add(new MenuFood("Bánh Trôi Vietnam","$7.00",R.drawable.popularfood1,"4.5"));
        menuFoodList.add(new MenuFood("Đùi Gà","$9.00",R.drawable.popularfood2,"5"));
        menuFoodList.add(new MenuFood("Thịt Gà Tikka","$9.00",R.drawable.popularfood3,"3.5"));
    }



}
