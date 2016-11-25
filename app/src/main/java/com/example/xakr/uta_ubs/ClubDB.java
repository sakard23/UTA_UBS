package com.example.xakr.uta_ubs;

/**
 * Created by xakR on 11/25/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*

public class ClubDB extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "members.db";
    public static final String TABLE_NAME = "members_table";
    public static final String COL_1 = "CID";
    public static final String COL_2 = "CLUB_NAME";
    public static final String COL_3 = "ADMIN";
    public static final String COL_4 = "FUNCTION";

    public ClubDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,CLUB_NAME TEXT,ADMIN TEXT,FUNCTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,cname);
        contentValues.put(COL_3,admin);
        contentValues.put(COL_4,func);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String cid,String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,cid);
        contentValues.put(COL_2,cname);
        contentValues.put(COL_3,admin);
        contentValues.put(COL_4,func);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { cid });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}*/
