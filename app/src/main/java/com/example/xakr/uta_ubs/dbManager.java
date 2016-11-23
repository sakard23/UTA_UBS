package com.example.xakr.uta_ubs;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sushil on 11/23/2016.
 */

public class dbManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="ubs.db";
    private static final String TABLE_USERS="users";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_FIRSTNAME="_firstName";
    public static final String COLUMN_LASTNAME="_lastName";
    public static final String COLUMN_DOB="_dob";
    public static final String COLUMN_EMAIL="_email";
    public static final String COLUMN_NETID="_netId";
    public static final String COLUMN_PHONE="_phone";
    public static final String COLUMN_USERNAME="_userName";
    public static final String COLUMN_PASSWORD="_password";


    public dbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE" + TABLE_USERS+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT"+
                COLUMN_FIRSTNAME+"TEXT"+
                COLUMN_LASTNAME+"TEXT"+
                COLUMN_DOB+"TEXT"+
                COLUMN_EMAIL+"TEXT"+
                COLUMN_PHONE+"TEXT"+
                COLUMN_USERNAME+"TEXT"+
                COLUMN_PASSWORD+"TEXT"+
                COLUMN_NETID+"TEXT"+");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(User user){
        ContentValues values= new ContentValues();
        values.put(COLUMN_FIRSTNAME,user.get_fisrtName());
        values.put(COLUMN_LASTNAME,user.get_lastName());
        values.put(COLUMN_DOB,user.get_dob());
        values.put(COLUMN_EMAIL,user.get_email());
        values.put(COLUMN_PHONE,user.get_phone());
        values.put(COLUMN_USERNAME,user.get_userName());
        values.put(COLUMN_PASSWORD,user.get_password());
        values.put(COLUMN_NETID,user.get_netId());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_USERS,null,values);
        db.close();
    }
}

