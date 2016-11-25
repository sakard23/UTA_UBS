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
    public static final String DATABASE_NAME= "ubsdb.db";
    public static final String MEMBER_TABLE_NAME="members_table";
    public static final String COL_0="RID";
    public static final String COL_1="FNAME";
    public static final String COL_2="LNAME";
    public static final String COL_3="EMAILID";
    public static final String COL_4="PHNUM";
    public static final String COL_5="NETID";
    public static final String COL_6="UNAME";
    public static final String COL_7="PW";

    //public static final String CLUB_8= "clubCreate.db";
    //public static final String CLUB_9="clubCreate_table";
    public static final String CLUB_TABLE_NAME="club_table";
    public static final String COL_10="CID";
    public static final String COL_11="CLUB_NAME";
    public static final String COL_12="ADMIN";
    public static final String COL_13="FUNCTION";

    private static DBHelper INSTANCE= null;
    private Context context;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;

        //SQLiteDatabase db= this.getWritableDatabase();//remove line for insertion line code
    }

    public static DBHelper getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("DROP TABLE IF EXISTS" + MEMBER_TABLE_NAME );
        //db.execSQL("DROP TABLE IF EXISTS" + CLUB_TABLE_NAME);
        db.execSQL("CREATE TABLE " + MEMBER_TABLE_NAME + "(RID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAILID TEXT," +
                "PHNUM TEXT, NETID TEXT, UNAME TEXT, PW TEXT)");
        db.execSQL("CREATE TABLE " + CLUB_TABLE_NAME +" (CID INTEGER PRIMARY KEY AUTOINCREMENT,CLUB_NAME TEXT,ADMIN TEXT,FUNCTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + MEMBER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CLUB_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertMemberData(String fname, String lname, String eid, String phnum, String netid, String uname, String pw ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, fname);
        contentValues.put(COL_2, lname);
        contentValues.put(COL_3, eid);
        contentValues.put(COL_4, phnum);
        contentValues.put(COL_5, netid);
        contentValues.put(COL_6, uname);
        contentValues.put(COL_7, pw);

        long result = db.insert(MEMBER_TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertClubData(String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11,cname);
        contentValues.put(COL_12,admin);
        contentValues.put(COL_13,func);
        long result = db.insert(CLUB_TABLE_NAME, null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getMemberAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+MEMBER_TABLE_NAME,null);
        return res;
    }

    public Cursor validateUser(String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+MEMBER_TABLE_NAME+" where UNAME = '" + userName+"' ",null);
        return res;
    }


    public Cursor getClubAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+CLUB_TABLE_NAME,null);
        return res;
    }
    public boolean updateMemberData(String cid,String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_10,cid);
        contentValues.put(COL_11,cname);
        contentValues.put(COL_12,admin);
        contentValues.put(COL_13,func);
        db.update(MEMBER_TABLE_NAME, contentValues, "ID = ?",new String[] { cid });
        return true;
    }
    public boolean updateClubData(String cid,String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_10,cid);
        contentValues.put(COL_11,cname);
        contentValues.put(COL_12,admin);
        contentValues.put(COL_13,func);
        db.update(CLUB_TABLE_NAME, contentValues, "ID = ?",new String[] { cid });
        return true;
    }
    public Integer deleteMemberData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(MEMBER_TABLE_NAME, "ID = ?",new String[] {id});
    }
    public Integer deleteClubData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CLUB_TABLE_NAME, "ID = ?",new String[] {id});
    }

}