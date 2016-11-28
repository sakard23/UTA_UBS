package com.example.xakr.uta_ubs;

import static android.R.attr.bitmap;

/**
 * Created by Sushil on 11/27/2016.
 */

public class Item {
    private int itid;
    private String itname;
    private String price;
    private String details;
    private String eid;
    private String phnum;
    private byte[] photo;

    public Item(){};

    public int getItid() {
        return itid;
    }

    public void setItid(int itid) {
        this.itid = itid;
    }

    public String getItname() {
        return itname;
    }

    public void setItname(String itname) {
        this.itname = itname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
