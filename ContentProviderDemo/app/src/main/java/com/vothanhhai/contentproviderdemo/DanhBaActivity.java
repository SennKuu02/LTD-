package com.vothanhhai.contentproviderdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vothanhhai.Detail;
import com.vothanhhai.model.Contact;

import java.util.ArrayList;

import com.vothanhhai.model.Contact;

public class DanhBaActivity extends AppCompatActivity {

    ListView lvDanhBa;
    ArrayList<Contact>dsDanhBa;
    ArrayAdapter<Contact>adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        addEvents();

        lvDanhBa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0) {
                    startActivity(new Intent(DanhBaActivity.this,Detail.class));
                }

            }
        });

        showAllContactFromDevice();
    }


    private void showAllContactFromDevice() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            String tenCotName=ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone=ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vtTenCotName=cursor.getColumnIndex(tenCotName);
            int vtTenCotPhone=cursor.getColumnIndex(tenCotPhone);
            String name=cursor.getString(vtTenCotName);
            String phone=cursor.getString(vtTenCotPhone);
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
        }
        adapterDanhBa.notifyDataSetChanged();
    }

    private void addEvents() {
    }

    private void addControls() {
        lvDanhBa = findViewById(R.id.lv_danhba);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<Contact>(
                DanhBaActivity.this,
                android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);

    }

}