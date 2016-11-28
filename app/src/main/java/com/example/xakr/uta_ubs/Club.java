package com.example.xakr.uta_ubs;

/**
 * Created by Sushil on 11/27/2016.
 */

public class Club {
    private int cid;
    private String cname;
    private String admin;
    private String function;

    public Club(){};

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
