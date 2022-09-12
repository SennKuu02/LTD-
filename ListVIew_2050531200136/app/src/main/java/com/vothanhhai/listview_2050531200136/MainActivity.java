package com.vothanhhai.listview_2050531200136;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    Button btnThem;
    Button btnCapNhat;
    Button btnXoa;
    EditText editMonHoc;
    ArrayList<String> arrayCourse;

    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnXoa = (Button)  findViewById(R.id.btnXoa);
        editMonHoc = (EditText) findViewById(R.id.editTextMonHoc);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Androi");
        arrayCourse.add("iOS");
        arrayCourse.add("PHP");
        arrayCourse.add("Unity");
        arrayCourse.add("ASP.NET");

        ArrayAdapter adapter = new ArrayAdapter
                (MainActivity.this,
                        android.R.layout.simple_expandable_list_item_1,
                        arrayCourse);

        lvMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = editMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { String monhoc = editMonHoc.getText().toString();
                 arrayCourse.set(vitri, editMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri=i;
                doOpenChildActivity();
                return false;
            }
        });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent = new Intent(this, ChildActivity.class);
       editMonHoc.setText(arrayCourse.get(vitri));
        myIntent.putExtra("dulieu",""+editMonHoc.getText());
        startActivity(myIntent);
    }
}
