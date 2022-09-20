package com.vothanhhai.demolistview;

import android.widget.SeekBar;

import java.io.Serializable;

public class User implements Serializable {

    private int resourceId;
    private String ten;
    private String mota;

    public User(int resourceId, String ten, String mota) {
        this.resourceId = resourceId;
        this.ten = ten;
        this.mota = mota;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
