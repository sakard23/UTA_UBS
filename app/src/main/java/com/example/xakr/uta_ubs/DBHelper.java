package com.example.xakr.uta_ubs;

/**
 * Created by xakR on 11/25/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME= "members.db";
    public static final String TABLE_NAME="members_table";
    public static final String COL_0="RID";
    public static final String COL_1="FNAME";
    public static final String COL_2="LNAME";
    public static final String COL_3="EMAILID";
    public static final String COL_4="PHNUM";
    public static final String COL_5="NETID";
    public static final String COL_6="UNAME";
    public static final String COL_7="PW";

    public static final String CLUB_DATABASE_NAME= "clubCreate.db";
    public static final String CLUB_TABLE_NAME="clubCreate_table";
    public static final String COL_Cid="CID";
    public static final String COL_Cname="CLUB_NAME";
    public static final String COL_Admin="ADMIN";
    public static final String COL_Pur="PURPOSE";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db= this.getWritableDatabase();//remove line for insertion line code
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(RID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAILID TEXT," +
                "PHNUM TEXT, NETID TEXT, UNAME TEXT, PW TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname, String lname, String eid, String phnum, String netid, String uname, String pw ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, fname);
        contentValues.put(COL_2, lname);
        contentValues.put(COL_3, eid);
        contentValues.put(COL_4, phnum);
        contentValues.put(COL_5, netid);
        contentValues.put(COL_6, uname);
        contentValues.put(COL_7, pw);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
/*
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query=("select * from"+TABLE_NAME);
        Cursor res=db.rawQuery(query,null);
        return  res;
    }

    public boolean updateData(String id, String fname, String lname, String netid){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, lname);
        contentValues.put(COL_4, netid);
        db.update(TABLE_NAME,contentValues,"id = ?", new String[]{id});
        return true;
    }*/
}