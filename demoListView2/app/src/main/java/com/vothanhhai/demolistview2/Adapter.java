package com.vothanhhai.demolistview2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {


    Context context;
    private String mtitle[];
    LayoutInflater inflater;
    private Activity activity;

    public Adapter(String[] mtitle, Activity activity) {
        this.mtitle = mtitle;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.detail,null);
        TextView tvname = (TextView) view.findViewById(R.id.tvname);
        tvname.setText(mtitle[i]);
        return view;
    }
}
