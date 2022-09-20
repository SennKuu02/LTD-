package com.vothanhhai.demolistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private Adapter_item adapter_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        adapter_item = new Adapter_item(this, getListUser());
        rcvData.setAdapter(adapter_item);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.salad,"Võ Thanh Hải 1","2050531200136"));
        list.add(new User(R.drawable.fastfood,"Võ Thanh Hải 2","2050531200136"));
        list.add(new User(R.drawable.hamburger,"Võ Thanh Hải 3","2050531200136"));
        list.add(new User(R.drawable.hot,"Võ Thanh Hải 4","2050531200136"));
        list.add(new User(R.drawable.burger,"Võ Thanh Hải 5","2050531200136"));

        return list;
    }
}